package com.ahmtfrkasln.atoz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cd")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "artist", length = 100)
    private String artist;

    @Column(name = "tracks_count")
    private Long tracksCount;

    @JoinColumn(name = "product_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
}
