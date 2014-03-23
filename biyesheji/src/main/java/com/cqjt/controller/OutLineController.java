package com.cqjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cqjt.service.IOutLineService;

/**
 * 大纲控制层
 * @author Owner
 *
 */

@Controller
@RequestMapping(value = "/")
public class OutLineController {
	
	//注入菜单的Service
	@Autowired
	private IOutLineService outLineService;
	
	@RequestMapping(value ="/outline", method = RequestMethod.GET)
	public ModelAndView outline(HttpServletRequest request) {
		String docFile="resources/doc/test.doc";
		outLineService.openPageOffice(request, docFile);
		return new ModelAndView("outline");
	}
	
	@RequestMapping(value ="/SaveFile",method = RequestMethod.POST)
	public ModelAndView SaveFile(HttpServletResponse response,HttpServletRequest request) {
		String docPath="resources/doc/";
		outLineService.saveFile(request, response, docPath);
		return null;
	}
	
}
