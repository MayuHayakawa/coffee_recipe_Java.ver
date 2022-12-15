package com.webapp.coffeesearch.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fav")
public class Fav {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_sequence")
    @SequenceGenerator(name = "fav_sequence")
    @Column(name = "fav_id")
    private Long favId;

    @Column(name = "favdrink_id")
    private Long favDrinkId;

    @Column(name = "favdrink_type")
    private String favDrinkType;

    @Column(name = "fav_check")
    private Boolean favCheck;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    
}
