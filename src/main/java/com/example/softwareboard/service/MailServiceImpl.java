package com.example.softwareboard.service;

import com.example.softwareboard.domain.mail.Mail;
import com.example.softwareboard.domain.mail.MailChekeDto;
import com.example.softwareboard.domain.mail.MailDto;
import com.example.softwareboard.domain.mail.MailRepository;
import com.example.softwareboard.domain.user.Member;
import com.example.softwareboard.domain.user.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
class MailServicelpml implements MailService{
    private final MailRepository repository;
    private final MemberRepository memberRepository;

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "YOUR_EMAIL_ADDRESS";

    public String getAuthCode(int n) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < n) {
            num = random.nextInt(10);
            buffer.append(num);
        }
        return buffer.toString();
    }
    //인증코드 난수 발생
    @Override
    public void setNum(String mail, String key) {
        repository.save(Mail.builder().email(mail).sixkey(key).build());
    }

    @Override
    public void mailSend(MailDto mailDto) {
        if(mailDto.getEmail()==null){

        }
        SimpleMailMessage message = new SimpleMailMessage();
        String email = mailDto.getEmail();
        String authKey = getAuthCode(6);

        mailDto.setTitle("회원가입 인증번호 도착!");
        mailDto.setMsg("아래의 번호는 이메일 인증 번호입니다.\n" + authKey + "\n 인증번호를 입력해주세요!");

        message.setTo(email);
        message.setFrom(MailServicelpml.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMsg());

        mailSender.send(message);
        setNum(email, authKey);
    }
    @Override
    public void passwordsend(MailDto mailDto){
        SimpleMailMessage pwdmessage = new SimpleMailMessage();
        String email = mailDto.getEmail();
        String authKey = getAuthCode(6);

        mailDto.setTitle("임시비밀번호 도착!");
        mailDto.setMsg("아래의 번호는 임시비밀번호입니다.\n" + authKey + "\n");

        pwdmessage.setTo(email);
        pwdmessage.setFrom(MailServicelpml.FROM_ADDRESS);
        pwdmessage.setSubject(mailDto.getTitle());
        pwdmessage.setText(mailDto.getMsg());

        mailSender.send(pwdmessage);
    }
    @Override
    public boolean EmailDuplicate(MailDto mailDto) {
        Optional<Member> user=memberRepository.findByKnuemail(mailDto.getEmail());
        if(user.isPresent()){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean checkNum(MailChekeDto mailchekeDto) {
        Optional<Mail> res = repository.findById(mailchekeDto.getEmail());
        if (res.isPresent()){
            Mail entity = res.get();
            if (entity.getSixkey().equals(mailchekeDto.getSixkey())) {
                repository.delete(entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public void register(MailDto dto) {
        repository.save(dtoToEntity(dto)); //dto -> dao -> repository -> db
    }


    @Override
    public void delete(MailDto dto) {
        repository.delete(dtoToEntity(dto));
    }


}

