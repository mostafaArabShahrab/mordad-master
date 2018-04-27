package ir.mordad.config;

import ir.mordad.entity.SingletonJesus;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.*;

//@PropertySource(value = "classpath:config.properties")
@Import({JdbcConfig.class, JpaConfig.class})
// based on which profile is set to be active, corresponding beans will be created
// the other beans wont

@Configuration
@ComponentScan(basePackages = "ir.mordad")
public class AppConfig {

    @Bean
    public SingletonJesus getJesus(){
        return SingletonJesus.getInstance();
    }

//    @Autowired
//    private Environment env;


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



//    // Third way
//    // has the advantage of not adding an extra field to the class
//    @Autowired
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }

    @Bean("logger")
    public Logger getLogger() {
        return Logger.getRootLogger();
//        return Logger.getLogger(getClass());
    }

//    @Profile("dev")
//    @Bean("dataSource2")
//    public DataSource getDatasource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername(env.getProperty("jpa.username"));
//        dataSource.setPassword(env.getProperty("jpa.password"));
//        dataSource.setUrl(env.getProperty("jpa.url"));
//        dataSource.setDriverClassName(env.getProperty("jpa.driver"));
//        System.out.println(" >>> MADE A DATASOURCE2 BABY");
//        return dataSource;
//    }

}
