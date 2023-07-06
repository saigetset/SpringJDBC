package com.sai.service;

import java.util.List;
import java.util.Map;

import com.sai.dao.IStudentDAO;

public class StudentServiceImpl implements IStudentService {
	private IStudentDAO dao;
	
	public StudentServiceImpl(IStudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public Integer getStudentCount() {
		return dao.getStudentCount();
	}

	@Override
	public String getStudentNameById(int id) {
		return dao.getStudentNameById(id);
	}

	@Override
	public Map<String, Object> getStudentDetailsById(int id) {
		return dao.getStudentDetailsById(id);
	}

	@Override
	public List<Map<String, Object>> getStudentDetailsByCourses(String course1, String course2) {
		return dao.getStudentDetailsByCourses(course1, course2);
	}

	@Override
	public int insertStudent(String name, int age, String city, String course, int fee) {
		return dao.insertStudent(name, age, city, course, fee);
	}

	@Override
	public int giveDiscountByCourse(String course, int discount) {
		return dao.giveDiscountByCourse(course, discount);
	}

	@Override
	public List<Map<String, Object>> getAllStudents() {
		return dao.getAllStudents();
	}

}
