package com.sai.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements IStudentDAO {
	
	private static final String STUDENT_COUNT = "SELECT Count(*) FROM STUDENTS";
	private static final String STUDENT_NAME_BY_ID = "SELECT name FROM STUDENTS WHERE id=?";
	private static final String STUDENT_DETAILS_BY_ID = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE id=?";
	private static final String STUDENT_DETAILS_BY_COURSES = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE course IN (?,?)";
	private static final String STUDENT_INSERTION = "INSERT INTO STUDENTS(name,age,city,course,fee) VALUES(?,?,?,?,?)";
	private static final String STUDENT_DISCOUNT_BY_COURSE = "UPDATE STUDENTS SET fee=fee-? WHERE course=?";
	private static final String GET_ALL_STUDENTS = "SELECT id,name,age,city,course,fee FROM STUDENTS";
	
	
	private JdbcTemplate template;
	
	public StudentDAOImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Integer getStudentCount() {
		Integer count = template.queryForObject(STUDENT_COUNT, Integer.class);
		return count;
	}

	@Override
	public String getStudentNameById(int id) {
		String name = template.queryForObject(STUDENT_NAME_BY_ID, String.class, id);
		return name;
	}

	@Override
	public Map<String, Object> getStudentDetailsById(int id) {
		Map<String, Object> details = template.queryForMap(STUDENT_DETAILS_BY_ID, id);
		return details;
	}

	@Override
	public List<Map<String, Object>> getStudentDetailsByCourses(String course1, String course2) {
		List<Map<String, Object>> students = template.queryForList(STUDENT_DETAILS_BY_COURSES, course1,course2);
		return students;
	}

	@Override
	public int insertStudent(String name, int age, String city, String course, int fee) {
		int cou = template.update(STUDENT_INSERTION,name,age,city,course,fee);
		return cou;
	}

	@Override
	public int giveDiscountByCourse(String course, int discount) {
		int cou = template.update(STUDENT_DISCOUNT_BY_COURSE, discount,course);
		return cou;
	}
	
	@Override
	public List<Map<String,Object>> getAllStudents(){
		List<Map<String, Object>> list = template.queryForList(GET_ALL_STUDENTS);
		return list;
	}

}
