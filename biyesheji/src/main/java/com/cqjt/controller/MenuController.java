package com.cqjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cqjt.pojo.MenuLevelOne;
import com.cqjt.pojo.MenuLevelTwo;
import com.cqjt.service.IMenuService;


@Controller
@RequestMapping(value = "/")
public class MenuController {
	
	//注入菜单的Service
	@Autowired
	private IMenuService menuService;
		
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String getMenu(Model model) 
    {
    	List<MenuLevelOne> menuLevelOneList=menuService.getMenuOneLevelByRoleCode(6);
    	System.out.println(menuLevelOneList.size());
    	model.addAttribute("menuList", menuLevelOneList);
    	//model.addAttribute("content","content.html");
		return "home";
    }
    
	@RequestMapping(value ="/content" , method = RequestMethod.GET)
	public ModelAndView content() {
		return new ModelAndView("content");
	}
    @RequestMapping(value ="/ssystem-maintenance" , method = RequestMethod.GET)
	public ModelAndView ssystem_maintenance() {			
		
    	List<MenuLevelTwo> menuLevelTwoList=menuService.getMenuLevelTwoAndThreeByMenuLevelOneCode(1);

		return new ModelAndView("ssystem-maintenance","menulist",menuLevelTwoList);
	}
	
	@RequestMapping(value ="/curriculum-system")
	public ModelAndView curriculum_system() {
		System.out.println("进入");
		return new ModelAndView("curriculum-system");
	}
	@RequestMapping(value ="/teachers-qualification")
	public ModelAndView teachers_qualification() {
		return new ModelAndView("teachers-qualification");
	}
	
	@RequestMapping(value ="/courseware")
	public ModelAndView courseware() {
		return new ModelAndView("courseware");
	}
	@RequestMapping(value ="/teaching-materials")
	public ModelAndView teaching_materials() {
		return new ModelAndView("teaching-materials");
	}
	@RequestMapping(value ="/interactive-platform")
	public ModelAndView interactive_platform() {
		return new ModelAndView("interactive-platform");
	}
	@RequestMapping(value ="/teaching-video")
	public ModelAndView teaching_video() {
		return new ModelAndView("teaching-video");
	}
	@RequestMapping(value ="/homework")
	public ModelAndView homework() {
		return new ModelAndView("homework");
	}
	@RequestMapping(value ="/online-testing")
	public ModelAndView online_testing() {
		return new ModelAndView("online-testing");
	}
	@RequestMapping(value ="/practicing")
	public ModelAndView practicing() {
		return new ModelAndView("practicing");
	}
	
	//涓夌骇鑿滃崟鎵�搴旂殑椤甸潰
	@RequestMapping(value ="/menu-content-add-role")
	public ModelAndView menu_content_add_role() {
		return new ModelAndView("menu/menu-content-add-role");
	}
	@RequestMapping(value ="/menu-content-role-setting")
	public ModelAndView menu_content_role_setting() {
		return new ModelAndView("menu/menu-content-role-setting");
	}
	@RequestMapping(value ="/menu-content-import-teachers")
	public ModelAndView menu_content_import_teachers() {
		return new ModelAndView("menu/menu-content-import-teachers");
	}
	@RequestMapping(value ="/menu-content-import-students")
	public ModelAndView menu_content_import_students() {
		return new ModelAndView("menu/menu-content-import-students");
	}
	@RequestMapping(value ="/menu-content-add-user")
	public ModelAndView menu_content_add_user() {
		return new ModelAndView("menu/menu-content-add-user");
	}
	@RequestMapping(value ="/menu-content-change-password")
	public ModelAndView menu_content_change_password() {
		return new ModelAndView("menu/menu-content-change-password");
	}
	@RequestMapping(value ="/menu-content-add-direction")
	public ModelAndView menu_content_add_direction() {
		return new ModelAndView("menu/menu-content-add-direction");
	}
	@RequestMapping(value ="/menu-content-change-direction")
	public ModelAndView menu_content_change_direction() {
		return new ModelAndView("menu/menu-content-change-direction");
	}
	@RequestMapping(value ="/menu-content-add-property")
	public ModelAndView menu_content_add_property() {
		return new ModelAndView("menu/menu-content-add-property");
	}
	@RequestMapping(value ="/menu-content-change-property")
	public ModelAndView menu_content_change_property() {
		return new ModelAndView("menu/menu-content-change-property");
	}
	@RequestMapping(value ="/menu-content-add-category")
	public ModelAndView menu_content_add_category() {
		return new ModelAndView("menu/menu-content-add-category");
	}
	@RequestMapping(value ="/menu-content-change-category")
	public ModelAndView menu_content_change_category() {
		return new ModelAndView("menu/menu-content-change-category");
	}
	
	@RequestMapping(value ="/SaveFile")
	public ModelAndView SaveFile() {
		return new ModelAndView("SaveFile");
	}
	
}
