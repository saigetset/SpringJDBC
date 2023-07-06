package com.sai.dao;

import java.util.List;

import com.sai.bo.StudentBO;

public interface IStudentDAO {
	public List<StudentBO> getStudentByName(String name1,String name2);
	public List<StudentBO> getStudentByCity(String city1,String city2,String city3);
	
}
