package com.itsoul.lab.jpa.app;

import com.it.soul.lab.sql.SQLExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class BeanConfig {

    @Autowired
    private Environment env;

    @Autowired
    private JSQLConfig creator;

    @Bean("JDBConnectionPool")
    SQLExecutor executor() {
        SQLExecutor exe = creator.executor(env.getProperty("app.db.testdb.name"));
        System.out.println("Created DB Connections.");
        return exe;
    }

}
