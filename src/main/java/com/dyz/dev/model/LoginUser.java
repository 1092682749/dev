package com.dyz.dev.model;

import java.util.List;

public class LoginUser {
  String account;
  String password;
  String token;
  String domain;
  String avatar;
  String empno;
  String roles;
  String permissions;
  public LoginUser() {

  }

  public LoginUser(String account, String password, String empno, String token, String domain) {
    this.account = account;
    this.password = password;
    this.token = token;
    this.domain = domain;
    this.empno = empno;
    this.avatar = "https://pf/pfPhoto/photo/" + empno + ".JPG";
  }

  public LoginUser(String account, String password, String empno, String token, String domain, String roles, String permissions) {
    this.account = account;
    this.password = password;
    this.token = token;
    this.domain = domain;
    this.empno = empno;
    this.avatar = "https://pf/pfPhoto/photo/" + empno + ".JPG";
    this.roles = roles;
    this.permissions = permissions;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getEmpno() {
    return empno;
  }

  public void setEmpno(String empno) {
    this.empno = empno;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  public String getPermissions() {
    return permissions;
  }

  public void setPermissions(String permissions) {
    this.permissions = permissions;
  }
}
