import ir.mordad.entity.StudentEntity;
import ir.mordad.manager.StudentManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:context.xml")
//@Transactional
public class StudentManagerTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void saveTest() throws SQLException {
        StudentEntity student = new StudentEntity();
        student.setId(new Random().nextInt(100) + 1);
        student.setName("TestingKalim");

        StudentManager manager = (StudentManager) applicationContext.getBean("studentManager");

//        Assert.assertTrue(manager.save(student));

        manager.save(student);
    }
}
