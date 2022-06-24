package com.example.softwareboard.domain.mail;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
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

    @ApiModelProperty(
            name = "maildto"
            , example = "gillog"
    )
    @ApiParam(value = "이메일", required = true)
    private String email;
    @ApiParam(value = "제목")
    private String title;
    @ApiParam(value = "내용")
    private String msg;
    @ApiParam(value = "인증번호")
    private String sixkey;
}
