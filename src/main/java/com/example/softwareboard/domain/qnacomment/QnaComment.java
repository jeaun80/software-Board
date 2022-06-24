package com.example.softwareboard.domain;

import com.example.softwareboard.BaseTimeEntity;
import com.example.softwareboard.domain.qna.Qna;
import com.example.softwareboard.domain.user.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class QnaComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QnaCmtId")
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime datetime;

    private boolean isRemoved = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QnaId")
    private Qna qna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QnaWriterId")
    private Member QnaWriter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QnaParentId")
    private QnaComment QnaParent;

    //부모 댓글은 삭제해도 자식 댓글은 남음//
    @OneToMany(mappedBy = "QnaParent")
    private List<QnaComment> QnachildList = new ArrayList<>();

    public void confirmQnaWriter(Member QnaWriter){
        this.QnaWriter = QnaWriter;
        QnaWriter.addQnaComment(this);
    }

    public void confirmQna(Qna qna){
        this.qna = qna;
        qna.addQnaComment(this);
    }

    @Builder
    public QnaComment(Qna qna, Member QnaWriter, QnaComment QnaParent, String content, LocalDateTime datetime){
        this.content = content;
        this.datetime = datetime;
        this.QnaParent = QnaParent;
        this.qna = qna;
        this.QnaWriter = QnaWriter;
    }

}
