package com.example.softwareboard.domain.mail;


import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailChekeDto {

    private String mail;
    private String key;

}
