package com.example.softwareboard.service;


import com.example.softwareboard.domain.post.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final NoticeRepository noticeRepository;


}
