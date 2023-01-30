package com.ahmtfrkasln.atoz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dvd")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dvd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "run_time")
    private Long runTime;

    @JoinColumn(name = "product_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
}
