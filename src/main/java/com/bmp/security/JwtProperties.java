package com.bmp.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jwt")
public class JwtProperties {
    private String header;
    private String secret;
    private long expiration;
    private String routeAuthenticationPath;
    private String routeAuthenticationRefresh;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getRouteAuthenticationPath() {
        return routeAuthenticationPath;
    }

    public void setRouteAuthenticationPath(String routeAuthenticationPath) {
        this.routeAuthenticationPath = routeAuthenticationPath;
    }

    public String getRouteAuthenticationRefresh() {
        return routeAuthenticationRefresh;
    }

    public void setRouteAuthenticationRefresh(String routeAuthenticationRefresh) {
        this.routeAuthenticationRefresh = routeAuthenticationRefresh;
    }
}
