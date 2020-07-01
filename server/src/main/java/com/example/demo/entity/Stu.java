package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Stu implements Serializable {

    public Stu(){

    }

    public Stu(String name, Integer age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Stu(String id, String name, Integer age, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    protected String id;
    @Column(nullable = false)
    private String name;
    @Column
    private Integer age;
    @Column
    private String address;
}
