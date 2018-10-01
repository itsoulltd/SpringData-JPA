package com.itsoul.lab.jpa.entites;

import com.itsoul.lab.jpa.entites.converters.TimeStampConverter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Person {
    @Id
    private String uuid;
    @Column
    private String name;
    @Column
    private Integer age;

    @Column(nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;

    @Column
    private Double salary;
    @Column
    private Float height;

    @Column(nullable = true)
    private Date dob;
//
//    @Column(nullable = true)
//    @Temporal(TemporalType.DATE)
//    private Date dobDate;
//
//    @Column(nullable = true)
//    //@Convert(converter = TimeStampConverter.class)
//    private LocalDateTime createDate;
//
//    @Column(nullable = true)
//    private Time createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
//
//    public Date getDobDate() {
//        return dobDate;
//    }
//
//    public void setDobDate(Date dobDate) {
//        this.dobDate = dobDate;
//    }
//

//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }

//
//    public Time getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Time createTime) {
//        this.createTime = createTime;
//    }
}
