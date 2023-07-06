package com.sai.dao;

import java.util.List;
import java.util.Map;

public interface IStudentDAO {
	public Integer getStudentCount();
	public String getStudentNameById(int id);
	public Map<String,Object> getStudentDetailsById(int id);
	public List<Map<String,Object>> getStudentDetailsByCourses(String course1,String course2);
	public int insertStudent(String name,int age,String city,String course,int fee);
	public int giveDiscountByCourse(String course,int discount);
	public List<Map<String,Object>> getAllStudents();
}
