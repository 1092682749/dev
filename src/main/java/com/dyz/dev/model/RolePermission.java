package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_ROLE_PERMISSION")
public class RolePermission {
  @Column(name = "ID")
  @Id
  private String id;

  @Column(name = "R_ID")
  private String rId;

  @Column(name = "R_NAME")
  private String rName;

  @Column(name = "P_ID")
  private String pId;

  @Column(name = "CREATE_TIME")
  private Date createTime;

  @Column(name = "UPDATE_TIME")
  private Date updateTime;

  @Column(name = "UPDAE_NT")
  private String updaeNt;

  @Column(name = "IS_DELETE")
  private String isDelete;


  public String getrName() {
    return rName;
  }

  public void setrName(String rName) {
    this.rName = rName;
  }

  /**
   * @return ID
   */
  public String getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return R_ID
   */
  public String getrId() {
    return rId;
  }

  /**
   * @param rId
   */
  public void setrId(String rId) {
    this.rId = rId;
  }

  /**
   * @return P_ID
   */
  public String getpId() {
    return pId;
  }

  /**
   * @param pId
   */
  public void setpId(String pId) {
    this.pId = pId;
  }

  /**
   * @return CREATE_TIME
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * @param createTime
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * @return UPDATE_TIME
   */
  public Date getUpdateTime() {
    return updateTime;
  }

  /**
   * @param updateTime
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * @return UPDAE_NT
   */
  public String getUpdaeNt() {
    return updaeNt;
  }

  /**
   * @param updaeNt
   */
  public void setUpdaeNt(String updaeNt) {
    this.updaeNt = updaeNt;
  }

  /**
   * @return IS_DELETE
   */
  public String getIsDelete() {
    return isDelete;
  }

  /**
   * @param isDelete
   */
  public void setIsDelete(String isDelete) {
    this.isDelete = isDelete;
  }
}
