package com.shiroyasha.bot.config;

import com.shiroyasha.bot.entity.CommandUsage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public SessionFactory sessionFactory(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration.addAnnotatedClass(CommandUsage.class);

        configuration.setProperty("hibernate.connection.url" , dbUrl);
        configuration.setProperty("hibernate.connection.username" , username);
        configuration.setProperty("hibernate.connection.password" , password);

        configuration.setProperty("hibernate.dialect" , "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto" , "validate");
        configuration.setProperty("hibernate.show_sql","true");

        return configuration.buildSessionFactory();
    }

}
