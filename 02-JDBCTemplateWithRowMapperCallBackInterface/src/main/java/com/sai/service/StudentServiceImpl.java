package com.sai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.bo.StudentBO;
import com.sai.dao.IStudentDAO;
import com.sai.dto.StudentDTO;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDAO dao;

	@Override
	public StudentDTO getStudentById(int id) {
		StudentBO bo = dao.getStudentById(id);
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

	@Override
	public List<StudentDTO> getStudentByName(String name1, String name2) {
		List<StudentBO> boList = dao.getStudentByName(name1, name2);
		List<StudentDTO> dtoList= new ArrayList<StudentDTO>();
		boList.forEach((bo)->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}
}
