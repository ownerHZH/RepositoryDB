package com.cqjt.service;

import java.util.List;
import com.cqjt.pojo.Curriculum;

/**
 * 课程页面服务接口
 * @author Owner
 *
 */
public interface ICurriculumService {
    
    /**
     * 获取所有的课程列表
     * @return 课程list
     */
    public List<Curriculum> getAllCurriculum();
    
    /**
     * 根据课程code获取一个课程实体
     * @param 课程code
     * @return 课程实体
     */
    public Curriculum getCurriculumByCode(int code);
    
    /**
     * 添加课程
     * @param curriculum对象
     * @return true  or false
     */
    public boolean addCurriculum(Curriculum curriculum);
    
    /**
     * 根据课程code更新课程
     * @param curriculum对象 这个实体只需要code就可
     * @return true or false
     */
    public boolean updateCurriculum(Curriculum curriculum);
    
    /**
     * 根据课程code删除这条信息
     * @param curriculum对象 这个实体只需要code就可
     * @return true or false
     */
    public boolean deleteCurriculum(Curriculum curriculum);
}
