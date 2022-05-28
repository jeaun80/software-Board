package com.example.softwareboard.domain.mail;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@NoArgsConstructor
public class MailChekeDto {

    private String mail;
    private String key;

}
