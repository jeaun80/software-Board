package com.example.softwareboard.domain.user;

import com.example.softwareboard.domain.*;
import com.example.softwareboard.domain.notice.Notice;
import com.example.softwareboard.domain.qna.Qna;
import com.example.softwareboard.domain.secret.Secret;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

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

    @Builder.Default
    @OneToMany(mappedBy = "NotWriter", cascade = ALL, orphanRemoval = true)
    private List<NotComment> notCommentList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "QnaWriter", cascade = ALL, orphanRemoval = true)
    private List<QnaComment> qnaCommentList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "SecWriter", cascade = ALL, orphanRemoval = true)
    private List<SecComment> secCommentList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "NotWriter", cascade = ALL, orphanRemoval = true)
    private List<Notice> noticeList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "QnaWriter", cascade = ALL, orphanRemoval = true)
    private List<Qna> qnaList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "SecWriter", cascade = ALL, orphanRemoval = true)
    private List<Secret> secretList = new ArrayList<>();

    //연관관계 메서드//
    public void addNotice(Notice notice){
        noticeList.add(notice);
    }

    public void addQna(Qna qna){
        qnaList.add(qna);
    }

    public void addSecret(Secret secret){
        secretList.add(secret);
    }

    public void addNoticeComment(NotComment notComment){
        notCommentList.add(notComment);
    }

    public void addQnaComment(QnaComment qnaComment){
        qnaCommentList.add(qnaComment);
    }

    public void addSecretComment(SecComment secComment){
        secCommentList.add(secComment);
    }

}