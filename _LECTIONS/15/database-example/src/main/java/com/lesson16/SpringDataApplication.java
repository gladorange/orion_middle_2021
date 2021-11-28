package com.lesson16;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.lesson16.JpaService.AnimalException;

public class SpringDataApplication {


    @Configuration
    @ComponentScan
    @EnableTransactionManagement
    public static class SpringTransactionalApplication {

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();

            em.setDataSource(dataSource());
            em.setPackagesToScan("com.lesson16");

            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            Properties properties = new Properties();
            properties.put("hibernate.hbm2ddl.auto", "update");

            em.setJpaProperties(properties);

            return em;
        }

        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
          //  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:6432/orion_test");
            dataSource.setUsername( "user_name" );
            dataSource.setPassword( "your_password" );
            return dataSource;
        }


        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }

        @Bean
        public TransactionTemplate transactionTemplate() {
            return new TransactionTemplate(transactionManager());
        }

    }




    public static void main(String[] args) throws AnimalException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringTransactionalApplication.class);
        final JpaService bean = context.getBean(JpaService.class);
        bean.createAnimals();
    }
}
