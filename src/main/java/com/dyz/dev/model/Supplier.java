package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "IMM_TBL_SUPPLIER")
public class Supplier {
    @Column(name = "MATERIAL_CLASSIFY")//材料分类
    private String materialClassify;

    @Column(name = "FORM_NO")
    @Id
    private String formNo;

    @Column(name = "NEW_MATERIAL_REMARK")//新物料备注
    private String newMaterialRemark;

    @Column(name = "APPLY_USER")
    private String applyUser;

    @Column(name = "APPLY_NO")
    private String applyNo;

    @Column(name = "APPLY_DATE")
    private Date applyDate;

    @Column(name = "APPLY_PHONE")
    private String applyPhone;

    @Column(name = "VENDOR_PURCHASE_USER")
    private String vendorPurchaseUser;

    @Column(name = "VENDOR_PURCHASE_PHONE")
    private String vendorPurchasePhone;

    @Column(name = "MATERIAL_NO")
    private String materialNo;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @Column(name = "QUAILIFIED_VENDOR")//合格供应商
    private String quailifiedVendor;

    @Column(name = "EVALUATION_REASON")//评价原因
    private String evaluationReason;

    @Column(name = "PROCESS_APPLICATION")//流程申请
    private String processApplication;

    @Column(name = "NOTIFY_FCCB")
    private String notifyFccb;

    @Column(name = "FCCB_NO")
    private String fccbNo;

    @Column(name = "DCN_NUMBER")
    private String dcnNumber;

    @Column(name = "PROCINSID")
    private String procinsid;

    @Column(name = "NEXT_PROCESSOR")
    private String nextProcessor;

    @Column(name = "STATUS_NUM")
    private String statusNum;
    
    @Column(name = "SITE")
    private String site;

    @Column(name = "EVALUATION_RANGE")
    private String evaluationRange;

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

    public String getApplyEmpDept() {
        return applyEmpDept;
    }

    public void setApplyEmpDept(String applyEmpDept) {
        this.applyEmpDept = applyEmpDept;
    }

    /**
     * 初始化方法
     */
    public void init() {

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
     * @return NEW_MATERIAL_REMARK
     */
    public String getNewMaterialRemark() {
        return newMaterialRemark;
    }

    /**
     * @param newMaterialRemark
     */
    public void setNewMaterialRemark(String newMaterialRemark) {
        this.newMaterialRemark = newMaterialRemark;
    }

    /**
     * @return APPLY_USER
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * @param applyUser
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    /**
     * @return APPLY_NO
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * @param applyNo
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
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
     * @return APPLY_PHONE
     */
    public String getApplyPhone() {
        return applyPhone;
    }

    /**
     * @param applyPhone
     */
    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    /**
     * @return VENDOR_PURCHASE_USER
     */
    public String getVendorPurchaseUser() {
        return vendorPurchaseUser;
    }

    /**
     * @param vendorPurchaseUser
     */
    public void setVendorPurchaseUser(String vendorPurchaseUser) {
        this.vendorPurchaseUser = vendorPurchaseUser;
    }

    /**
     * @return VENDOR_PURCHASE_PHONE
     */
    public String getVendorPurchasePhone() {
        return vendorPurchasePhone;
    }

    /**
     * @param vendorPurchasePhone
     */
    public void setVendorPurchasePhone(String vendorPurchasePhone) {
        this.vendorPurchasePhone = vendorPurchasePhone;
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
     * @return VENDOR_CODE
     */
    public String getVendorCode() {
        return vendorCode;
    }

    /**
     * @param vendorCode
     */
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    /**
     * @return QUAILIFIED_VENDOR
     */
    public String getQuailifiedVendor() {
        return quailifiedVendor;
    }

    /**
     * @param quailifiedVendor
     */
    public void setQuailifiedVendor(String quailifiedVendor) {
        this.quailifiedVendor = quailifiedVendor;
    }

    /**
     * @return EVALUATION_REASON
     */
    public String getEvaluationReason() {
        return evaluationReason;
    }

    /**
     * @param evaluationReason
     */
    public void setEvaluationReason(String evaluationReason) {
        this.evaluationReason = evaluationReason;
    }

    /**
     * @return PROCESS_APPLICATION
     */
    public String getProcessApplication() {
        return processApplication;
    }

    /**
     * @param processApplication
     */
    public void setProcessApplication(String processApplication) {
        this.processApplication = processApplication;
    }

    /**
     * @return NOTIFY_FCCB
     */
    public String getNotifyFccb() {
        return notifyFccb;
    }

    /**
     * @param notifyFccb
     */
    public void setNotifyFccb(String notifyFccb) {
        this.notifyFccb = notifyFccb;
    }

    /**
     * @return FCCB_NO
     */
    public String getFccbNo() {
        return fccbNo;
    }

    /**
     * @param fccbNo
     */
    public void setFccbNo(String fccbNo) {
        this.fccbNo = fccbNo;
    }

    /**
     * @return DCN_NUMBER
     */
    public String getDcnNumber() {
        return dcnNumber;
    }

    /**
     * @param dcnNumber
     */
    public void setDcnNumber(String dcnNumber) {
        this.dcnNumber = dcnNumber;
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
     * @return NEXT_PROCESSOR
     */
    public String getNextProcessor() {
        return nextProcessor;
    }

    /**
     * @param nextProcessor
     */
    public void setNextProcessor(String nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    /**
     * @return STATUS_NUM
     */
    public String getStatusNum() {
        return statusNum;
    }

    /**
     * @param statusNum
     */
    public void setStatusNum(String statusNum) {
        this.statusNum = statusNum;
    }

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

    public String getEvaluationRange() {
        return evaluationRange;
    }

    public void setEvaluationRange(String evaluationRange) {
        this.evaluationRange = evaluationRange;
    }
}