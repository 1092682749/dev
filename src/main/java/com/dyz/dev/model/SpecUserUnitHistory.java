package com.dyz.dev.model;

import javax.persistence.*;

@Table(name = "IMM_TBL_SPEC_USER_UNIT_HISTORY")
public class SpecUserUnitHistory implements UserUnitInterface {
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

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "DEPT_DESCRSHORT")
    private String deptDescrshort;

    @Column(name = "TSMC_DOMAIN")
    private String tsmcDomain;

    @Column(name = "EMP_PHONE")
    private String empPhone;

    @Column(name = "SIGN_TIMES")
    private Short signTimes;

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

    /**
     * @return ID
     */
    public Short getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * @return EMP_NAME
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return DEPT_DESCRSHORT
     */
    public String getDeptDescrshort() {
        return deptDescrshort;
    }

    /**
     * @param deptDescrshort
     */
    public void setDeptDescrshort(String deptDescrshort) {
        this.deptDescrshort = deptDescrshort;
    }

    /**
     * @return TSMC_DOMAIN
     */
    public String getTsmcDomain() {
        return tsmcDomain;
    }

    /**
     * @param tsmcDomain
     */
    public void setTsmcDomain(String tsmcDomain) {
        this.tsmcDomain = tsmcDomain;
    }

    /**
     * @return EMP_PHONE
     */
    public String getEmpPhone() {
        return empPhone;
    }

    /**
     * @param empPhone
     */
    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    /**
     * @return SIGN_TIMES
     */
    public Short getSignTimes() {
        return signTimes;
    }

    /**
     * @param signTimes
     */
    public void setSignTimes(Short signTimes) {
        this.signTimes = signTimes;
    }
}