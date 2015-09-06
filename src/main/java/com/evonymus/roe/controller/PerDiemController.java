package com.evonymus.roe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.evonymus.roe.beans.CalculationBean;
import com.evonymus.roe.model.PerDiem;
import com.evonymus.roe.service.CountryService;
import com.evonymus.roe.service.PerDiemService;
import com.evonymus.roe.service.RoeService;

@Controller
@EnableWebMvc
@RequestMapping("/perDiem")
public class PerDiemController {
    private final static long MS_IN_DAY = 86400000;
    private final static long MS_IN_HOUR = 3600000;
    private final static double BREAKFAST_DEDUCTION = 0.15d;
    @Autowired
    private PerDiemService perDiemService; 

    @Autowired
    private CountryService countryService;

    @Autowired
    private RoeService roeService;

    @RequestMapping(value="/{idCountry}", method=RequestMethod.GET)
    public @ResponseBody PerDiem getCountryPerDiem(@PathVariable("idCountry")int idCountry) {
        return perDiemService.getCountryPerDiem(idCountry);
    }

    @RequestMapping(value="/{from}/{to}/{idCountry}/{breakfast}", method=RequestMethod.GET)
    public @ResponseBody CalculationBean getCalculation(@PathVariable("from") long from
            , @PathVariable("to")long to
            , @PathVariable("idCountry") int idCountry
            , @PathVariable("breakfast")int breakfast) {

        int days = 0;
        int hours = 0;
        Date dateFrom = new Date(from);
        Date dateTo = new Date(to);
        double coefficient = 0.0d;
        double totalPerDiem = 0.0d;
        double dueInPLN = 0.0d;
    
        CalculationBean result = new CalculationBean();
        long diff = dateTo.getTime() - dateFrom.getTime();
        if(diff>0) {
            
            // calculating the number of full days
            days = (int) Math.floor(diff/MS_IN_DAY); 
            hours = (int)Math.floor((diff - days * MS_IN_DAY)/MS_IN_HOUR);
            breakfast = breakfast > days ? days : breakfast;

            if (hours > 12) {
                coefficient =  1;
            } else if (hours >8 && hours <=12) {
                coefficient =  0.5d;
            } else if (hours > 0 && hours <=8) {
                coefficient =  0.3333d;
            }

            result.setDateFrom(dateFrom);
            result.setDateTo(dateTo);
            result.setDays(days);
            result.setHours(hours);
            result.setCountry(countryService.getCountry(idCountry));
            result.setPerDiem(perDiemService.getCountryPerDiem(idCountry));
            totalPerDiem = Math.round((days * result.getPerDiem().getRate() 
                        + coefficient * result.getPerDiem().getRate()) * 100) / 100.0;
            result.setBreakfastDeduction(Math.round((days - breakfast) * result.getPerDiem().getRate() * BREAKFAST_DEDUCTION * 100)/100);
            result.setTotalPerDiem(totalPerDiem);
            result.setDueInCurrency(totalPerDiem - result.getBreakfastDeduction());
            result.setRoe(roeService.getRoeForDay(dateTo, result.getPerDiem().getCurrency().getCode()));
            dueInPLN = Math.round(result.getRoe().getRoe() * result.getDueInCurrency() * 100)/100.0;
            result.setDueInPLN(dueInPLN);
        }

        return result;

    }
}
