package ir.mordad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@PropertySource(value = "classpath:config.properties")
@Configuration
//@ComponentScan(basePackages = "ir.mordad")
@Profile("jdbc")
public class JdbcConfig {

    @Autowired
    private Environment env;


    @Autowired
    private DataSource dataSource;

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }



//    @Bean(value = "studentDao",destroyMethod = "finalize")
//    public StudentDao getStudentDao() {
//        return new StudentDao();
//    }
//
//    @Bean("studentManager")
//    public StudentManager getStudentManager() {
//        return new StudentManager(getStudentDao());
//    }

//    @Profile("test")
//    @Bean("dataSource")
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername(env.getProperty("jdbc.username"));
//        dataSource.setPassword(env.getProperty("jdbc.password"));
//        dataSource.setUrl(env.getProperty("jdbc.url"));
//        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
//        System.out.println(" >>> MADE A DATASOURCE BABY");
//        return dataSource;
//    }

//    // first way: call method getDataSource()
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate(getDataSource());
//    }

    // second way: add a field to the class and use it
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate(dataSource);
//    }

//    // Third way
//    // has the advantage of not adding an extra field to the class
//    @Autowired
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }

//    @Bean("logger")
//    public Logger getLogger(){
//        return Logger.getRootLogger();
////        return Logger.getLogger(getClass());
//    }

    //    @Profile("jdbc")
    @Bean("dataSource")
    public DataSource getDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(env.getProperty("jpa.username"));
        dataSource.setPassword(env.getProperty("jpa.password"));
        dataSource.setUrl(env.getProperty("jpa.url"));
        dataSource.setDriverClassName(env.getProperty("jpa.driver"));
//        System.out.println(" >>> MADE A DATASOURCE2 BABY");
        return dataSource;
    }

}
