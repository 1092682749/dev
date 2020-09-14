package com.dyz.dev.model;

import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_ALLOW_IP")
public class AllowIp {
  @Id
  @Column(name = "IP")
  private String ip;

  @Column(name = "IS_ACCESS")
  private String isAccess;

  /**
   * @return IP
   */
  public String getIp() {
    return ip;
  }

  /**
   * @param ip
   */
  public void setIp(String ip) {
    this.ip = ip;
  }

  /**
   * @return IS_ACCESS
   */
  public String getIsAccess() {
    return isAccess;
  }

  /**
   * @param isAccess
   */
  public void setIsAccess(String isAccess) {
    this.isAccess = isAccess;
  }
}
