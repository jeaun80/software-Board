package com.example.softwareboard.domain;

import com.example.softwareboard.BaseTimeEntity;
import com.example.softwareboard.domain.user.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Secret extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Secid")
    private Long id;

    @Column(length = 40, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long hit;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memnum")
    private Member memnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SecWriterId")
    private Member SecWriter;

    @OneToMany(mappedBy = "sec", cascade = ALL, orphanRemoval = true)
    private List<SecComment> secCommentList = new ArrayList<>();

    public void confirmSecWriter(Member SecWriter){
        this.SecWriter = SecWriter;
        SecWriter.addSecret(this);
    }
}
