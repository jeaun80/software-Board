package com.example.softwareboard.service;

import com.example.softwareboard.domain.mail.Mail;
import com.example.softwareboard.domain.mail.MailChekeDto;
import com.example.softwareboard.domain.mail.MailDto;

public interface MailService {


    void register(MailDto dto);
    void delete(MailDto dto);
    void setNum(String address, String num);
    void mailSend(MailDto mailDto);
    String getAuthCode(int n);
    boolean checkNum(MailChekeDto mailchekeDto);
    boolean EmailDuplicate(MailDto mailDto);

    default Mail dtoToEntity(MailDto dto) {
        Mail entity = Mail.builder()
                .mail(dto.getMail())
                .key(dto.getKey())
                .build();

        return entity;
    }

    default MailDto entityToDto(Mail entity){
        MailDto dto = MailDto.builder()
                .mail(entity.getMail())
                .key(entity.getKey())
                .build();
        return dto;
    }

}
