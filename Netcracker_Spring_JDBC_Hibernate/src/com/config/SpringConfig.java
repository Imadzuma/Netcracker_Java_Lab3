package com.config;

import com.model.Book;
import com.model.Customer;
import com.model.Order;
import com.model.Shop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com")
@PropertySource(value= "classpath:application.properties")
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public Class<Book> bookClassBean(){
        return Book.class;
    }

    @Bean
    public Class<Customer> customerClassBean(){
        return Customer.class;
    }

    @Bean
    public Class<Shop> shopClassBean(){
        return Shop.class;
    }

    @Bean
    public Class<Order> orderClassBean(){
        return Order.class;
    }
}