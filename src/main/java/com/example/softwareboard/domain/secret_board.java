package com.example.softwareboard.domain;

import javax.persistence.*;

@Entity
public class secret_board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sb_id;

    @Column(nullable = false,length = 100)
    private String sb_title;

    @Column()
    private String sb_content;


}
