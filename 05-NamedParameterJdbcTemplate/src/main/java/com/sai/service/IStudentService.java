package com.sai.service;


import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public int addStudent(StudentDTO dto);
	public List<StudentDTO> getStudentByName(String name1,String name2);
	public String getStudentNameById(int id);
}
