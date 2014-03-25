package com.cqjt.junitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cqjt.pojo.Curriculum;
import com.cqjt.pojo.CurriculumOutline;
import com.cqjt.service.ICurriculumService;
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
	
	@Autowired
	private ICurriculumService curriculumService;
	@Test public void testCurriculum()
	{
		Curriculum curriculum=new Curriculum();
		curriculum.setAll_time(5);
		curriculum.setCc_code(1);
		curriculum.setComputer_time(5);
		curriculum.setCredit(5.0f);
		curriculum.setCurriculum_code(123);
		curriculum.setCurriculum_englishname("java");
		curriculum.setCurriculum_name("java");
		curriculum.setExam_way("考试");
		curriculum.setExplain("解释");
		curriculum.setPractice_time(5);
		curriculum.setSemester_code(5);
		curriculum.setStudymode_id(5);
		curriculum.setTheory_time(5);
		System.out.println("===>>>"+curriculumService.addCurriculum(curriculum)+"");
	}
}
