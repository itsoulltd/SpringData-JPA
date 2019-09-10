package com.itsoul.lab.jpa.app;

import com.it.soul.lab.sql.SQLExecutor;
import com.it.soul.lab.sql.entity.Entity;
import com.it.soul.lab.sql.query.QueryType;
import com.it.soul.lab.sql.query.SQLQuery;
import com.it.soul.lab.sql.query.SQLScalarQuery;
import com.itsoul.lab.jpa.entites.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;

@Component
public class JpaDemoBootsStrap {

    enum Sex{
        Male,
        Female,
        Other
    }

    String[] names = new String[]{"Mrs.Sohana","Mr.Towhid","Mr.Tanvir","Miss.Sumaiya","Miss.Tusin"};
    Integer[] ages = new Integer[] {15, 18, 28, 26, 32, 34, 25, 67};

    @Autowired @Qualifier("SQLExecutor")
    SQLExecutor executor;

    private Logger log = Logger.getLogger(this.getClass().getSimpleName());

    @EventListener({ContextRefreshedEvent.class})
    public void contextRefreshed(){

        Random random = new Random();

        try {
            SQLScalarQuery check = new SQLQuery.Builder(QueryType.COUNT)
                    .columns().on(Entity.tableName(Passenger.class)).build();
            int count = executor.getScalarValue(check);
            if (count <= 0){
                int randIterator = names.length;
                for (int index = 0; index < randIterator; index++){
                    Passenger passenger = new Passenger();
                    int index_age = random.nextInt(ages.length -2) + 1;
                    passenger.setAge(ages[index_age]);
                    //
                    int index_name = random.nextInt(names.length -2) + 1;
                    passenger.setName(names[index_name]);
                    //
                    if (passenger.getName().toLowerCase().startsWith("mr")){
                        passenger.setSex(Sex.Male.name());
                    }else if (passenger.getName().toLowerCase().startsWith("mrs")
                            || passenger.getName().toLowerCase().startsWith("miss")){
                        passenger.setSex(Sex.Female.name());
                    }else {
                        passenger.setSex(Sex.Other.name());
                    }
                    if (passenger.insert(executor)){
                        log.info(passenger.getName() + " inserted.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
