package com.example.softwareboard.domain.user;


import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class FindMemberIdDto {

    @ApiParam(value = "아이디")
    private String mid;

    @ApiParam(value = "이메일")
    private String knuemail;

    @ApiParam(value = "학번")
    private String StudentId;

    @ApiParam(value = "이름")
    private String name;
}
