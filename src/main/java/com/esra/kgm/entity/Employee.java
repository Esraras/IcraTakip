package com.esra.kgm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Entry.class)
    @OrderBy("id")
    private List<Entry> entries = new ArrayList<>();
}
