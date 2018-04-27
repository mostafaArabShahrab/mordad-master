package ir.mordad.demo;

import ir.mordad.config.AppConfig;
import ir.mordad.entity.StudentEntity;
import ir.mordad.manager.StudentManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

//        StudentEntity student1 = new StudentEntity();
//        student1.setId(new Random().nextInt(100) + 1);
//        student1.setName("Kalim");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(AppConfig.class);
        context.refresh();
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        StudentManager studentManager = context.getBean(StudentManager.class);
//        StudentManager studentManager2 = context.getBean(StudentManager.class);
//        studentManager.save(student1);
//        System.out.println(studentManager == studentManager2);
//        ((AnnotationConfigApplicationContext) context).close();
        for (int i = 0; i < 5; i++){
            StudentEntity studentEntity = context.getBean(StudentEntity.class);
            studentManager.save(studentEntity);
        }
    }
}
