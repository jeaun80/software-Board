package com.example.softwareboard.controller;

import com.example.softwareboard.domain.mail.MailChekeDto;
import com.example.softwareboard.domain.mail.MailDto;
import com.example.softwareboard.domain.user.FindMemberIdDto;
import com.example.softwareboard.service.MailService;
import com.example.softwareboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MailService mailService;
    //회원가입
    //회원가입시 확인
    //이메일중복검사
    //메일전송
    //id중복검사
    //비밀번호재발급
    //회원탈퇴



    //로그인
    @PostMapping("/auth/user/login")
    public String login(){
        return "/";
    }
    //이메일중복검사
    @PostMapping("/")
    public boolean a(@RequestBody String requestmail){
        boolean duplicatemail = memberService.dupicateEmail(requestmail);
        return duplicatemail;
    }

    //메일전송
    @PostMapping("/")
    public void b(@RequestBody MailDto mailDto){
        mailService.mailSend(mailDto);
    }

    //메일 인증 키 같은지 검사
    @PostMapping("//")
    public boolean c(@RequestBody MailChekeDto mailChekeDto){
        if(mailService.checkNum(mailChekeDto)){
            return true;
        }
        else{
            return false;
        }

    }

    //id중복검사
    @PostMapping("///da")
    public boolean d(@RequestBody String requstid){
        if(memberService.duplicateId(requstid)){
         return true;
        }
        else{
            return false;
        }
    }

    //비밀번호 재발급
    @PostMapping("dkfa")
    public void e(@RequestBody FindMemberIdDto findMemberIdDto){
        mailService.mailSend(memberService.repassword(findMemberIdDto));
    }



    //id찾기
    @PostMapping("/dka")
    public void f(@RequestBody FindMemberIdDto findMemberIdDto){
        memberService.findId(findMemberIdDto);
    }
}
