package com.cqjt.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.web.multipart.MultipartFile;

import com.cqjt.pojo.Teacher;
import com.cqjt.service.ITeacherService;
import com.cqjt.util.ExcelToDB;
import com.cqjt.util.FileOperation;


//@Service(value="teacherService")
@WebService(endpointInterface = "com.cqjt.service.ITeacherService", serviceName = "teacherService")
public class TeacherServiceImpl extends BaseServiceImpl implements ITeacherService {

/*	@Resource(name = "teacherDAO")
	private ITeacherDAO teacherDAO;*/
	
	@Override
	public void uploadTeachersExcel(MultipartFile file, String path) {
		//以日期创建文件夹
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");  
        String ymd = sdf.format(new Date());
        
        //保存文件
        File targetFile = FileOperation.saveFile(file, path+ymd+"/");
        
        //保存数据
		ExcelToDB e=new ExcelToDB(targetFile,"teacher");

		@SuppressWarnings("unchecked")
		List<Teacher> teachers=(List<Teacher>) e.getList();
		if(teachers!=null)
		{
			for (Teacher t : teachers) {
				Map<String, Object> tmp = new HashMap<String, Object>();
				tmp.put("teacher", t);
				super.insert("addTeacher", tmp);
			}
		}
	}

}
