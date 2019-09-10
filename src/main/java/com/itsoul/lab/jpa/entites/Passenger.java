package com.itsoul.lab.jpa.entites;

import com.it.soul.lab.sql.entity.PrimaryKey;

import javax.persistence.*;

@Entity
@Table(name = "Passenger")
public class Passenger extends com.it.soul.lab.sql.entity.Entity {
    @Id @PrimaryKey(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
