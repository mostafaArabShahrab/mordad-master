package ir.mordad.dao;

import ir.mordad.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
//import java.sql.*;
import java.util.List;

@Repository("studentDao")
@Profile("jdbc")
public class StudentDao {
//    protected Connection connection;
//    protected PreparedStatement ps;
//    String pass = "";
//    String user = "root";
//
//    public StudentDao() {
//        System.out.println("Dao created!!!");
//    }

//    private String connectUrl = "jdbc:mysql://127.0.0.1:3306/mordad";
//
//    {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(connectUrl, user, pass);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Autowired
//    private DataSource dataSource;
//
//    private JdbcTemplate template = new JdbcTemplate(dataSource);

    @Autowired
    private RowMapper<StudentEntity> rowMapper;

//    @Autowired
//    // injects the parameter
//    public StudentDao(DataSource dataSource) {
//        template = new JdbcTemplate(dataSource);
//    }
    @Autowired
    private JdbcTemplate template;

//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private JdbcTemplate template;

    @Override
    @PreDestroy
    protected void finalize() {
//        try {
//            System.out.println("Before destroy!!!");
////            ps.close();
////            connection.close();
//        } catch (Exception e) {
//
//        }

        System.out.println("Before destroy!!!");
    }

    public void save(StudentEntity entity) {
        String query = "INSERT INTO students(id,name) VALUES(?,?)";
//        ps = connection.prepareStatement(query);
//        ps.setInt(1, entity.getId());
//        ps.setString(2, entity.getName());
//        ps.executeUpdate();

        template.update(query, entity.getId(), entity.getName());

    }

    public StudentEntity load(int id) {
        String query = "SELECT * FROM students WHERE id=?";
//        return template.queryForObject(query, new StudentRowMapper(), id);
        return template.queryForObject(query, rowMapper, id);
    }

    public List<StudentEntity> loadAll() {
        String query = "SELECT * FROM students";
        return template.query(query, rowMapper);
    }

    public void delete(int id) {
        String query = "DELETE  FROM students WHERE id = ?";
        template.update(query, id);
    }

    public void update(StudentEntity entity) {
        String query = "UPDATE students SET name=? WHERE id=?";
        template.update(query, entity.getName(), entity.getId());
    }
}
