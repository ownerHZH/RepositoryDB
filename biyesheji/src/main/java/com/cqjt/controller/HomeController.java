package com.cqjt.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cqjt.pojo.Major;
import com.cqjt.service.MajorService;

/**
 * Handles requests for the application home page.
 */
@Controller
/*@RequestMapping(value = "/")*/
public class HomeController {
	@Autowired
	private MajorService majorService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "vv", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
/*		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);*/
		
		List<Major> majors = majorService.getMajorList();
		
		//model.addAttribute("serverTime", formattedDate );
		model.addAttribute("list", majors );
		
		return "home";
	}
	
}
