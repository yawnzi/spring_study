package com.example.sboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cost;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt=new Date();

    //리뷰(N):고객(1)
    @ManyToOne
    //Customer라는 컬럼이 없기 때문에 FK를 만들어줘야 함
    @JoinColumn(name = "customer_id",referencedColumnName = "id", nullable = false) //FK
    private Customer customer;  //PK(id)

    //리뷰(N):책(1)
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)  //FK
    private Book book;  //PK(id)
}
