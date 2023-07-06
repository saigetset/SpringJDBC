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
		
		System.out.println(service.getStudentById(3));
		
		((ConfigurableApplicationContext) context).close();
	}

}
