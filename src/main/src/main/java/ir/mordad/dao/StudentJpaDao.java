package ir.mordad.dao;

import ir.mordad.entity.StudentEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Asus on 4/27/2018.
 */
@Repository
@Profile("jpa")
public class StudentJpaDao {
    @PersistenceContext
    private EntityManager entityManager;

    public StudentEntity load(int id){
        return entityManager.find(StudentEntity.class, id);
    }

    public int create(StudentEntity student){
        entityManager.persist(student);
        return student.getId();
    }

    public void update(StudentEntity student){
        entityManager.merge(student);
    }

    public void delete(int id){
        entityManager.remove(load(id));
    }

    public List<StudentEntity> loadAll(){
        Query query = entityManager.createQuery("select s from StudentEntity s");
        return query.getResultList();
    }

    public List<StudentEntity> searchByName(String name){
        Query query = entityManager.createQuery("select s from StudentEntity s where s.name like :name");
        query.setParameter("name", name);
        return query.getResultList();
    }


}
