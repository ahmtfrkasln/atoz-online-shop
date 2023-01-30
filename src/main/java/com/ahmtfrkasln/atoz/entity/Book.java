package com.ahmtfrkasln.atoz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author", length = 100)
    private String author;

    @Column(name = "pages")
    private Long pages;

    @JoinColumn(name = "product_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
}
