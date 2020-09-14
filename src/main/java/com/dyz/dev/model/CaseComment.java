package com.dyz.dev.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_COMMENT")
public class CaseComment {

  @Column(name = "COMMENT_ID")
  @Id
  @GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
  private Integer commentId;

  public Integer getCommentId() {
    return commentId;
  }

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "CASE_ID")
  private Integer caseId;

  @Column(name = "COMMENT_TIME")
  private Date commentTime;

  @Column(name = "COMMENT_EMPNO")
  private String commentEmpno;
  //
  @Column(name = "COMMENT_LEVEL")
  private String commentLevel;
  // VARCHAR2(255) PARENT_ID
  @Column(name = "PARENT_ID")
  private String parentId;

  @Column(name = "TO_EMPNO")
  private String toEmpno;

  @Transient
  private String upNum;
  @Transient
  private String downNum;

  @Transient
  private String likeOrUnlike;
  @Transient
  String actionEmpno;

  @Transient
  List<CaseComment> children;

  @Column(name = "IS_DELETE")
  private String isDelete;

  @Column(name = "ACCEPT")
  private String accept;

  // ADMIN_RATE
  @Column(name = "ADMIN_RATE")
  private String adminRate;

  @Column(name = "TO_EMPNAME")
  private String toEmpName;

  @Column(name = "COMMENT_EMPNAME")
  private String commentEmpName;



  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  /**
   * @return CONTENT
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content
   */
  public void setContent(String content) {
    this.content = content;
  }


  public Integer getCaseId() {
    return caseId;
  }

  public void setCaseId(Integer caseId) {
    this.caseId = caseId;
  }

  /**
   * @return COMMENT_TIME
   */
  public Date getCommentTime() {
    return commentTime;
  }

  /**
   * @param commentTime
   */
  public void setCommentTime(Date commentTime) {
    this.commentTime = commentTime;
  }

  /**
   * @return COMMENT_EMPNO
   */
  public String getCommentEmpno() {
    return commentEmpno;
  }

  /**
   * @param commentEmpno
   */
  public void setCommentEmpno(String commentEmpno) {
    this.commentEmpno = commentEmpno;
  }


  public String getCommentLevel() {
    return commentLevel;
  }

  public void setCommentLevel(String commentLevel) {
    this.commentLevel = commentLevel;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getToEmpno() {
    return toEmpno;
  }

  public void setToEmpno(String toEmpno) {
    this.toEmpno = toEmpno;
  }

  public List<CaseComment> getChildren() {
    return children;
  }

  public void setChildren(List<CaseComment> children) {
    this.children = children;
  }

  public String getUpNum() {
    return upNum;
  }

  public void setUpNum(String upNum) {
    this.upNum = upNum;
  }

  public String getDownNum() {
    return downNum;
  }

  public void setDownNum(String downNum) {
    this.downNum = downNum;
  }

  public String getLikeOrUnlike() {
    return likeOrUnlike;
  }

  public void setLikeOrUnlike(String likeOrUnlike) {
    this.likeOrUnlike = likeOrUnlike;
  }

  public String getActionEmpno() {
    return actionEmpno;
  }

  public void setActionEmpno(String actionEmpno) {
    this.actionEmpno = actionEmpno;
  }

  public String getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(String isDelete) {
    this.isDelete = isDelete;
  }

  public String getAccept() {
    return accept;
  }

  public void setAccept(String accept) {
    this.accept = accept;
  }

  public String getAdminRate() {
    return adminRate;
  }

  public void setAdminRate(String adminRate) {
    this.adminRate = adminRate;
  }

  public String getToEmpName() {
    return toEmpName;
  }

  public void setToEmpName(String toEmpName) {
    this.toEmpName = toEmpName;
  }

  public String getCommentEmpName() {
    return commentEmpName;
  }

  public void setCommentEmpName(String commentEmpName) {
    this.commentEmpName = commentEmpName;
  }
}
