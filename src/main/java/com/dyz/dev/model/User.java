package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer i ;

    private String username;

    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "addtime")
    private Date addtime;

    /**
     * @return id
     */
    public Integer getI () {
        return i ;
    }

    /**
     * @param i
     */
    public void setI (Integer i ) {
        this.i  = i ;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return password
     */
    public String getPassword () {
        return password ;
    }

    /**
     * @param passwor
     */
    public void setPassword (String passwor ) {
        this.password  = passwor ;
    }

    /**
     * @return addtime
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
