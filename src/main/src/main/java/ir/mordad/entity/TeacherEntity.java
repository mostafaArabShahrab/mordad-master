package ir.mordad.entity;



import javax.persistence.*;
import java.util.List;

/**
 * Created by Asus on 4/27/2018.
 */
@Entity
@Table(name = "TEACHER")
public class TeacherEntity {
    @Id
    @Column(name = "TEACHER_ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "TEACHER_NAME")
    private String name;

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

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "teacher" , cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<StudentEntity> students;

}
