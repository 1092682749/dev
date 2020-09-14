package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "IMM_TBL_SPEC_CHANGE_FORM")
public class SpecChangeForm {
    @Column(name = "MATERIAL_NO")
    private String materialNo;

    @Column(name = "APPLY_DATE")
    private Date applyDate;

    @Column(name = "MATERIAL_CLASSIFY")
    private String materialClassify;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "COMPLAIN_NUMBER")
    private String complainNumber;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "PROXY")
    private String proxy;

    @Column(name = "CHANGE_NOTES")
    private String changeNotes;

    @Column(name = "IMPORTANCE")
    private String importance;

    @Column(name = "SPECIFICATION_NUMBER")
    private String specificationNumber;

    @Column(name = "SEND_DATE")
    private Date sendDate;

    @Column(name = "TSMC_EXPLAIN")
    private String tsmcExplain;

    @Column(name = "START_FROM_THIS")
    private String startFromThis;

    @Column(name = "SUGGEST")
    private String suggest;

    @Column(name = "CHANGE_DATE")
    private Date changeDate;

    @Column(name = "FORM_NO")
    @Id
    private String formNo;

    @Column(name = "NEXT_PROCESS")
    private String nextProcess;

    @Column(name = "STATUS_NUM")
    private String statusNum;

    @Column(name = "PROCINSID")
    private String procinsId;

    @Column(name = "APPLY_USER")
    private String applyUser;

    // <result column="APPLY_EMP_NO" jdbcType="VARCHAR" property="applyEmpNo" />
    //    <result column="APPLY_EMP_DEPT" jdbcType="VARCHAR" property="applyEmpDept" />

    @Column(name = "APPLY_EMP_NO")
    private String applyEmpNo;

    @Column(name = "APPLY_EMP_DEPT")
    private String applyEmpDept;

    @Column(name = "HAS_DELETE")
    private String hasDelete;

    public String getHasDelete() {
        return hasDelete;
    }

    public void setHasDelete(String hasDelete) {
        this.hasDelete = hasDelete;
    }

    public String getApplyEmpNo() {
        return applyEmpNo;
    }
    public void setApplyEmpNo(String applyEmpNo) {
        this.applyEmpNo = applyEmpNo;
    }
    public String getApplyEmpDept() {
        return applyEmpDept;
    }
    public void setApplyEmpDept(String applyEmpDept) {
        this.applyEmpDept = applyEmpDept;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getNextProcess() {
        return nextProcess;
    }

    public void setNextProcess(String nextProcess) {
        this.nextProcess = nextProcess;
    }

    public String getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(String statusNum) {
        this.statusNum = statusNum;
    }

    public String getProcinsId() {
        return procinsId;
    }

    public void setProcinsId(String procinsId) {
        this.procinsId = procinsId;
    }

    /**
     * @return MATERIAL_NO
     */
    public String getMaterialNo() {
        return materialNo;
    }

    /**
     * @param materialNo
     */
    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    /**
     * @return APPLY_DATE
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * @return MATERIAL_CLASSIFY
     */
    public String getMaterialClassify() {
        return materialClassify;
    }

    /**
     * @param materialClassify
     */
    public void setMaterialClassify(String materialClassify) {
        this.materialClassify = materialClassify;
    }

    /**
     * @return PRODUCT_NAME
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return COMPLAIN_NUMBER
     */
    public String getComplainNumber() {
        return complainNumber;
    }

    /**
     * @param complainNumber
     */
    public void setComplainNumber(String complainNumber) {
        this.complainNumber = complainNumber;
    }

    /**
     * @return VENDOR
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * @return PROXY
     */
    public String getProxy() {
        return proxy;
    }

    /**
     * @param proxy
     */
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    /**
     * @return CHANGE_NOTES
     */
    public String getChangeNotes() {
        return changeNotes;
    }

    /**
     * @param changeNotes
     */
    public void setChangeNotes(String changeNotes) {
        this.changeNotes = changeNotes;
    }

    /**
     * @return IMPORTANCE
     */
    public String getImportance() {
        return importance;
    }

    /**
     * @param importance
     */
    public void setImportance(String importance) {
        this.importance = importance;
    }

    /**
     * @return SPECIFICATION_NUMBER
     */
    public String getSpecificationNumber() {
        return specificationNumber;
    }

    /**
     * @param specificationNumber
     */
    public void setSpecificationNumber(String specificationNumber) {
        this.specificationNumber = specificationNumber;
    }

    /**
     * @return SEND_DATE
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * @param sendDate
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * @return TSMC_EXPLAIN
     */
    public String getTsmcExplain() {
        return tsmcExplain;
    }

    /**
     * @param tsmcExplain
     */
    public void setTsmcExplain(String tsmcExplain) {
        this.tsmcExplain = tsmcExplain;
    }

    /**
     * @return START_FROM_THIS
     */
    public String getStartFromThis() {
        return startFromThis;
    }

    /**
     * @param startFromThis
     */
    public void setStartFromThis(String startFromThis) {
        this.startFromThis = startFromThis;
    }

    /**
     * @return SUGGEST
     */
    public String getSuggest() {
        return suggest;
    }

    /**
     * @param suggest
     */
    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    /**
     * @return CHANGE_DATE
     */
    public Date getChangeDate() {
        return changeDate;
    }

    /**
     * @param changeDate
     */
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}