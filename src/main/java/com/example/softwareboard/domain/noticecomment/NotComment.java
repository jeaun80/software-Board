package com.example.softwareboard.domain;

import com.example.softwareboard.BaseTimeEntity;
import com.example.softwareboard.domain.notice.Notice;
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
public class NotComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotCmtId")
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime datetime;

    private boolean isRemoved = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NotID")
    private Notice not;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NotWriterId")
    private Member NotWriter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NotParentId")
    private NotComment NotParent;

    //부모 댓글은 삭제해도 자식 댓글은 남음//
    @OneToMany(mappedBy = "NotParent")
    private List<NotComment> NotchildList = new ArrayList<>();

    //연관관계 편의 메서드//
    public void confirmNotWriter(Member NotWriter){
        this.NotWriter = NotWriter;
        NotWriter.addNoticeComment(this);
    }

    public void confirmNotice(Notice notice){
        this.not = not;
        notice.addNotComment(this);
    }

    @Builder
    public NotComment(Member NotWriter, Notice not, NotComment NotParent, String content, LocalDateTime datetime){
        this.content = content;
        this.datetime = datetime;
        this.NotParent = NotParent;
        this.NotWriter = NotWriter;
        this.not = not;
    }
}
