package ir.mordad.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Asus on 4/27/2018.
 */
@Entity
@Table(name = "BOOK")
public class BookEntity {

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    public BookEntity(){}

    public BookEntity(String name) {
        this.students = students;
        this.name = name;
    }

    public List<StudentEntity> getStudents() {

        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<StudentEntity> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "BOOK_NAME")
    private String name;
}
