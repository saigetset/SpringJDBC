package com.sai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sai.bo.StudentBO;

@Repository
public class StudentDAOImpl implements IStudentDAO {
	
	private static final String STUDENT_DETAILS_BY_ID = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE id=?";
	private static final String STUDENT_DETAILS_BY_NAME = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE name IN (?,?)";
		
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public StudentBO getStudentById(int id) {
		StudentBO bo = template.queryForObject(STUDENT_DETAILS_BY_ID, new StudentRowMapper(), id);
		return bo;
	}
	public class StudentRowMapper implements RowMapper<StudentBO> {

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentBO bo = new StudentBO();
			bo.setId(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAge(rs.getInt(3));
			bo.setCity(rs.getString(4));
			bo.setCourse(rs.getString(5));
			bo.setFee(rs.getInt(6));
			return bo;
		}

	}


	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		List<StudentBO> list = template.query(STUDENT_DETAILS_BY_NAME, new StudentMapper(), name1,name2);
		return list;
	}
	public class StudentMapper implements RowMapper<StudentBO>{

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			StudentBO bo = new StudentBO();
			bo.setId(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAge(rs.getInt(3));
			bo.setCity(rs.getString(4));
			bo.setCourse(rs.getString(5));
			bo.setFee(rs.getInt(6));
			return bo;
		}
		
	}
	

}
