package com.bmp.security;

import com.bmp.model.Authority;
import com.bmp.model.User;
import com.bmp.security.model.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                mapToAuthorities(user.getAuthorities())

        );
    }
    private static  List<GrantedAuthority> mapToAuthorities(List<Authority> authorities)
    {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name())).collect(Collectors.toList());
    }


}
