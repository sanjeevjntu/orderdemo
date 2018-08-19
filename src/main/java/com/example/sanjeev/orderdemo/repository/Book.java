package com.example.sanjeev.orderdemo.repository;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String title;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

 /*   @ManyToOne
    @JoinColumn(name="library_id")
    private Library library;*/

    // standard constructor, getter, setter
}