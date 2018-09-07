package com.itsoul.lab.jpa.repositories;

import com.itsoul.lab.jpa.entites.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
    public Passenger findByName(String name);
}
