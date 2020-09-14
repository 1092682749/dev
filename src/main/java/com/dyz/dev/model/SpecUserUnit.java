package com.dyz.dev.model;

import javax.persistence.*;

@Table(name = "IMM_TBL_SPEC_USER_UNIT")
public class SpecUserUnit implements UserUnitInterface{

    @Column(name = "ID")
    @Id
    private Double id;
   
    @Column(name = "FORM_NO")
    private String formNo;

    @Column(name = "PROCINSID")
    private String procinsid;

    @Column(name = "EMP_ACCOUNT")
    private String empAccount;

    @Column(name = "EMP_NO")
    private String empNo;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "APPROVE")
    private String approve;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "DEPT_DESCRSHORT")
    private String deptDescrShort;

    @Column(name = "TSMC_DOMAIN")
    private String tsmcDomain;

    @Column(name = "EMP_PHONE")
    private String empPhone;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    /**
     * @return FORM_NO
     */
    public String getFormNo() {
        return formNo;
    }

    /**
     * @param formNo
     */
    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    /**
     * @return PROCINSID
     */
    public String getProcinsid() {
        return procinsid;
    }

    /**
     * @param procinsid
     */
    public void setProcinsid(String procinsid) {
        this.procinsid = procinsid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptDescrShort() {
        return deptDescrShort;
    }

    public void setDeptDescrShort(String deptDescrShort) {
        this.deptDescrShort = deptDescrShort;
    }

    public String getTsmcDomain() {
        return tsmcDomain;
    }

    public void setTsmcDomain(String tsmcDomain) {
        this.tsmcDomain = tsmcDomain;
    }

    /**
     * @return EMP_ACCOUNT
     */
    public String getEmpAccount() {
        return empAccount;
    }

    /**
     * @param empAccount
     */
    public void setEmpAccount(String empAccount) {
        this.empAccount = empAccount;
    }

    /**
     * @return EMP_NO
     */
    public String getEmpNo() {
        return empNo;
    }

    /**
     * @param empNo
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
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
     * @return APPROVE
     */
    public String getApprove() {
        return approve;
    }

    /**
     * @param approve
     */
    public void setApprove(String approve) {
        this.approve = approve;
    }
}