package com.example.softwareboard.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "indexController")
public class indexcontroller {
    @ApiOperation(value = "test", notes = "테스트입니다.!!")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK~!!!!"), @ApiResponse(code = 404, message = "page not found!!!!!")
    })
    @GetMapping("hello") public List<String> hello() { return Arrays.asList("안녕", "Hello"); }

}
