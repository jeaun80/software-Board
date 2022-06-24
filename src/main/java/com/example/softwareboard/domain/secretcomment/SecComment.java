package com.example.softwareboard.domain;

import com.example.softwareboard.BaseTimeEntity;
import com.example.softwareboard.domain.secret.Secret;
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
public class SecComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SecCmtId")
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime datetime;

    private boolean isRemoved = false;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Secid")
    private Secret sec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SecWriterId")
    private Member SecWriter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SecParentId")
    private SecComment SecParent;

    //부모 댓글은 삭제해도 자식 댓글은 남음//
    @OneToMany(mappedBy = "SecParent")
    private List<SecComment> SecchildList = new ArrayList<>();

    public void confirmSecWriter(Member SecWriter){
        this.SecWriter = SecWriter;
        SecWriter.addSecretComment(this);
    }

    public void confirmSecret(Secret secret){
        this.sec = sec;
        secret.addSecComment(this);
    }

    @Builder
    public SecComment(Secret sec, SecComment SecParent, Member SecWriter, String content, LocalDateTime datetime){
        this.content = content;
        this.datetime = datetime;
        this.sec = sec;
        this.SecParent = SecParent;
        this.SecWriter = SecWriter;
    }
}
