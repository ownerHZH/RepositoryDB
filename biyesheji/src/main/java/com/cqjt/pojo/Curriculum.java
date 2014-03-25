package com.cqjt.pojo;

/**
 * 课程实体
 * @author Owner
 *
 */
public class Curriculum {
	private int curriculum_code	;//bigint
	private int cc_code	;//int
	private int studymode_id;//	int
	private String curriculum_name;//	varchar(20)
	private String curriculum_englishname;//	varchar(50)
	private float credit;//	float
	private int all_time;//	int
	private int theory_time;//	int
	private int practice_time;//	int
	private int computer_time;//	int
	private int semester_code;//	int
	private String exam_way	;//varchar(4)
	private String explain;//	text
	
	public int getCurriculum_code() {
		return curriculum_code;
	}
	public void setCurriculum_code(int curriculum_code) {
		this.curriculum_code = curriculum_code;
	}
	public int getCc_code() {
		return cc_code;
	}
	public void setCc_code(int cc_code) {
		this.cc_code = cc_code;
	}
	public int getStudymode_id() {
		return studymode_id;
	}
	public void setStudymode_id(int studymode_id) {
		this.studymode_id = studymode_id;
	}
	public String getCurriculum_name() {
		return curriculum_name;
	}
	public void setCurriculum_name(String curriculum_name) {
		this.curriculum_name = curriculum_name;
	}
	public String getCurriculum_englishname() {
		return curriculum_englishname;
	}
	public void setCurriculum_englishname(String curriculum_englishname) {
		this.curriculum_englishname = curriculum_englishname;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public int getAll_time() {
		return all_time;
	}
	public void setAll_time(int all_time) {
		this.all_time = all_time;
	}
	public int getTheory_time() {
		return theory_time;
	}
	public void setTheory_time(int theory_time) {
		this.theory_time = theory_time;
	}
	public int getPractice_time() {
		return practice_time;
	}
	public void setPractice_time(int practice_time) {
		this.practice_time = practice_time;
	}
	public int getComputer_time() {
		return computer_time;
	}
	public void setComputer_time(int computer_time) {
		this.computer_time = computer_time;
	}
	public int getSemester_code() {
		return semester_code;
	}
	public void setSemester_code(int semester_code) {
		this.semester_code = semester_code;
	}
	public String getExam_way() {
		return exam_way;
	}
	public void setExam_way(String exam_way) {
		this.exam_way = exam_way;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	@Override
	public String toString() {
		return "Curriculum [curriculum_code=" + curriculum_code + ", cc_code="
				+ cc_code + ", studymode_id=" + studymode_id
				+ ", curriculum_name=" + curriculum_name
				+ ", curriculum_englishname=" + curriculum_englishname
				+ ", credit=" + credit + ", all_time=" + all_time
				+ ", theory_time=" + theory_time + ", practice_time="
				+ practice_time + ", computer_time=" + computer_time
				+ ", semester_code=" + semester_code + ", exam_way=" + exam_way
				+ ", explain=" + explain + "]";
	}
	

}
