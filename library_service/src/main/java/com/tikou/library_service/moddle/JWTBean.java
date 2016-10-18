package com.tikou.library_service.moddle;

import java.io.Serializable;

/**
 * Created by hekr_jds on 2016/4/13.
 **/
public class JWTBean implements Serializable {

    private static final long serialVersionUID = -2125453657597278408L;
    /**
     * access_token : eyJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiIxNjE5Mzc1MTc0MiIsImlzb2xhdGlvbiI6IjAwMDAwMDAwMDAwIiwiZXhwIjoxNDYxMjEzODUzLCJ0eXBlIjoiV0VCIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjdlZTVhZGUyLTNkNmItNDU4MS05M2I2LWZlYTUyNjMzNzc0MiJ9.BrWcVY82dmgdY2yM5l-6yYMgHm-VEyE1T_hAhwvz7x2mGpMfWxKTVsvjPYqfAiO79yhakW_-HzvmmCtBCKeTnw
     * refresh_token : eyJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiIxNjE5Mzc1MTc0MiIsImF0aSI6IjdlZTVhZGUyLTNkNmItNDU4MS05M2I2LWZlYTUyNjMzNzc0MiIsImlzb2xhdGlvbiI6IjAwMDAwMDAwMDAwIiwiZXhwIjoxNDYxMjEzODUzLCJ0eXBlIjoiV0VCIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjNiOTVmMzkyLWVhMjQtNDIzZC1iMTlkLWZjMmQ2NDVmOGU4MiJ9.jI-6nNVpPTXIaguefTvW_boV5aq77Plobucukw72TNPd9PNHyQwuTl35Mvj9KS1irTOhbdUbj8yISobYQVBuiQ
     * token_type : bearer
     * expires_in : 86399
     * jti : 7ee5ade2-3d6b-4581-93b6-fea526337742
     */

    private String access_token;
    private String refresh_token;
    private String token_type;
    private long expires_in;
    private String jti;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public JWTBean(String access_token, String refresh_token, String token_type, long expires_in, String jti) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.jti = jti;
    }

    public JWTBean() {
    }

    @Override
    public String toString() {
        return "JWTBean{" +
                "access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                ", jti='" + jti + '\'' +
                '}';
    }
}
