import ir.mordad.config.AppConfig;
import ir.mordad.entity.StudentEntity;
import ir.mordad.manager.StudentManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.Random;

@ActiveProfiles("jdbc")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentManagerTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void saveTest() throws SQLException {
        StudentEntity student = applicationContext.getBean(StudentEntity.class);
//        StudentEntity student = new StudentEntity();
//        student.setId(new Random().nextInt(100) + 1);
//        student.setName("TestingKalim");

        StudentManager manager = (StudentManager) applicationContext.getBean("studentManager");

//        Assert.assertTrue(manager.save(student));

        manager.save(student);
        Assert.notNull(manager.load(student.getId()));
    }
}
