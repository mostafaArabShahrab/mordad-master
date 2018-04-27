package ir.mordad.manager;

import ir.mordad.dao.data.StudentDataDao;
import ir.mordad.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Profile("jpa")
@Transactional
public class StudentDataManager {
    @Autowired
    private StudentDataDao dao;

    public Integer save(StudentEntity student) {
        dao.save(student);
        return student.getId();
    }

    @Transactional(readOnly = true)
    public StudentEntity load(Integer id){
        return dao.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<StudentEntity> loadAll(){
        return dao.findAll();
    }

    public void delete(Integer id){
        dao.delete(id);
    }

    public void update(StudentEntity student){
        dao.save(student);
    }

    public List<StudentEntity> searchByName(String name){
        return dao.findAllByNameContaining(name);
    }

}
