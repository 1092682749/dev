package com.dyz.dev.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "SOLVE_CENTER_TBL_COLLECT")
public class CaseCollect {
  @Id
  @Column(name = "COLLECT_ID")
  private String collectId;


  @Column(name = "CASE_ID")
  private Integer caseId;

  @Column(name = "EMPNO")
  private String empno;

  @Column(name = "COLLECT_TIME")
  private Date collectTime;

  public String getCollectId() {
    return collectId;
  }

  public void setCollectId(String collectId) {
    this.collectId = collectId;
  }

  public Integer getCaseId() {
    return caseId;
  }

  public void setCaseId(Integer caseId) {
    this.caseId = caseId;
  }

  /**
   * @return EMPNO
   */
  public String getEmpno() {
    return empno;
  }

  /**
   * @param empno
   */
  public void setEmpno(String empno) {
    this.empno = empno;
  }

  /**
   * @return COLLECT_TIME
   */
  public Date getCollectTime() {
    return collectTime;
  }

  /**
   * @param collectTime
   */
  public void setCollectTime(Date collectTime) {
    this.collectTime = collectTime;
  }
}
