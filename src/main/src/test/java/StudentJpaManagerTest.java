import ir.mordad.config.AppConfig;
import ir.mordad.entity.BookEntity;
import ir.mordad.entity.StudentEntity;
import ir.mordad.entity.TeacherEntity;
import ir.mordad.manager.StudentJpaManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 4/27/2018.
 */
@ActiveProfiles("jpa")
//@Transactional
//@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentJpaManagerTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void Test_Create() {
        StudentJpaManager manager = applicationContext.getBean(StudentJpaManager.class);
        StudentEntity s = new StudentEntity();
        s.setName("mostafa");
        s.setAge(890);
        manager.save(s);
        Assert.assertNotNull(s.getId());
        Assert.assertNotNull(manager.load(s.getId()));
    }

    @Test
    public void Test_CreateWithTeacher(){
        StudentJpaManager manager = applicationContext.getBean(StudentJpaManager.class);
        StudentEntity s = new StudentEntity();
        s.setName("mostafa");
        s.setAge(20);


        TeacherEntity t = new TeacherEntity();
        t.setName("darsanj");
        s.setTeacher(t);

        manager.save(s);
    }

    @Test
    public void Test_CreatWithBooks(){
        StudentJpaManager manager = applicationContext.getBean(StudentJpaManager.class);
        StudentEntity s = new StudentEntity();
        s.setName("mostafa");
        s.setAge(20);

        List<BookEntity> books = new ArrayList<>();
        books.add(new BookEntity("Math"));
        books.add(new BookEntity("DB"));
        books.add(new BookEntity("Martin Flower"));

        s.setBooks(books);
        manager.save(s);
    }

    @Test
    public void Test_FindAll() {
        StudentJpaManager manager = applicationContext.getBean(StudentJpaManager.class);
        manager.loadAll().stream().forEach(System.out::println);
    }

    @Test
    public void Test_SearchByName() {
        StudentJpaManager manager = applicationContext.getBean(StudentJpaManager.class);
        List<StudentEntity> list = manager.searchByName("%t%");
        long number = manager.loadAll().stream().map(s -> s.getName()).filter(name -> name.contains("t")).count();
        list.forEach(System.out::println);

        Assert.assertEquals(number, list.size());
    }

    @Test
    public void Test_Delete() {
        StudentJpaManager manager = applicationContext.getBean(StudentJpaManager.class);
        StudentEntity s = new StudentEntity();
        s.setName("kalim");
        s.setAge(17);
        int id = manager.save(s);
        manager.delete(s.getId());
        Assert.assertNull(manager.load(id));
    }

}
