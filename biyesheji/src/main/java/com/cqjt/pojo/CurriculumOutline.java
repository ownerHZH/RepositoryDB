package com.cqjt.pojo;

/**
 * 课程大纲实体
 * @author Owner
 * @
 */
public class CurriculumOutline {
	private int curriculum_code;
	private String co_name;
	private String filename;
	private String location;
	
	public int getCurriculum_code() {
		return curriculum_code;
	}
	public void setCurriculum_code(int curriculum_code) {
		this.curriculum_code = curriculum_code;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
