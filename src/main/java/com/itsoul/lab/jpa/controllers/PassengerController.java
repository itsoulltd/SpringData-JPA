package com.itsoul.lab.jpa.controllers;

import com.it.soul.lab.jpql.service.JPQLExecutor;
import com.it.soul.lab.sql.query.models.Predicate;
import com.it.soul.lab.sql.query.models.Where;
import com.itsoul.lab.jpa.entites.Passenger;
import com.itsoul.lab.jpa.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class PassengerController {

    private Logger log = Logger.getLogger(this.getClass().getSimpleName());

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired @Qualifier("JPQLExecutor")
    private JPQLExecutor executor;

    @RequestMapping("/find")
    @ResponseBody @SuppressWarnings("Duplicates")
    public Passenger findBy(String name){
        List<Passenger> passengers = passengerRepository.findByName(name);
        if (passengers != null && passengers.size() > 0) {
            return passengers.get(0);
        }
        Passenger pass = new Passenger();
        pass.setName("Not Found!");
        return pass;
    }

    @RequestMapping("/findByName")
    @ResponseBody @SuppressWarnings("Duplicates")
    @Transactional
    public Passenger findByName(String name){
        Passenger pass = null;
        try {
            Predicate where = new Where("name").isEqualTo(name);
            List<Passenger> passengers = Passenger.read(Passenger.class, executor, where);
            if (passengers != null && passengers.size() > 0) {
                pass = passengers.get(0);
            }
        } catch (Exception e) {
            log.warning(e.getMessage());
            pass = new Passenger();
            pass.setName(e.getMessage());
        }
        return pass;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Passenger> findAll(){
        List<Passenger> items = (List<Passenger>) passengerRepository.findAll();
        items.forEach(passenger -> System.out.println(passenger.getName()));
        return items;
    }

}
