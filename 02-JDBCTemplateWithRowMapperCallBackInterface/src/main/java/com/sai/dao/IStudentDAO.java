package com.sai.dao;

import java.util.List;

import com.sai.bo.StudentBO;

public interface IStudentDAO {
	public StudentBO getStudentById(int id);
	public List<StudentBO> getStudentByName(String name1,String name2);
	
}
