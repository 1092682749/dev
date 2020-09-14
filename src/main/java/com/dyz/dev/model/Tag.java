package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_TAG")
public class Tag {
    @Column(name = "TAG_NAME")
    private String tagName;

    @Column(name = "CREATE_EMPNO")
    private String createEmpno;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Id
    @Column(name = "T_ID")
    private String tId;

  @Column(name = "IS_DELETE")
  private String isDelete;

  @Column(name = "ROLE_NAME")
  private String roleName;

  public String getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(String isDelete) {
    this.isDelete = isDelete;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  /**
     * @return TAG_NAME
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return CREATE_EMPNO
     */
    public String getCreateEmpno() {
        return createEmpno;
    }

    /**
     * @param createEmpno
     */
    public void setCreateEmpno(String createEmpno) {
        this.createEmpno = createEmpno;
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

  public String gettId() {
    return tId;
  }

  public void settId(String tId) {
    this.tId = tId;
  }
}
