package ir.mordad.manager;

import ir.mordad.dao.StudentJpaDao;
import ir.mordad.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentJpaManager")
@Profile("jpa")
@Transactional
public class StudentJpaManager {
    @Autowired
    private StudentJpaDao studentJpaDao;

    public Integer save(StudentEntity student) {
        return studentJpaDao.create(student);
    }

    @Transactional(readOnly = true)
    public StudentEntity load(Integer id){
        return studentJpaDao.load(id);
    }

    @Transactional(readOnly = true)
    public List<StudentEntity> loadAll(){
        return studentJpaDao.loadAll();
    }

    public void delete(Integer id){
        studentJpaDao.delete(id);
    }

    public void update(StudentEntity student){
        studentJpaDao.update(student);
    }

    public List<StudentEntity> searchByName(String name){
        return studentJpaDao.searchByName(name);
    }
}
