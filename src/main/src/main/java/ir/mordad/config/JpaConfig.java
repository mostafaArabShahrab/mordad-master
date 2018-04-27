package ir.mordad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource(value = {"classpath:config.properties", "classpath:hibernate.properties"})
@Configuration
//@ComponentScan(basePackages = "ir.mordad")
@Profile("jpa")
@EnableTransactionManagement
public class JpaConfig {

    @Autowired
    // need it to read from properties
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(managerFactoryBean().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean managerFactoryBean(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(dataSource);
        managerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        managerFactoryBean.setPackagesToScan("ir.mordad.entity");
        managerFactoryBean.setPersistenceUnitName("chalakPersistenceUnit");
        managerFactoryBean.setJpaProperties(properties);
        return managerFactoryBean;
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
    @Bean("dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
//        System.out.println(" >>> MADE A DATASOURCE BABY");
        return dataSource;
    }

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
