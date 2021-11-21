package com.esra.kgm.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="personel")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String fname;
    private String lname;
    private Integer IDNumber;
    private Integer registration;
    private String department;
}
