package com.sai.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.sai.bo.StudentBO;


/*USE `sai`;
DROP procedure IF EXISTS `P_GET_STUDENT_BY_NAME`;

DELIMITER $$
USE `sai`$$
CREATE PROCEDURE `P_GET_STUDENT_BY_NAME` (IN name1 VARCHAR(45),IN name2 VARCHAR(45))
BEGIN
	SELECT id, name,age,city,course,fee FROM students WHERE name in (name1,name2);
END$$

DELIMITER ;*/

/*USE `sai`;
DROP procedure IF EXISTS `P_GET_STUDENT_BY_ID`;

DELIMITER $$
USE `sai`;
DELIMITER $$
CREATE PROCEDURE `P_GET_STUDENT_BY_ID` (IN id INT,OUT _id INT,OUT _name VARCHAR(45),OUT _age INT,OUT _city VARCHAR(45),OUT _course VARCHAR(45),OUT _fee INT)
BEGIN
	SELECT id, name,age,city,course,fee INTO _id,_name,_age,_city,_course,_fee FROM students WHERE Students.id=id;
END$$

DELIMITER ;*/

@Repository
public class StudentDAOImpl implements IStudentDAO {

	@Autowired
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name1", name1);
		map.put("name2", name2);
		SimpleJdbcCall call = new SimpleJdbcCall(dataSource)
								.withProcedureName("P_GET_STUDENT_BY_NAME")
								.returningResultSet("students", new BeanPropertyRowMapper<StudentBO>(StudentBO.class));
		map = call.execute(map);
		List<StudentBO> list = (List<StudentBO>) map.get("students");
		
		return list;
	}
	
	public StudentBO getStudentById(Integer id) {
		SimpleJdbcCall call = new SimpleJdbcCall(dataSource).withProcedureName("P_GET_STUDENT_BY_ID");
		SqlParameterSource inParams = new MapSqlParameterSource().addValue("id", id);
		Map<String, Object> outParams = call.execute(inParams);
		StudentBO bo = new StudentBO();
		bo.setId((int) outParams.get("_id"));
		bo.setName((String) outParams.get("_name"));
		bo.setAge((int) outParams.get("_age"));
		bo.setCity((String) outParams.get("_city"));
		bo.setCourse((String) outParams.get("_course"));
		bo.setFee((int) outParams.get("_fee"));
		return bo;
		
	}

}
