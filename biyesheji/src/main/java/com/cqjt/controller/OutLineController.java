package com.cqjt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqjt.pojo.Curriculum;
import com.cqjt.pojo.CurriculumOutline;
import com.cqjt.service.ICurriculumService;
import com.cqjt.service.IOutLineService;
import com.cqjt.util.GsonUtil;

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
	
	/**
	 * 大纲初始化显示数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/outline", method = RequestMethod.GET)
	public ModelAndView outline(HttpServletRequest request) {
		//String docFile="resources/doc/test.doc";
		//outLineService.openPageOffice(request, docFile);
		List<Curriculum> curriculums=curriculumService.getAllCurriculum();
		return new ModelAndView("outline","curriculums",curriculums);
	}
	
	/**
	 * 以code查询大纲信息 返回json
	 * @param code
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/getDataByCode", method = RequestMethod.GET)
	public  ModelAndView getDataByCode(@ModelAttribute("code")int code,HttpServletResponse response) {
		CurriculumOutline outline =outLineService.getOutlineByCode(code);
		PrintWriter out = null;
		try {
			out = response.getWriter();		
			out.print(GsonUtil.getGson().toJson(outline));
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			out.close();
		}	
		return null;
	}
	
	/**
	 * 只读方式打开doc
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/page-office", method = RequestMethod.GET)
	public ModelAndView openOffice(@ModelAttribute("file")String docFile,HttpServletRequest request) {
		//String docFile="resources/doc/test.doc";
		if(docFile==null)
		{
			return new ModelAndView("outline/noFileFound");
		}else if(docFile.substring(docFile.lastIndexOf("/")) .equals(null))
		{			
			return new ModelAndView("outline/noFileFound");
		}else
		{
			outLineService.openPageOffice(request, docFile);
			return new ModelAndView("page-office");
		}	
	}
	
	/**
	 * 编辑状态打开doc
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/editOffice", method = RequestMethod.GET)
	public ModelAndView editOffice(@ModelAttribute("file")String docFile,HttpServletRequest request) {
		//String docFile="resources/doc/test.doc";
		outLineService.editPageOffice(request, docFile);
		return new ModelAndView("page-office");
	}
	
	/**
	 * 保存doc
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/SaveFile",method = RequestMethod.POST)
	public ModelAndView SaveFile(@ModelAttribute("file")String docFile,HttpServletResponse response,HttpServletRequest request) {
		String docPath=docFile.substring(0, docFile.lastIndexOf("/")+1);//"resources/doc/";
		outLineService.saveFile(request, response, docPath);
		return null;
	}
	
	/**
	 * 文件不存在的跳转
	 * @return
	 */
	@RequestMapping(value ="/nofile",method = RequestMethod.GET)
	public ModelAndView nofile(@ModelAttribute("code")int code) {
		return new ModelAndView("outline/no-file-found","code",code);
	}
			
	/**
	 * outline页面初始化iframe显示的一个页面
	 * @return
	 */
	@RequestMapping(value ="/outlineInitial",method = RequestMethod.GET)
	public ModelAndView outlineInitial() {
		return new ModelAndView("outline/outline-initial");
	}
	
	/**
	 * 删除文档
	 * @return
	 */
	@RequestMapping(value ="/deleteDoc",method = RequestMethod.GET)
	public ModelAndView deleteDoc(@ModelAttribute("code")int code,HttpServletResponse response) {
		CurriculumOutline curriculumOutline=new CurriculumOutline();
		curriculumOutline.setCurriculum_code(code);
		boolean f=outLineService.deleteOutline(curriculumOutline);
		PrintWriter out = null;
		try {
			out = response.getWriter();		
			out.print(f);
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			out.close();
		}	
		return null;
	}
	
	@RequestMapping(value ="/upload",method = RequestMethod.GET)
	public ModelAndView uploadDoc(@ModelAttribute("code")int code) {
		return new ModelAndView("outline/upload","code",code);
	}
	
}
