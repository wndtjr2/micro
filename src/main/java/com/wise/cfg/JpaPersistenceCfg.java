package com.wise.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Project : spring4hibernate5
 * Package : com.s4h5.cfg
 * FileName : JpaPersistenceConfig
 * Date : 25/11/2016
 * Author : david@bluewisesoft.com
 * Description : write class description here
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.wise")
@PropertySource(value="classpath:application.properties")
public class JpaPersistenceCfg {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    private Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.connection.characterEncoding", environment.getRequiredProperty("hibernate.CharSet"));
        properties.put("hibernate.connection.useUnicode", environment.getRequiredProperty("hibernate.useUnicode"));
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean factory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(new String[]{"com.wise"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(properties());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                factory().getObject() );
        return transactionManager;
    }

}
