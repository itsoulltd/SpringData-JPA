package com.itsoul.lab.jpa.app;

import com.it.soul.lab.connect.JDBConnectionPool;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.ResourceBundle;

@Component
public class ContextRefreshEventHandler {

    @EventListener({ContextRefreshedEvent.class})
    public void contextRefreshed(){
        //
    }

}
