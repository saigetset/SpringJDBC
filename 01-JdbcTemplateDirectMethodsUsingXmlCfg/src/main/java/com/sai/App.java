package com.sai;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sai.service.IStudentService;


public class App
{
	private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/sai/cfgs/applicationContext.xml");
        logger.info(Arrays.toString(context.getBeanDefinitionNames()));
        IStudentService service = context.getBean(IStudentService.class);
        System.out.println("Total Employee COunt: "+service.getStudentCount());
        System.out.println("Student Name with id = 2 is: "+service.getStudentNameById(2));
        System.out.println("Student Details with id = 3 are: "+service.getStudentDetailsById(3));
        System.out.println("Student Details who enrolled in java and python: "+service.getStudentDetailsByCourses("java", "python"));
        System.out.println("Inserting new Student: "+service.insertStudent("vasu", 26, "warangal", "c++", 24000));
        System.out.println("Giving 2000 discount for those who enrolled in java: "+service.giveDiscountByCourse("java", 2000));
        System.out.println("Details of all students: "+service.getAllStudents());
        
        ((AbstractApplicationContext) context).close();
    }
}
