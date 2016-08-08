package spring.testng.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by ThangN on 8/8/2016.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "spring.testng.dao")
public class HibernateConfig {

    @Autowired
    Environment environment;


    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataResource());
        sessionFactoryBean.setPackagesToScan(packageScan());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    private DataSource dataResource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("hibernate.driverClass"));
        dataSource.setUrl(environment.getProperty("hibernate.url"));
        dataSource.setUsername(environment.getProperty("hibernate.username"));
        dataSource.setPassword(environment.getProperty("hibernate.password"));
        return dataSource;
    }

    private String[] packageScan(){
        return new String[]{"spring.testng.model"};
    }

    private Properties hibernateProperties(){

        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl", environment.getProperty("hibernate.hbm2ddl"));

        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory factory){
        HibernateTransactionManager txTran = new HibernateTransactionManager();
        txTran.setSessionFactory(factory);
        return txTran;
    }
}
