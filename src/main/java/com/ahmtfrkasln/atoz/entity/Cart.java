package com.ahmtfrkasln.atoz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
    @JoinColumn(name = "user_id")
    @ManyToOne()
    private User user;
    */

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}
