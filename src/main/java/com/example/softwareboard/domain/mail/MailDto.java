package com.example.softwareboard.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MailDto {

    private String mail;
    private String title;
    private String msg;
    private String key;
}
