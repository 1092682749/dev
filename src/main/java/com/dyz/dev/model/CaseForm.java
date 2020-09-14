package com.dyz.dev.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;
import javax.validation.Constraint;

@Table(name = "SOLVE_CENTER_TBL_CASE_FORM")
public class CaseForm {

  @Id
  @GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
  private Integer caseId;

  @Column(name = "CREATE_EMPLID")
  private String createEmplid;



  @Column(name = "CREATE_EMPL")
  private String createEmpl;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "BRIEF")
  private String brief;

  @Column(name = "CATEGORY_ID")
  private String categoryId;

  @Column(name = "AUTHOR")
  private String author;

  @JSONField(format = "yyyy-MM-dd")
  @Column(name = "CREATE_DATE")
  private Date createDate;

  @Column(name = "STATUS")
  private String status;

  @Transient
  @Column(name = "UP_NUM")
  private String upNum;

  @Transient
  @Column(name = "DOWN_NUM")
  private String downNum;

  @Transient
  @Column(name = "TAGS")
  private String likeOrUnlike;


  @Transient
  @Column(name = "COMMENTS_NUM")
  private String commentsNum;

  @Column(name = "TAGS")
  private String tags;

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "MODULE_NAME")
  private String moduleName;

  @Column(name = "IS_DELETE")
  private String isDelete;

  @Column(name = "ADMIN_RATE")
  private String adminRate;


  public String getCreateEmplid() {
    return createEmplid;
  }

  public void setCreateEmplid(String createEmplid) {
    this.createEmplid = createEmplid;
  }

  public String getCreateEmpl() {
    return createEmpl;
  }

  public void setCreateEmpl(String createEmpl) {
    this.createEmpl = createEmpl;
  }


  public Integer getCaseId() {
    return caseId;
  }

  public void setCaseId(Integer caseId) {
    this.caseId = caseId;
  }

  /**
   * @return TILTE
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title
   *
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return BRIEF
   */
  public String getBrief() {
    return brief;
  }

  /**
   * @param brief
   */
  public void setBrief(String brief) {
    this.brief = brief;
  }

  /**
   * @return CATEGORY_ID
   */
  public String getCategoryId() {
    return categoryId;
  }

  /**
   * @param categoryId
   */
  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * @return AUTHOR
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return CREATE_DATE
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * @return STATUS
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return UP_NUM
   */
  public String getUpNum() {
    return upNum;
  }

  /**
   * @param upNum
   */
  public void setUpNum(String upNum) {
    this.upNum = upNum;
  }

  /**
   * @return DOWN_NUM
   */
  public String getDownNum() {
    return downNum;
  }

  /**
   * @param downNum
   */
  public void setDownNum(String downNum) {
    this.downNum = downNum;
  }

  /**
   * @return COMMENTS_NUM
   */
  public String getCommentsNum() {
    return commentsNum;
  }

  /**
   * @param commentsNum
   */
  public void setCommentsNum(String commentsNum) {
    this.commentsNum = commentsNum;
  }

  /**
   * @return TAGS
   */
  public String getTags() {
    return tags;
  }

  /**
   * @param tags
   */
  public void setTags(String tags) {
    this.tags = tags;
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


  public String getLikeOrUnlike() {
    return likeOrUnlike;
  }

  public void setLikeOrUnlike(String likeOrUnlike) {
    this.likeOrUnlike = likeOrUnlike;
  }

  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public String getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(String isDelete) {
    this.isDelete = isDelete;
  }


  public String getAdminRate() {
    return adminRate;
  }

  public void setAdminRate(String adminRate) {
    this.adminRate = adminRate;
  }
}
