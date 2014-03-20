package com.cqjt.service.impl;

import javax.jws.WebService;

import com.cqjt.pojo.Role;
import com.cqjt.service.IRoleService;


//@Service(value="roleService")
@WebService(endpointInterface = "com.cqjt.service.IRoleService", serviceName = "roleService")
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService {

/*	@Resource(name = "roleDAO")
	private IRoleDAO roleDAO;*/
	
	@Override
	public Boolean addRole(Role role) {
		String sqlName = "addRole";
		Boolean flag=(Boolean) super.insert(sqlName, role);//roleDAO.addRole(role);
		return flag;
	}

}
