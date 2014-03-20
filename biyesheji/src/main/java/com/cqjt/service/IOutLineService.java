package com.cqjt.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 大纲页面服务接口
 * @author owner
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
}
