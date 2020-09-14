package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_LIKE")
public class CaseLike {
    @Column(name = "CASE_ID")
    private Integer caseId;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "ACTION_EMPNO")
    private String actionEmpno;

    @Column(name = "ACTION_TIME")
    private Date actionTime;

    @Id
    @Column(name = "ACTION_ID")
    private String actionId;

    // TARGET_TYPE
    @Column(name = "TARGET_TYPE")
    private String targetType;
  // COMMENT_ID
  @Column(name = "COMMENT_ID")
  private Integer commentId;


    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     * @return ACTION
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return ACTION_EMPNO
     */
    public String getActionEmpno() {
        return actionEmpno;
    }

    /**
     * @param actionEmpno
     */
    public void setActionEmpno(String actionEmpno) {
        this.actionEmpno = actionEmpno;
    }

    /**
     * @return ACTION_TIME
     */
    public Date getActionTime() {
        return actionTime;
    }

    /**
     * @param actionTime
     */
    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

  public String getActionId() {
    return actionId;
  }

  public void setActionId(String actionId) {
    this.actionId = actionId;
  }

  public String getTargetType() {
    return targetType;
  }

  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
