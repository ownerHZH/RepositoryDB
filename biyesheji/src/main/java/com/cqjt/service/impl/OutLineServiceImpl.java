package com.cqjt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.cqjt.pojo.CurriculumOutline;
import com.cqjt.pojo.MenuLevelOne;
import com.cqjt.pojo.MenuLevelThree;
import com.cqjt.pojo.MenuLevelTwo;
import com.cqjt.service.IMenuService;
import com.cqjt.service.IOutLineService;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

/**
 * 大纲服务层
 * @author Owner
 *
 */

@Service(value="outLineService")
//@WebService(endpointInterface = "com.cqjt.service.IOutLineService", serviceName = "outLineService")
public class OutLineServiceImpl extends BaseServiceImpl implements IOutLineService {
	
	@Override
	public void openPageOffice(HttpServletRequest request,String docFile) {
		PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
		//设置服务器页面
		poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
		poCtrl.setTitlebar(false); //隐藏标题栏
		poCtrl.setMenubar(false); //隐藏菜单栏
		poCtrl.setOfficeToolbars(false);//隐藏Office工具条
		//poCtrl.setCustomToolbar(false);//隐藏自定义工具栏
		//添加自定义按钮
		poCtrl.addCustomToolButton("保存","Save",1);
		poCtrl.addCustomToolButton("全屏", "SetFullScreen()", 4);
		//设置保存页面
		poCtrl.setSaveFilePage("SaveFile");
		//打开Word文档
		poCtrl.webOpen(docFile,OpenModeType.docNormalEdit,"owner");//"resources/doc/test.doc"
		poCtrl.setTagId("PageOfficeCtrl1");//此行必需
	}


	@Override
	public void saveFile(HttpServletRequest request, HttpServletResponse response,String docPath) {
		FileSaver fs=new FileSaver(request,response);
		fs.saveToFile(request.getSession().getServletContext()
				.getRealPath(docPath)+"/"+fs.getFileName());//"resources/doc/"
		fs.close();
	}


	@Override
	public List<CurriculumOutline> getAllOutline() {
		@SuppressWarnings("unchecked")
		List<CurriculumOutline> coList=(List<CurriculumOutline>) super.select("getAllOutline", null);
		return coList;
	}


	@Override
	public CurriculumOutline getOutlineByCode(int code) {
		HashMap<String, Object> params=new HashMap<String, Object>();
		params.put("curriculum_code", code);
		CurriculumOutline c=(CurriculumOutline) super.find("getOutlineByCode", params);
		return c;
	}


	@Override
	public boolean addOutline(CurriculumOutline curriculumOutline) {
		Object o=super.insert("addOutline", curriculumOutline);
		return o==null?false:true;
	}


	@Override
	public boolean updateOutline(CurriculumOutline curriculumOutline) {
		Object o=super.update("updateOutline", curriculumOutline);
		return o==null?false:true;
	}


	@Override
	public boolean deleteOutline(CurriculumOutline curriculumOutline) {
		HashMap<String, Object> params=new HashMap<String, Object>();
		params.put("curriculum_code", curriculumOutline.getCurriculum_code());
		Object o=super.delete("deleteOutline", params);
		return o==null?false:true;
	}

}
