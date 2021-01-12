package com.bmp.security.model;

import java.io.Serializable;

public class JwtAuthenticationRequest  implements Serializable {
    private  static final long serialVersionUID=3242352323432L;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtAuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
