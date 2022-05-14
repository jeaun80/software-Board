package com.example.softwareboard.domain.post;

import com.example.softwareboard.domain.user.member;
import com.example.softwareboard.domain.secret_board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter

@NoArgsConstructor
public class notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long not_id;

    @Column(nullable = false)
    private String not_title;

    @Column(nullable = false)
    private String not_content;

    @Column(nullable = false,columnDefinition = "DATETIME DEFAULT CURRENT_DATE")
    private String not_datetime;

    @Column(nullable = false)
    private int not_hit;

    @OneToMany(mappedBy = "secret_board")
    private List<secret_board> a = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_num")
    private member mem_num;






}
