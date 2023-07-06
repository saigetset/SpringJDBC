package com.sai.service;


import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> getStudentByName(String name1,String name2);
	public StudentDTO getStudentById(Integer id);
}
