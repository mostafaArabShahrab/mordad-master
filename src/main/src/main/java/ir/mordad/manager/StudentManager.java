package ir.mordad.manager;

import ir.mordad.dao.StudentDao;
import ir.mordad.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component("studentManager")
@Service("studentManager")
@Profile("jdbc")
public class StudentManager {

    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;

    public StudentManager(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void save(StudentEntity student) {
        studentDao.save(student);
    }

    public StudentEntity load(int id){
        return studentDao.load(id);
    }

    public List<StudentEntity> loadAll(){
        return studentDao.loadAll();
    }

    public void delete(int id){
        studentDao.delete(id);
    }

    public void update(StudentEntity student){
        studentDao.update(student);
    }
}
