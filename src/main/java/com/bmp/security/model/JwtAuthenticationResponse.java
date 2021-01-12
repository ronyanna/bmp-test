package com.bmp.security.model;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {
    private  static final long serialVersionUID=9345830942850394L;
    private String userName;
    private final String token;

    public JwtAuthenticationResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }
}
