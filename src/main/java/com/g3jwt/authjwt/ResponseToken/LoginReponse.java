package com.g3jwt.authjwt.ResponseToken;

public class LoginReponse {
    private String token;
    private long expirationTimeIn;

    public String getToken() {
        return token;
    }
    public LoginReponse setToken(String token) {
        this.token = token;
        return this;
    }
    public long getExpirationTimeIn() {
        return expirationTimeIn;
    }
    public LoginReponse setExpirationTimeIn(long expirationTimeIn) {
        this.expirationTimeIn = expirationTimeIn;
        return this;
    }

    
}
