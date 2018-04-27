package ir.mordad.dao;

import ir.mordad.entity.StudentEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentRowMapper implements RowMapper<StudentEntity> {

    public StudentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentEntity student = new StudentEntity();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        return student;
    }
}
