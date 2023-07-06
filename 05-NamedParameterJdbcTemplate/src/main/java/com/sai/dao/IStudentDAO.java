package com.sai.dao;

import java.util.List;

import com.sai.bo.StudentBO;

public interface IStudentDAO {
	public int addStudent(StudentBO bo);
	public List<StudentBO> getStudentByName(String name1,String name2);
	public String getStudentNameById(int id);
	
}
