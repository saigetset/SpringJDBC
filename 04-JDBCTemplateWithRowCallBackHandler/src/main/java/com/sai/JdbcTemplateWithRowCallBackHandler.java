package com.sai;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sai.dto.StudentDTO;
import com.sai.service.IStudentService;

@SpringBootApplication
public class JdbcTemplateWithRowCallBackHandler {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcTemplateWithRowCallBackHandler.class, args);
		IStudentService service = context.getBean(IStudentService.class);
		List<StudentDTO> list = service.getStudentByName("sai", "vamsi");
		list.forEach(System.out::println);
		System.out.println("==================================================");
		List<StudentDTO> list2 = service.getStudentByCity("guntur", "tenali", "macharla");
		list2.forEach(System.out::println);
		
		((ConfigurableApplicationContext) context).close();
	}

}
