package com.sai;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sai.dto.StudentDTO;
import com.sai.service.IStudentService;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		IStudentService service = context.getBean(IStudentService.class);
		List<StudentDTO> list = service.getStudentByName("sai", "vamsi");
		list.forEach(System.out::println);
		System.out.println("==================================================");
		System.out.println("Student name with id=4 is: "+service.getStudentNameById(4));
		StudentDTO dto=new StudentDTO();
		dto.setName("uthej");
		dto.setAge(29);
		dto.setCity("hyd");
		dto.setCourse(".net");
		dto.setFee(15000);
		System.out.println("No.of rows affected: "+service.addStudent(dto));
		((ConfigurableApplicationContext) context).close();
	}

}
