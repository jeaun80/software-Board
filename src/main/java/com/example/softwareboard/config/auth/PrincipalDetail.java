package com.example.softwareboard.config.auth;

import com.example.softwareboard.domain.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class PrincipalDetail implements UserDetails {

    private final Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(() -> member.getRole().getKey());
        return collection;
    }

    //사용자 패스워드
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    //사용자 아이디
    @Override
    public String getUsername() {
        return member.getMid();
    }

    public Member getUser(){return member;}

    //사용자 이메일
    public String getEmail() {
        return member.getKnuemail();
    }
    public void setUser(Member member){
        member=this.member;
    }


    //사용자 pk
    public Long getId() {
        return member.getMemnum();
    }


    //public Long getUser(){ return user.getUsername();}
    //계정이 만료되었는지 (true: 만료되지 않음)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있는지 (true: 잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //패스워드가 만료되지 않았는지 (true: 만료되지 않음)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화되어 있는지 (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

}
