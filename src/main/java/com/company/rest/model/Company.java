package com.company.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String country;
    private Integer phone;

    @OneToMany(targetEntity = Owner.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cmp_fc", referencedColumnName = "id")
    private List<Owner> owners = new ArrayList<>();
}
