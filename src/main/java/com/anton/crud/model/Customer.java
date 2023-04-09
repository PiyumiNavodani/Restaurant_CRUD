package com.anton.crud.model;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table (name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column (name = "customerName")
    public String customerName;

    @Column(name = "customerTp")
    public String customerTp;

    @Column(name = "numberOfItemsBought")
    public int numberOfItemsBought;

    @Column(name = "totalPrice")
    public double totalPrice;

}
