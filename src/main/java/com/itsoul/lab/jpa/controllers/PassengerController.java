package com.itsoul.lab.jpa.controllers;

import com.itsoul.lab.jpa.entites.Passenger;
import com.itsoul.lab.jpa.repository.PassengerRepository;
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
        Passenger pass = passengerRepository.findByName(name);
        System.out.println(pass.getId()+":"+pass.getAge());
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
