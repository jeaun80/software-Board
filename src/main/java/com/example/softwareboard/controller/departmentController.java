package com.example.softwareboard.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="departmentController")
public class departmentController {
    @ApiOperation(value = "학과소개페이지", notes = "학과소개(정적페이지)로 반환")
    @GetMapping("/department")
    public void department(){} //학과소개

    @ApiOperation(value = "학과소개 - 과사무실소개페이지 ", notes = "과사무실(정적페이지)로 반환")
    @GetMapping("/department/office")
    public void office(){} //학과소개 - 과사무실소개

    @ApiOperation(value = "학과소개 - 교수소개페이지 ", notes = "교수소개(정적페이지)로 반환")
    @GetMapping("department/professor")
    public void professor(){} // 학과소개 - 교수소개

    @ApiOperation(value = "학사안내", notes = "경북대 학사안내페이지로 반환-구현완")
    @GetMapping("/introduce") // 학사안내 - url 새창
    public String introduce(){return "https://www.knu.ac.kr/wbbs/wbbs/contents/index.action?menu_url=edu/academic03&menu_idx=44";}

    @ApiOperation(value = "학과공지", notes = "공지게시물 id,제목,게시날짜,게시한사람이름,조회수을 model로 넘겨준다.")
    @GetMapping("/notice") //학과공지 return-
    public String notice(){return "/departement/notice";}

    @ApiOperation(value = "학과공지 상세조회", notes = "게시물 id,제목,게시날짜,사람이름, 내용,조회수을 model에 넘겨준다")
    @GetMapping("/notce/post-check/{id}") //학과공지 상세조회 게시물id값넘겨줌
    public String postcheck(){return "/notce/post-check/id";}

    @ApiOperation(value = "학과공지 게시물생성페이지 ", notes = "관리자권한만 사용가능 공지글 데이터입력페이지")
    @PostMapping("/notice/before-post") //학과공지 공지 생성
    public String beforepost(){return "Undefined";}

    @ApiOperation(value = "학과공지 게시물생성 ", notes = "제목,내용 데이터db저장,게시물id,날짜자동부여 , 학과공지페이지로 리다이렉트")
    @PostMapping("/notice/post")
    public String posting(){return "Undefined";}

    @ApiOperation(value = "학과공지 상세조회-게시물삭제 ", notes = "게시물 Id row 전체삭제,학과공지페이지로 리다이렉트")
    @PostMapping("/notce/delete")
    public String delete(){return "Undefined";}
}
