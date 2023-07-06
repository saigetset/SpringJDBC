package com.sai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.sai.bo.StudentBO;

@Repository
public class StudentDAOImpl implements IStudentDAO {
	
	private static final String STUDENT_DETAILS_BY_NAME = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE name IN (?,?)";
	private static final String STUDENT_DETAILS_BY_CITY = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE city IN (?,?,?)";
	
		
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		List<StudentBO> boList = new ArrayList<StudentBO>();
		template.query(STUDENT_DETAILS_BY_NAME, new RowCallbackHandler(){
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				StudentBO bo = new StudentBO();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setCity(rs.getString(4));
				bo.setCourse(rs.getString(5));
				bo.setFee(rs.getInt(6));
				boList.add(bo);
			}
		}, name1, name2);
		return boList;
	}

	@Override
	public List<StudentBO> getStudentByCity(String city1, String city2, String city3) {
		List<StudentBO> boList = new ArrayList<StudentBO>();
		template.query(STUDENT_DETAILS_BY_CITY, new RowCallbackHandler(){
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				StudentBO bo = new StudentBO();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setCity(rs.getString(4));
				bo.setCourse(rs.getString(5));
				bo.setFee(rs.getInt(6));
				boList.add(bo);
			}
		},city1,city2,city3);
		return boList;
	}
	

}
