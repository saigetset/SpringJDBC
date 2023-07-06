package com.sai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sai.bo.StudentBO;

@Repository
public class StudentDAOImpl implements IStudentDAO {

	private static final String STUDENT_INSERTION = "INSERT INTO STUDENTS(name,age,city,course,fee) values(:name,:age,:city,:course,:fee)";
	private static final String STUDENT_DETAILS_BY_NAME = "SELECT id,name,age,city,course,fee FROM STUDENTS WHERE name IN (:name1,:name2)";
	private static final String STUDENT_NAME_BY_ID = "SELECT name FROM STUDENTS WHERE id=:id";

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("name1", name1);
		map.addValue("name2", name2);
		List<StudentBO> boList1 = template.query(STUDENT_DETAILS_BY_NAME, map, new ResultSetExtractor<List<StudentBO>>() {

			@Override
			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<StudentBO> boList = new ArrayList<StudentBO>();
				while (rs.next()) {
					StudentBO bo = new StudentBO();
					bo.setId(rs.getInt(1));
					bo.setName(rs.getString(2));
					bo.setAge(rs.getInt(3));
					bo.setCity(rs.getString(4));
					bo.setCourse(rs.getString(5));
					bo.setFee(rs.getInt(6));
					boList.add(bo);
				}
				return boList;
			}
		});
		return boList1;
	}

	@Override
	public String getStudentNameById(int id) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("id",id);
		return template.queryForObject(STUDENT_NAME_BY_ID, map, String.class);
	}

	@Override
	public int addStudent(StudentBO bo) {
		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(bo);
		int cou = template.update(STUDENT_INSERTION, map);
		return cou;
	}

}
