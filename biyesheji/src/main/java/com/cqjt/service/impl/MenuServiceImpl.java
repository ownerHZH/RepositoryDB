package com.cqjt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.cqjt.pojo.MenuLevelOne;
import com.cqjt.pojo.MenuLevelThree;
import com.cqjt.pojo.MenuLevelTwo;
import com.cqjt.service.IMenuService;


//@Service(value="menuService")
@WebService(endpointInterface = "com.cqjt.service.IMenuService", serviceName = "menuService")
public class MenuServiceImpl extends BaseServiceImpl implements IMenuService {
	
/*	@Resource(name = "menuLevelOneDAO")
	private IMenuLevelOneDAO menuLevelOneDAO;
	@Resource(name = "menuLevelTwoDAO")
	private IMenuLevelTwoDAO menuLevelTwoDAO;
	@Resource(name = "menuLevelThreeDAO")
	private IMenuLevelThreeDAO menuLevelThreeDAO;*/

	@Override
	public List<MenuLevelOne> getMenuOneLevelByRoleCode(int code) {
		Map<String, Object> params = new HashMap<String, Object>();//传递查询参数
    	MenuLevelOne menuLevelOne=new MenuLevelOne();
    	menuLevelOne.setRole_code(code);
    	String sqlName="getMenuLevelOne";
    	params.put("menuLevelOne", menuLevelOne);
		return (List<MenuLevelOne>) super.select(sqlName, params);
	}

	
	/**
	 * 根据一级菜单code获取相对应二级和三级菜单
	 * @param code  一级菜单Code
	 * @return  对应的二级和三级菜单
	 */
	@Override
	public List<MenuLevelTwo> getMenuLevelTwoAndThreeByMenuLevelOneCode(int code) {
		Map<String, Object> params = new HashMap<String, Object>();//传递查询参数

		MenuLevelTwo menuLevelTwo=new MenuLevelTwo();
		menuLevelTwo.setMenu_level_one_id(code);
		params.put("menuLevelTwo", menuLevelTwo);
		String sqlName = "getMenuLevelTwo";
		List<MenuLevelTwo> menuLevelTwoList=(List<MenuLevelTwo>) super.select(sqlName, params);//menuLevelTwoDAO.getMenuLevelTwo(menuLevelTwo);
		
		if(menuLevelTwoList!=null&&menuLevelTwoList.size()>0)
		{	
			for(int i1=0;i1<menuLevelTwoList.size();i1++)
			{
				MenuLevelThree menuLevelThree=new MenuLevelThree();
				menuLevelThree.setMenu_level_two_id(menuLevelTwoList.get(i1).getMenu_level_two_id());
				sqlName = "getMenuLevelThree";
				params.put("menuLevelThree", menuLevelThree);
				List<MenuLevelThree> threeList=(List<MenuLevelThree>) super.select(sqlName, params);//menuLevelThreeDAO.getMenuLevelThree(menuLevelThree);
				menuLevelTwoList.get(i1).setMenuLevelThreeList(threeList);
			}
		}
		return menuLevelTwoList;
	}

}
