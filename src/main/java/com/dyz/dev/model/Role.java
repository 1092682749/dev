package com.dyz.dev.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_ROLE")
public class Role {
  @Column(name = "ID")
  @Id
  private String id;

  @Column(name = "R_NAME")
  private String rName;

  @Column(name = "R_DESC")
  private String rDesc;

  @Column(name = "CREATE_TIME")
  private Date createTime;

  @Column(name = "UPDATE_TIME")
  private Date updateTime;

  @Column(name = "UPDAE_NT")
  private String updaeNt;

  @Column(name = "IS_DELETE")
  private String isDelete;

  private List<Permission> permissions;

  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
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
   * @return R_NAME
   */
  public String getrName() {
    return rName;
  }

  /**
   * @param rName
   */
  public void setrName(String rName) {
    this.rName = rName;
  }

  /**
   * @return R_DESC
   */
  public String getrDesc() {
    return rDesc;
  }

  /**
   * @param rDesc
   */
  public void setrDesc(String rDesc) {
    this.rDesc = rDesc;
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
