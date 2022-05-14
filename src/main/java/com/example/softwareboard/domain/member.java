package com.example.softwareboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_num")
    private Long mem_num; //primary key

    @Column(nullable = false, length = 30, unique = true)
    private String mem_id; //회원 아이디

    private String mem_knuemail; //회원 학교 이메일

    private String mem_nickname; //회원 닉네임

    private String mem_password; //회원 비밀번호

    private Long mem_StudentID; //회원 학번

    @Column(nullable = false, length = 30)
    private String mem_name;

    @OneToMany(mappedBy = "notice")
    private List<notice> a = new ArrayList<>();

}