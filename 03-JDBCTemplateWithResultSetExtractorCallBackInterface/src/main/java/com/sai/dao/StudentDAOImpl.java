package com.sai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
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
		List<StudentBO> bo = template.query(STUDENT_DETAILS_BY_NAME, new ResultSetExtractor<List<StudentBO>>() {

			@Override
			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<StudentBO> list = new ArrayList<StudentBO>();
				while (rs.next()) {
					StudentBO std = new StudentBO();
					std.setId(rs.getInt(1));
					std.setName(rs.getString(2));
					std.setAge(rs.getInt(3));
					std.setCity(rs.getString(4));
					std.setCourse(rs.getString(5));
					std.setFee(rs.getInt(6));
					list.add(std);
				}
				return list;
			}

		}, name1, name2);
		return bo;
	}

	@Override
	public List<StudentBO> getStudentByCity(String city1, String city2, String city3) {
		//Here the column names of table must match with the fields of StudentBO
		List<StudentBO> bo= template.query(STUDENT_DETAILS_BY_CITY, new RowMapperResultSetExtractor<StudentBO>(new BeanPropertyRowMapper<StudentBO>(StudentBO.class)), city1,city2,city3);
		return bo;
	}
	

}
