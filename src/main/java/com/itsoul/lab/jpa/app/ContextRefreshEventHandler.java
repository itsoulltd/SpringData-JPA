package com.itsoul.lab.jpa.app;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshEventHandler {

    @EventListener({ContextRefreshedEvent.class})
    public void contextRefreshed(){
        //
    }

}
