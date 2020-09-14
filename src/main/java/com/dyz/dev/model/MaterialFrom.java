package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MATERIAL_TBL_FROM")
public class MaterialFrom {
    @Column(name = "MTF_ID")
    @Id
    private String mtfId;

    @Column(name = "FORM_NO")
    private String formNo;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "APPLICATION_USER")
    private String applicationUser;

    @Column(name = "APPLICATION_USER_PHONE")
    private String applicationUserPhone;

    @Column(name = "APPLICATION_TIME")
    private Date applicationTime;

    @Column(name = "VENDOR_PURCHASE_USER")
    private String vendorPurchaseUser;

    @Column(name = "VENDOR_PURCHASE_PHONE")
    private String vendorPurchasePhone;

    @Column(name = "FAB")
    private String fab;

    @Column(name = "MATERIAL_REMARK")
    private String materialRemark;

    @Column(name = "MATERIAL_NO")
    private String materialNo;

    @Column(name = "STATUS")
    private Short status;

    @Column(name = "EVALUATION_RANGE")
    private Short evaluationRange;

    @Column(name = "EVALUATION_REASON")
    private String evaluationReason;

    @Column(name = "NEED_NOTIFY")
    private String needNotify;

    @Column(name = "PROCESS_APPLICATION")
    private String processApplication;

    @Column(name = "PRODUCT_FORMAT")
    private String productFormat;

    @Column(name = "QUALITY_SYSTEM")
    private String qualitySystem;

    @Column(name = "PURCHASE_VOUCHER")
    private String purchaseVoucher;

    @Column(name = "SAFETY_TABLE")
    private String safetyTable;

    @Column(name = "NEXT_PROCESSOR")
    private String nextProcessor;

    @Column(name = "NEXT_NODE_NUM")
    private Short nextNodeNum;

    @Column(name = "MATERIAL_CATEGORY")
    private Short materialCategory;

    /**
     * @return MTF_ID
     */
    public String getMtfId() {
        return mtfId;
    }

    /**
     * @param mtfId
     */
    public void setMtfId(String mtfId) {
        this.mtfId = mtfId;
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
     * @return CREATE_USER
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    /**
     * @return APPLICATION_USER
     */
    public String getApplicationUser() {
        return applicationUser;
    }

    /**
     * @param applicationUser
     */
    public void setApplicationUser(String applicationUser) {
        this.applicationUser = applicationUser;
    }

    /**
     * @return APPLICATION_USER_PHONE
     */
    public String getApplicationUserPhone() {
        return applicationUserPhone;
    }

    /**
     * @param applicationUserPhone
     */
    public void setApplicationUserPhone(String applicationUserPhone) {
        this.applicationUserPhone = applicationUserPhone;
    }

    /**
     * @return APPLICATION_TIME
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * @param applicationTime
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
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
     * @return FAB
     */
    public String getFab() {
        return fab;
    }

    /**
     * @param fab
     */
    public void setFab(String fab) {
        this.fab = fab;
    }

    /**
     * @return MATERIAL_REMARK
     */
    public String getMaterialRemark() {
        return materialRemark;
    }

    /**
     * @param materialRemark
     */
    public void setMaterialRemark(String materialRemark) {
        this.materialRemark = materialRemark;
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
     * @return STATUS
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return EVALUATION_RANGE
     */
    public Short getEvaluationRange() {
        return evaluationRange;
    }

    /**
     * @param evaluationRange
     */
    public void setEvaluationRange(Short evaluationRange) {
        this.evaluationRange = evaluationRange;
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
     * @return NEED_NOTIFY
     */
    public String getNeedNotify() {
        return needNotify;
    }

    /**
     * @param needNotify
     */
    public void setNeedNotify(String needNotify) {
        this.needNotify = needNotify;
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
     * @return PRODUCT_FORMAT
     */
    public String getProductFormat() {
        return productFormat;
    }

    /**
     * @param productFormat
     */
    public void setProductFormat(String productFormat) {
        this.productFormat = productFormat;
    }

    /**
     * @return QUALITY_SYSTEM
     */
    public String getQualitySystem() {
        return qualitySystem;
    }

    /**
     * @param qualitySystem
     */
    public void setQualitySystem(String qualitySystem) {
        this.qualitySystem = qualitySystem;
    }

    /**
     * @return PURCHASE_VOUCHER
     */
    public String getPurchaseVoucher() {
        return purchaseVoucher;
    }

    /**
     * @param purchaseVoucher
     */
    public void setPurchaseVoucher(String purchaseVoucher) {
        this.purchaseVoucher = purchaseVoucher;
    }

    /**
     * @return SAFETY_TABLE
     */
    public String getSafetyTable() {
        return safetyTable;
    }

    /**
     * @param safetyTable
     */
    public void setSafetyTable(String safetyTable) {
        this.safetyTable = safetyTable;
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
     * @return NEXT_NODE_NUM
     */
    public Short getNextNodeNum() {
        return nextNodeNum;
    }

    /**
     * @param nextNodeNum
     */
    public void setNextNodeNum(Short nextNodeNum) {
        this.nextNodeNum = nextNodeNum;
    }

    /**
     * @return MATERIAL_CATEGORY
     */
    public Short getMaterialCategory() {
        return materialCategory;
    }

    /**
     * @param materialCategory
     */
    public void setMaterialCategory(Short materialCategory) {
        this.materialCategory = materialCategory;
    }
}