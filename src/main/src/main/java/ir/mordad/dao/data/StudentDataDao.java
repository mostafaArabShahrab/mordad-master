package ir.mordad.dao.data;

import ir.mordad.entity.StudentEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("jpa")
@Repository
public interface StudentDataDao extends JpaRepository<StudentEntity,Integer>{

    List<StudentEntity> findAllByNameContaining(String name);
    List<StudentEntity> findAllByAgeBetweenAndNameIsNotContainingAndTeacher_NameIsNotContaining(
            Integer age1, Integer age2, String name, String teacherName);

}
