package com.itsoul.lab.jpa.app;

import com.it.soul.lab.jpql.service.JPQLExecutor;
import com.it.soul.lab.jpql.service.ORMController;
import com.it.soul.lab.sql.SQLExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class BeanConfig {

    @Autowired
    private Environment env;

    @Autowired
    private JSQLConfig jsqlConfig;

    @Bean("SQLExecutor")
    SQLExecutor executor() {
        SQLExecutor exe = jsqlConfig.executor(env.getProperty("app.db.testdb.name"));
        System.out.println("Created DB Connections.");
        return exe;
    }

    @PersistenceContext
    EntityManager manager;

    @Bean("JPQLExecutor")
    JPQLExecutor jpqlExecutor(){
        JPQLExecutor executor = new JPQLExecutor(manager);
        return executor;
    }

    @Bean("JPQLExecutorPAX")
    JPQLExecutor jpqlExecutorPAX(){
        ORMController controller = new ORMController("testDB-debug");
        JPQLExecutor executor = new JPQLExecutor(controller.getEntityManager());
        return executor;
    }

}
