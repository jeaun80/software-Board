package com.example.softwareboard.domain.mail;


import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailChekeDto {

    private String email;
    private String key;

}
