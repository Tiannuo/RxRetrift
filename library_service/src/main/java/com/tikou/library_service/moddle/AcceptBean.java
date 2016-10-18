package com.tikou.library_service.moddle;

/**
 * Created by Tikou on 2016/10/18.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */

public class AcceptBean {
    public AcceptBean(String pid, String email, String password) {
        this.pid = pid;
        this.email = email;
        this.password = password;
    }

    /**
     * pid : 01xxxxxxxxx
     * email : xxxx@hekr.me
     * password : xxxxxxxx
     */

    private String pid;
    private String email;
    private String password;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "pid='" + pid + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
