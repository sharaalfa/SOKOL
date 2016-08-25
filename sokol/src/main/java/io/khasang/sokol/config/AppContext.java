package io.khasang.sokol.config;

import io.khasang.sokol.beans.IMessageService;
import io.khasang.sokol.beans.impl.HelloMessage;
import io.khasang.sokol.beans.impl.User;
import io.khasang.sokol.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

@Configuration
@ComponentScan()
@PropertySource(value = {"classpath:util.properties", "file:/Users/denspbru/Servers/util.properties"}, ignoreResourceNotFound = true)
public class AppContext {
    @Autowired
    Environment environment;


    @Bean(name = "messageService")
    public IMessageService message(){
        return new HelloMessage();
    }

    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public CreateTable createTable(){
        return new CreateTable(jdbcTemplate());
    }
//    @Bean
//    public static PlaceholderConfigurerSupport propertyPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
