package com.example.jpa_demo.Model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "MovieName")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NameOfMovie")
    private String movieName;            //->movie_Name->movie_name

    private String language;

    private int ratings;

    private boolean isActive;

    private long timeStamp;

}
