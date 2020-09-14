package com.dyz.dev.model;

import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_UNREAD")
public class UnreadMessage {
  @Column(name = "COMMENT_ID")
  private Integer commentId;

  @Id
  @Column(name = "UNREAD_ID")
  @GeneratedValue(generator = "JDBC")
  private String unreadId;

  @Column(name = "TO_EMPNO")
  private String toEmpno;

  @Column(name = "CASE_TITLE")
  private String caseTitle;

  @Column(name = "FROM_NAME")
  private String fromName;

  @Column(name = "CASE_ID")
  private Integer caseId;

  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  /**
   * @return UNREAD_ID
   */
  public String getUnreadId() {
    return unreadId;
  }

  /**
   * @param unreadId
   */
  public void setUnreadId(String unreadId) {
    this.unreadId = unreadId;
  }

  /**
   * @return TO_EMPNO
   */
  public String getToEmpno() {
    return toEmpno;
  }

  /**
   * @param toEmpno
   */
  public void setToEmpno(String toEmpno) {
    this.toEmpno = toEmpno;
  }

  /**
   * @return CASE_TITLE
   */
  public String getCaseTitle() {
    return caseTitle;
  }

  /**
   * @param caseTitle
   */
  public void setCaseTitle(String caseTitle) {
    this.caseTitle = caseTitle;
  }

  /**
   * @return FROM_NAME
   */
  public String getFromName() {
    return fromName;
  }

  /**
   * @param fromName
   */
  public void setFromName(String fromName) {
    this.fromName = fromName;
  }

  public Integer getCaseId() {
    return caseId;
  }

  public void setCaseId(Integer caseId) {
    this.caseId = caseId;
  }
}
