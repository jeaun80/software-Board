package com.example.softwareboard.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<member,String> {
}
