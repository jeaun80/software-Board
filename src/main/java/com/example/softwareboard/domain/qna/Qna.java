package com.example.softwareboard.domain;

import com.example.softwareboard.BaseTimeEntity;
import com.example.softwareboard.domain.user.Member;
import lombok.AccessLevel;
import lombok.Builder;
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
public class Qna extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QnaId")
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
    @JoinColumn(name = "QnaWriterId")
    private Member QnaWriter;

    @OneToMany(mappedBy = "qna", cascade = ALL, orphanRemoval = true)
    private List<QnaComment> qnaCommentList = new ArrayList<>();

    public void confirmQnaWriter(Member QnaWriter){
        this.QnaWriter = QnaWriter;
        QnaWriter.addQna(this);
    }

    public void addQnaComment(QnaComment qnaComment){
        qnaCommentList.add(qnaComment);
    }

    @Builder
    public Qna(String title, String content, Long hit, LocalDateTime datetime) {
        this.content = content;
        this.hit = hit;
        this.datetime = datetime;
        this.title = title;
    }

}
