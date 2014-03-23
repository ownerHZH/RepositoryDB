package com.cqjt.junitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cqjt.pojo.CurriculumOutline;
import com.cqjt.service.IOutLineService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath*:spring/*.xml"})
@TransactionConfiguration(defaultRollback = false)
public class junitTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private IOutLineService outLineService;
    
	@Test public void getAllOutline()
	{
		//System.out.println(outLineService.getAllOutline().size()+"");
		//outLineService.getOutlineByCode(123);
		CurriculumOutline curriculumOutline=new CurriculumOutline();
		curriculumOutline.setCo_name("www");
		curriculumOutline.setCurriculum_code(124);
		curriculumOutline.setFilename("www");
		curriculumOutline.setLocation("wwwww");
		//System.out.println(outLineService.addOutline(curriculumOutline)+"");
		
		//System.out.println(outLineService.deleteOutline(curriculumOutline)+"");
		//System.out.println(outLineService.getAllOutline().size()+"");
		System.out.println(outLineService.updateOutline(curriculumOutline)+"");
	}
}
