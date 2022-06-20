package com.example.softwareboard.domain.mail;


import io.swagger.annotations.ApiParam;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailChekeDto {

    @ApiParam(value = "이메일",required = true)
    private String email;
    @ApiParam(value = "인증번호")
    private String sixkey;

}
