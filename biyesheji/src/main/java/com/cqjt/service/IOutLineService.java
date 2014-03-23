package com.cqjt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjt.pojo.CurriculumOutline;

/**
 * 大纲页面服务接口
 * @author Owner
 *
 */
public interface IOutLineService {
	/**
	 * 打开PageOffice
	 * @param request
	 * @param docFile 要打开的文档
	 */
    public void openPageOffice(HttpServletRequest request,String docFile);
    
    /**
     * 保存文档
     */
    public void saveFile(HttpServletRequest request, HttpServletResponse response,String docPath);
    
    /**
     * 获取所有的大纲列表
     * @return 大纲list
     */
    public List<CurriculumOutline> getAllOutline();
    
    /**
     * 根据大纲code获取一个大纲实体
     * @param 大纲code
     * @return 大纲实体
     */
    public CurriculumOutline getOutlineByCode(int code);
    
    /**
     * 添加大纲
     * @param curriculumOutline对象
     * @return true  or false
     */
    public boolean addOutline(CurriculumOutline curriculumOutline);
    
    /**
     * 根据大纲code更新大纲
     * @param curriculumOutline对象 这个实体只需要code就可
     * @return true or false
     */
    public boolean updateOutline(CurriculumOutline curriculumOutline);
    
    /**
     * 根据大纲code删除这条信息
     * @param curriculumOutline对象 这个实体只需要code就可
     * @return true or false
     */
    public boolean deleteOutline(CurriculumOutline curriculumOutline);
}
