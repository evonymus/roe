package com.evonymus.roe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

@Controller
@EnableWebMvc
@RequestMapping("/perDiem")
public class PerDiemController {
    private final static long MS_IN_DAY = 86400000;
    private final static long MS_IN_HOUR = 3600000;
    @Autowired
    private PerDiemService perDiemService; 

    @Autowired
    private CountryService countryService;

    @RequestMapping(value="/{idCountry}", method=RequestMethod.GET)
    public @ResponseBody PerDiem getCountryPerDiem(@PathVariable("idCountry")int idCountry) {
        return perDiemService.getCountryPerDiem(idCountry);
    }

    @RequestMapping(value="/{dateFrom}/{dateTo}/{idCountry}", method=RequestMethod.GET)
    public @ResponseBody CalculationBean getCalculation(@PathVariable("dateFrom")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date dateFrom
            , @PathVariable("dateTo")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")Date dateTo
            , @PathVariable("idCountry") int idCountry) {

        int days = 0;
        int hours = 0;
        float coefficient = 1.0f;
        CalculationBean result = new CalculationBean();
        long diff = dateTo.getTime() - dateFrom.getTime();
        if(diff>0) {
            
            // calculating the number of full days
            days = (int) Math.floor(diff/MS_IN_DAY); 
            hours = (int)Math.floor((diff - result.getDays() * MS_IN_DAY)/MS_IN_HOUR);

            if (hours > 12) {
                coefficient = days + 1;
            } else if (hours >8 && hours <=12) {
                coefficient = days + 0.5f;
            } else if (hours > 0 && hours <=8) {
                coefficient = days + 0.33f;
            }

            result.setDateFrom(dateFrom);
            result.setDateTo(dateTo);
            result.setDays(days);
            result.setHours(hours);
            result.setCountry(countryService.getCountry(idCountry));
            result.setPerDiem(perDiemService.getCountryPerDiem(idCountry));
            result.setDueInCurrency(coefficient * result.getPerDiem().getRate());
        }

        return result;

    }
}
