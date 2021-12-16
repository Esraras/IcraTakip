package com.esra.kgm.entity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="borc")
public class Entry {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;
    private String evrakKayit;
    private String icraTuru;
    private String dosyaNo;
    private String aciklama;
    private String icraMudur;
    private String alacakli;
    private LocalDate kurumaGirisTarihi;
    private LocalDate icraTarihi;
    private BigDecimal borcTutari;
    private BigDecimal odenenBorc;
    private String maas;
    private String ikramiye;
    private LocalDate bitisTarihi;

}
