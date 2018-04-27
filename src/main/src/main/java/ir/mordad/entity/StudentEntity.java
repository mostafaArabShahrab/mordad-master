package ir.mordad.entity;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

//@Scope("prototype")
// @Scope("prototype"): the opposite of singleton
//@Component("studentEntity")
@Entity
@Table(name = "STUDENT")
public class StudentEntity {
    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "STUDENT_NAME")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "STUDENT_AGE")
    private Integer age;

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private TeacherEntity teacher;

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    @ManyToMany(mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<BookEntity> books;

//    First Attempt: (does not work)
//    @Autowired
//    private Logger logger;

    // Second Attempt (worx)
    // made the Logger the argument of the constructor
//    @Autowired
//    public StudentEntity(Logger logger) {
//        setId(new Random().nextInt(100_000));
//        setName("Kaaalim" + id);
//        logger.info("new student entity born");
//   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
