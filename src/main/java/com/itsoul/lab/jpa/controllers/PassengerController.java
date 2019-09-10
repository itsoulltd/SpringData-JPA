package com.itsoul.lab.jpa.controllers;

import com.itsoul.lab.jpa.entites.Passenger;
import com.itsoul.lab.jpa.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @RequestMapping("/find")
    @ResponseBody
    public Passenger findBy(String name){
        List<Passenger> passengers = passengerRepository.findByName(name);
        if (passengers != null && passengers.size() > 0) {
            return passengers.get(0);
        }
        Passenger pass = new Passenger();
        pass.setName("Not Found!");
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
