package com.example.softwareboard.domain.post;

import com.example.softwareboard.BaseTimeEntity;
import com.example.softwareboard.domain.comment.NotComment;
import com.example.softwareboard.domain.user.member;
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
public class Notice extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotID")
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

    @Column(nullable = true)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_num")
    private member mem_num;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NotWriterId")
    private member NotWriter;

    @OneToMany(mappedBy = "not", cascade = ALL, orphanRemoval = true)
    private List<NotComment> notCommentList = new ArrayList<>();

    public void confirmNotWriter(member NotWriter){
        this.NotWriter = NotWriter;
        NotWriter.addNotice(this);
    }

    public void addNotComment(NotComment notComment){
        notCommentList.add(notComment);
    }

    @Builder
    public Notice(String title, String filePath, String content, Long hit, LocalDateTime datetime){
        this.content = content;
        this.datetime = datetime;
        this.hit = hit;
        this.title = title;
        this.filePath = filePath;
    }

    public void updateNotTitle(String title) {this.title = title;}

    private void updateNotContent(String content) {this.content = content;}

    public void updateNotFilePath(String filePath) {this.filePath = filePath;}

}
