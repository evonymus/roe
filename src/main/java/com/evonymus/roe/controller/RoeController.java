package com.evonymus.roe.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.evonymus.roe.model.Country;
import com.evonymus.roe.model.Currency;
import com.evonymus.roe.model.Roe;
import com.evonymus.roe.service.CountryService;
import com.evonymus.roe.service.CurrencyService;
import com.evonymus.roe.service.RoeService;

@Controller
@EnableWebMvc
@RequestMapping("/service")
public class RoeController {
    @Autowired
	private RoeService service;
    
    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CountryService countryService;

	public final RoeService getService() {		
		return service;
	}

	public final void setService(RoeService service) {
		this.service = service;
	}

	@RequestMapping(value="/{date}/{code}",method=RequestMethod.GET)
	public @ResponseBody Roe getRoeForDay(@PathVariable("date")@DateTimeFormat(iso=ISO.DATE) Date date
			, @PathVariable("code")String code){
		Roe result = getService().getRoeForDay(date, code);		
		return result;
	}
	
	@RequestMapping(value="/{date}",method=RequestMethod.GET)
	public @ResponseBody List<Roe> getListForDay(@PathVariable("date")@DateTimeFormat(iso=ISO.DATE) Date date) {
		List<Roe> result = getService().getListForDay(date);		
		return result;
	}

    @RequestMapping(value="/codes")
    public @ResponseBody List<String>getCodeList() {
        return service.getCodeList();
    }

    @RequestMapping(value="/currencyList", method=RequestMethod.GET)
    public @ResponseBody List<Currency> getCurrencyList() {
        return currencyService.getCurrencyList();
    }

    @RequestMapping(value="/countryList", method=RequestMethod.GET)
    public @ResponseBody List<Country> getCountryList() {
        return countryService.getCountryList();
    }
}
