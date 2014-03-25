package com.cqjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cqjt.pojo.Curriculum;
import com.cqjt.service.ICurriculumService;
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
	@Autowired
	private ICurriculumService curriculumService;
	
	@RequestMapping(value ="/outline", method = RequestMethod.GET)
	public ModelAndView outline(HttpServletRequest request) {
		String docFile="resources/doc/test.doc";
		outLineService.openPageOffice(request, docFile);
		List<Curriculum> curriculums=curriculumService.getAllCurriculum();
		return new ModelAndView("outline","curriculums",curriculums);
	}
	
	@RequestMapping(value ="/SaveFile",method = RequestMethod.POST)
	public ModelAndView SaveFile(HttpServletResponse response,HttpServletRequest request) {
		String docPath="resources/doc/";
		outLineService.saveFile(request, response, docPath);
		return null;
	}
	
	@RequestMapping(value ="/getCurriculums",method = RequestMethod.GET)
	public ModelAndView getCurriculums(HttpServletResponse response,HttpServletRequest request) {
		/*Curriculum curriculum=new Curriculum();
		curriculum.setAll_time(5);
		curriculum.setCc_code(2);
		curriculum.setComputer_time(5);
		curriculum.setCredit(5.0f);
		curriculum.setCurriculum_code(124);
		curriculum.setCurriculum_englishname("java");
		curriculum.setCurriculum_name("java");
		curriculum.setExam_way("考试");
		curriculum.setExplain("解释");
		curriculum.setPractice_time(5);
		curriculum.setSemester_code(5);
		curriculum.setStudymode_id(5);
		curriculum.setTheory_time(5);
		//System.out.println("===>>>"+curriculumService.addCurriculum(curriculum)+"");
		System.out.println("===>>>"+curriculumService.getCurriculumByCode(123).toString()+"");*/
		
		return null;
	}
	
}
