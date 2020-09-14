package com.dyz.dev.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "IMM_TBL_RMQC_FORM")
public class RMQCForm {
    @Column(name = "APPLY_USER")
    private String applyUser;

    @Column(name = "APPLY_EMP_NO")
    private String applyEmpNo;

    @Column(name = "APPLY_PHONE")
    private String applyPhone;

    @Column(name = "MATERIAL_CLASSIFY")
    private String materialClassify;

    @Column(name = "SUPPLIER")
    private String supplier;

    @Column(name = "MATERIAL_NO")
    private String materialNo;

    @Column(name = "LOT_NO")
    private String lotNo;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "WHO")
    private String who;

    @Column(name = "WHAT")
    private String what;

    @Column(name = "WHEN_EVER")
    private String whenEver;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "WHY")
    private String why;

    @Column(name = "HOW")
    private String how;

    @Column(name = "INTERIM_MEASURES")
    private String interimMeasures;

    @Column(name = "IMPACT")
    private String impact;

    @Column(name = "IMPACT_NUMBER")
    private String impactNumber;

    @Column(name = "RETAIN")
    private String retain;

    @Column(name = "CAUSE")
    private String cause;

    @Column(name = "FORM_NO")
    @Id
    private String formNo;

    @Column(name = "STATUS_NUM")
    private String statusNum;

    @Column(name = "NEXT_PROCESSOR")
    private String nextProcessor;

    @Column(name = "APPLY_NAME")
    private String applyName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "APPLY_DATE")
    private Date applyDate;


    @Column(name = "PROCINSID")
    private String procinsId;


    @Column(name = "CONSLUSION")
    private String conclusion;

    @Column(name = "HAS_DELETE")
    private String hasDelete;

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getProcinsId() {
        return procinsId;
    }

    public void setProcinsId(String procinsId) {
        this.procinsId = procinsId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
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
     * @return APPLY_EMP_NO
     */
    public String getApplyEmpNo() {
        return applyEmpNo;
    }

    /**
     * @param applyEmpNo
     */
    public void setApplyEmpNo(String applyEmpNo) {
        this.applyEmpNo = applyEmpNo;
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
     * @return SUPPLIER
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * @param supplier
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
     * @return LOT_NO
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * @param lotNo
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    /**
     * @return QUANTITY
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return WHO
     */
    public String getWho() {
        return who;
    }

    /**
     * @param who
     */
    public void setWho(String who) {
        this.who = who;
    }

    /**
     * @return WHAT
     */
    public String getWhat() {
        return what;
    }

    /**
     * @param what
     */
    public void setWhat(String what) {
        this.what = what;
    }

    /**
     * @return WHEN_EVER
     */
    public String getWhenEver() {
        return whenEver;
    }

    /**
     * @param whenEver
     */
    public void setWhenEver(String whenEver) {
        this.whenEver = whenEver;
    }

    /**
     * @return PLACE
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return WHY
     */
    public String getWhy() {
        return why;
    }

    /**
     * @param why
     */
    public void setWhy(String why) {
        this.why = why;
    }

    /**
     * @return HOW
     */
    public String getHow() {
        return how;
    }

    /**
     * @param how
     */
    public void setHow(String how) {
        this.how = how;
    }

    /**
     * @return INTERIM_MEASURES
     */
    public String getInterimMeasures() {
        return interimMeasures;
    }

    /**
     * @param interimMeasures
     */
    public void setInterimMeasures(String interimMeasures) {
        this.interimMeasures = interimMeasures;
    }

    /**
     * @return IMPACT
     */
    public String getImpact() {
        return impact;
    }

    /**
     * @param impact
     */
    public void setImpact(String impact) {
        this.impact = impact;
    }

    /**
     * @return IMPACT_NUMBER
     */
    public String getImpactNumber() {
        return impactNumber;
    }

    /**
     * @param impactNumber
     */
    public void setImpactNumber(String impactNumber) {
        this.impactNumber = impactNumber;
    }

    /**
     * @return RETAIN
     */
    public String getRetain() {
        return retain;
    }

    /**
     * @param retain
     */
    public void setRetain(String retain) {
        this.retain = retain;
    }

    /**
     * @return CAUSE
     */
    public String getCause() {
        return cause;
    }

    /**
     * @param cause
     */
    public void setCause(String cause) {
        this.cause = cause;
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

    public String getHasDelete() {
        return hasDelete;
    }

    public void setHasDelete(String hasDelete) {
        this.hasDelete = hasDelete;
    }
}