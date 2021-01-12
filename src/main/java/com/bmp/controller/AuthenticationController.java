package com.bmp.controller;


import com.bmp.exception.AuthenticationException;
import com.bmp.security.JwtProperties;
import com.bmp.security.JwtTokenUtil;
import com.bmp.security.model.JwtAuthenticationRequest;
import com.bmp.security.model.JwtAuthenticationResponse;
import com.bmp.security.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        //authenticate(authenticationRequest.getUserName(),authenticationRequest.getPassword());
        final JwtUser userDetails=(JwtUser)userDetailService.loadUserByUsername(authenticationRequest.getUserName());
        final String token=jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    private void authenticate(String userName, String password) {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }
        catch (DisabledException ex){
            throw new AuthenticationException("User is disabled",ex);
        }
        catch (BadCredentialsException ex){
            throw new AuthenticationException("Bad Credentials!",ex);
        }
    }

}
