package com.anton.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table (name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    public  long id;

    @Column(name = "empName")
    public String empName;

    @Column(name = "empAge")
    public int empAge;

    @Column(name = "empDesignation")
    public String empDesignation;

    @Column(name = "empSalary")
    public double empSalary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empDesignation='" + empDesignation + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
