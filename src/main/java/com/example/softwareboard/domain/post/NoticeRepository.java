package com.example.softwareboard.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<notice,String> {

}
