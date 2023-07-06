package com.sai.service;


import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> getStudentByName(String name1,String name2);
	public List<StudentDTO> getStudentByCity(String city1,String city2,String city3);
}
