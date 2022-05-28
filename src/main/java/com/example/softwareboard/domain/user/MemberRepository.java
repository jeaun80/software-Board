package com.example.softwareboard.domain.user;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@NoArgsConstructor
public interface MemberRepository extends JpaRepository<Member,String> {

    Optional<Member> findByMid(String newid);
    Optional<Member> findByKnuemail(String email);
}
