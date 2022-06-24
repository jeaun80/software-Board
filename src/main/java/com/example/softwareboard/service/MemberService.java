package com.example.softwareboard.service;


import com.example.softwareboard.domain.mail.MailDto;
import com.example.softwareboard.domain.user.FindMemberIdDto;
import com.example.softwareboard.domain.user.Member;
import com.example.softwareboard.domain.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //1 . 회원가입  --> 아이디 비밀번호 닉네임 이메일 학번 별명
    //1_1 아이디중복검사 --> string
    //1_2 이메일중복검사

    //2 . 아이디찾기 -->학교이메일 학번,이름 정보필요
    //3 . 비밀번호재발급
    //4 . 회원탈퇴 -->비밀번호
    @Transactional//회원가입
    public Long register(Member member){
        String hashPW=bCryptPasswordEncoder.encode(member.getPassword());
        member.setPassword(hashPW);
        return memberRepository.save(member).getMemnum();
    }

    @Transactional//id중복검사
    public boolean duplicateId(String newid){
        Optional<Member> duplicateId=memberRepository.findByMid(newid);
        if(duplicateId.isPresent()){
            return false;
        }
        return true;
    }

    @Transactional//이메일 중복검사
    public boolean dupicateEmail(String newemail){
        Optional<Member> duplicateEmail =memberRepository.findByKnuemail(newemail);
        if(duplicateEmail.isPresent()){
            return false;
        }
        return true;
    }


    //id를 찾앗을경우 id return
    //못찾을 경우
    @Transactional //id찾기
    public String findId(FindMemberIdDto findMemberIdDto){
        Member member = memberRepository.findByKnuemail(findMemberIdDto.getKnuemail()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
        if(member.getStudentID().equals(findMemberIdDto.getStudentId())){
            return findMemberIdDto.getMid();
        }
        return findMemberIdDto.getStudentId();
    }


    //1. 아이디 이름 생년월일 학번 메일
    //2. 아이디 이름 생년월일 학번 메일이 전부 일치하면 즉 knuemil로 해당 로우를 member객체로 받은뒤 아이디 이름 생년월일 학번을 비교 모두 같으면 메일전송
    //3, 같으면 일단 true값 반환
    //4, 비번 재발급하기위해 정보일치 확인 true갑반환 -> 컨트롤러에true반환시 메일샌드 서비스 컨트롤러

    @Transactional //비밀번호 재발급
    public MailDto repassword(FindMemberIdDto findMemberIdDto){
        Member member = memberRepository.findByKnuemail(findMemberIdDto.getKnuemail()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
        if(member.getStudentID().equals(findMemberIdDto.getStudentId()) && member.getMid().equals(findMemberIdDto.getMid())){
            if(member.getName().equals(findMemberIdDto.getName())){
                MailDto mailDto=null;
                mailDto.builder()
                    .email(findMemberIdDto.getKnuemail())
                    .build();
                if(mailDto.getEmail()==null){
                    return null;
                }
                else{
                    return mailDto;
                }
            }
            return null;
        }
        return null;
    }

}
