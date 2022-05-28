package com.example.softwareboard.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memnum")
    private Long memnum; //primary key

    @Column(nullable = false, length = 30, unique = true)
    private String mid; //회원 아이디

    private String knuemail; //회원 학교 이메일

    private String nickname; //회원 닉네임

    private String password; //회원 비밀번호

    private Long StudentID; //회원 학번

    @Column(nullable = false, length = 30)
    private String name;

    private Role role;

    public void setPassword(String password) {
        this.password = password;
    }
}