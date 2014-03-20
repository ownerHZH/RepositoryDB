package com.cqjt.pojo;

public class Major{
	
	private int major_code;
	private String major_name;
	private String core_curriculum;
	private String occupational_direction;
	private String goal;
	private String history;
	
	public int getMajor_code() {
		return major_code;
	}
	public void setMajor_code(String major_code) {
		if(major_code.contains("."))
		{
			this.major_code=(int) Double.parseDouble(major_code);
		}else
		{
			this.major_code = Integer.parseInt(major_code);
		}
	}
	public void setMajor_code(int major_code) {
			this.major_code = major_code;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getCore_curriculum() {
		return core_curriculum;
	}
	public void setCore_curriculum(String core_curriculum) {
		this.core_curriculum = core_curriculum;
	}

	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getOccupational_direction() {
		return occupational_direction;
	}
	public void setOccupational_direction(String occupational_direction) {
		this.occupational_direction = occupational_direction;
	}

}
