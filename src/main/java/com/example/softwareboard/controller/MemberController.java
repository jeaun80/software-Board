package com.example.softwareboard.controller;

import com.example.softwareboard.domain.mail.MailChekeDto;
import com.example.softwareboard.domain.mail.MailDto;
import com.example.softwareboard.domain.user.FindMemberIdDto;
import com.example.softwareboard.service.MailService;
import com.example.softwareboard.service.MemberService;
import io.swagger.annotations.ApiOperation;
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



    @GetMapping("/auth/user/loogin")
    public String login(){
        return "/";
    }
    //이메일중복검사
    @ApiOperation(value = "이메일 중복검사", notes = "이메일 을 받아서 중복검사버튼에 드가면 됩니다이")
    @PostMapping("/email/duplicate")
    public boolean duplicateEmail(@RequestBody String requestmail){
        boolean duplicatemail = memberService.dupicateEmail(requestmail);
        return duplicatemail;
    }

    //메일전송
    @ApiOperation(value = "이메일 전송", notes = "중복검사 통과->입력된 이메일로 이메일전송")
    @PostMapping("/email/send")
    public void mailSend(@RequestBody MailDto mailDto){
        mailService.mailSend(mailDto);
    }

    //메일 인증 키 같은지 검사
    @ApiOperation(value = "인증번호 검사", notes = "이메일전송 -> 이메일 인증확인버튼")
    @PostMapping("/email/key-check")
    public boolean keyCheck(@RequestBody MailChekeDto mailChekeDto){
        if(mailService.checkNum(mailChekeDto)){
            return true;
        }
        else{
            return false;
        }

    }

    //id중복검사
    @ApiOperation(value = "id 중복검사", notes = "id중복검사버튼에 넣기")
    @PostMapping("/email/duplicate-id")
    public boolean duplicateId(@RequestBody String requstid){
        if(memberService.duplicateId(requstid)){
         return true;
        }
        else{
            return false;
        }
    }

    //비밀번호 재발급
    @ApiOperation(value = "비밀번호 재발급", notes = "비밀번호 재발급 버튼으로 이메일로 인증번호를 보냄")
    @PostMapping("/email/repassword")
    public void passwordSend(@RequestBody FindMemberIdDto findMemberIdDto){
        mailService.passwordsend(memberService.repassword(findMemberIdDto));

    }



    //id찾기
    @PostMapping("/email/6")
    public void f(@RequestBody FindMemberIdDto findMemberIdDto){
        memberService.findId(findMemberIdDto);
    }
}
