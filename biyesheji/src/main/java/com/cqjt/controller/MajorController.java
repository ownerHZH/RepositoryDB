package com.cqjt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cqjt.pojo.Major;
import com.cqjt.service.MajorService;


@Controller
public class MajorController {
	
	@Resource(name = "majorService")
	private MajorService majorService;
	
	//鑾峰彇涓撲笟鍒楄〃
	@RequestMapping("/professional-introduction")
	public ModelAndView professional_introduction() {
		List<Major> majors=majorService.getMajorList();
		System.out.println(majors.size());
		return new ModelAndView("professional-introduction","majors",majors);
	}
	
	//添加角色
	@RequestMapping(value = "/addMajor", method = RequestMethod.POST)      
	public ModelAndView addRole(@ModelAttribute("major")Major major,HttpServletResponse response) 
	{          
		boolean flag=majorService.addMajor(major); 
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(flag);
		return null;    
	}
	
	//涓撲笟闈欐�椤甸潰璇锋眰
	@RequestMapping("/static-html")
	public ModelAndView static_html() {
		return new ModelAndView("static-html");
	}
	
	
}
