package com.sai.dao;

import java.util.List;

import com.sai.bo.StudentBO;

public interface IStudentDAO {
	public List<StudentBO> getStudentByName(String name1,String name2);	
	public StudentBO getStudentById(Integer id);
}
