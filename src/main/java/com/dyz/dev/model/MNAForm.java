package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MNA_TBL_FORM")
public class MNAForm {
    @Id
    @Column(name = "TIME_NO")
    private String timeNo;

    @Column(name = "APPLY_USER")
    private String applyUser;

    @Column(name = "APPLY_DATE")
    private Date applyDate;

    @Column(name = "OWNER_UNIT")
    private String ownerUnit;

    @Column(name = "MATERIAL_TYPE")
    private String materialType;

    @Column(name = "MATERIAL_CATEGORY")
    private String materialCategory;

    @Column(name = "PLANNER")
    private String planner;

    @Column(name = "BUYER")
    private String buyer;

    @Column(name = "MATERIAL_DESCRIPTION")
    private String materialDescription;

    @Column(name = "SPECIFICATION")
    private String specification;

    @Column(name = "NTCC_OR_SMOC_NO")
    private String ntccOrSmocNo;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "VENDER_MATERIAL_NO")
    private String venderMaterialNo;

    @Column(name = "BASE_UNIT")
    private String baseUnit;

    @Column(name = "MACHINE_MODEL")
    private String machineModel;

    @Column(name = "CONSUMPTION_TYPE")
    private String consumptionType;

    @Column(name = "PURCHASING_TYPE")
    private String purchasingType;

    @Column(name = "INSPECTOR")
    private String inspector;

    @Column(name = "REQUIRE")
    private String require;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    @Column(name = "STANDARD_PRICE")
    private String standardPrice;

    @Column(name = "VENDOR_TYPE")
    private String vendorType;

    @Column(name = "FORM_NO")
    private String formNo;

    @Column(name = "PROCINSID")
    private String procinsid;

    @Column(name = "STATUS_NUM")
    private String statusNum;

    @Column(name = "NEXT_PROCESSOR")
    private String nextProcessor;

    @Column(name = "APPLY_EMPNO")
    private String applyEmpno;

    @Column(name = "APPLY_EMPNAME")
    private String applyEmpname;

    @Column(name = "APPLY_EMPPHONE")
    private String applyEmpphone;

    @Column(name = "MATERIAL_NO_TYPE")
    private String materialNoType;

    @Column(name = "MATERIAL_TYPE_NAME")
    private String materialTypeName;

    @Column(name = "PLANNER_NAME")
    private String plannerName;

    @Column(name = "BUYER_NAME")
    private String buyerName;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "NEW_VENDOR_CODE")
    private String newVendorCode;

    @Column(name = "MANUFACTURER_NAME")
    private String manufacturerName;

    @Column(name = "AGENT_NAME")
    private String agentName;

    @Column(name = "MANUFACTURER_ADDRESS")
    private String manufacturerAddress;

    @Column(name = "AGENT_ADDRESS")
    private String agentAddress;

    @Column(name = "MANUFACTURER_CONTACT")
    private String manufacturerContact;

    @Column(name = "AGENT_CONTACT")
    private String agentContact;

    @Column(name = "MANUFACTURER_TEL")
    private String manufacturerTel;

    @Column(name = "AGENT_TEL")
    private String agentTel;

    /**
     * @return TIME_NO
     */
    public String getTimeNo() {
        return timeNo;
    }

    /**
     * @param timeNo
     */
    public void setTimeNo(String timeNo) {
        this.timeNo = timeNo;
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
     * @return OWNER_UNIT
     */
    public String getOwnerUnit() {
        return ownerUnit;
    }

    /**
     * @param ownerUnit
     */
    public void setOwnerUnit(String ownerUnit) {
        this.ownerUnit = ownerUnit;
    }

    /**
     * @return MATERIAL_TYPE
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * @param materialType
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * @return MATERIAL_CATEGORY
     */
    public String getMaterialCategory() {
        return materialCategory;
    }

    /**
     * @param materialCategory
     */
    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }

    /**
     * @return PLANNER
     */
    public String getPlanner() {
        return planner;
    }

    /**
     * @param planner
     */
    public void setPlanner(String planner) {
        this.planner = planner;
    }

    /**
     * @return BUYER
     */
    public String getBuyer() {
        return buyer;
    }

    /**
     * @param buyer
     */
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    /**
     * @return MATERIAL_DESCRIPTION
     */
    public String getMaterialDescription() {
        return materialDescription;
    }

    /**
     * @param materialDescription
     */
    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    /**
     * @return SPECIFICATION
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return NTCC_OR_SMOC_NO
     */
    public String getNtccOrSmocNo() {
        return ntccOrSmocNo;
    }

    /**
     * @param ntccOrSmocNo
     */
    public void setNtccOrSmocNo(String ntccOrSmocNo) {
        this.ntccOrSmocNo = ntccOrSmocNo;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return VENDER_MATERIAL_NO
     */
    public String getVenderMaterialNo() {
        return venderMaterialNo;
    }

    /**
     * @param venderMaterialNo
     */
    public void setVenderMaterialNo(String venderMaterialNo) {
        this.venderMaterialNo = venderMaterialNo;
    }

    /**
     * @return BASE_UNIT
     */
    public String getBaseUnit() {
        return baseUnit;
    }

    /**
     * @param baseUnit
     */
    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    /**
     * @return MACHINE_MODEL
     */
    public String getMachineModel() {
        return machineModel;
    }

    /**
     * @param machineModel
     */
    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }

    /**
     * @return CONSUMPTION_TYPE
     */
    public String getConsumptionType() {
        return consumptionType;
    }

    /**
     * @param consumptionType
     */
    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }

    /**
     * @return PURCHASING_TYPE
     */
    public String getPurchasingType() {
        return purchasingType;
    }

    /**
     * @param purchasingType
     */
    public void setPurchasingType(String purchasingType) {
        this.purchasingType = purchasingType;
    }

    /**
     * @return INSPECTOR
     */
    public String getInspector() {
        return inspector;
    }

    /**
     * @param inspector
     */
    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    /**
     * @return REQUIRE
     */
    public String getRequire() {
        return require;
    }

    /**
     * @param require
     */
    public void setRequire(String require) {
        this.require = require;
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
     * @return DELIVERY_DATE
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return STANDARD_PRICE
     */
    public String getStandardPrice() {
        return standardPrice;
    }

    /**
     * @param standardPrice
     */
    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }

    /**
     * @return VENDOR_TYPE
     */
    public String getVendorType() {
        return vendorType;
    }

    /**
     * @param vendorType
     */
    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
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

    /**
     * @return APPLY_EMPNO
     */
    public String getApplyEmpno() {
        return applyEmpno;
    }

    /**
     * @param applyEmpno
     */
    public void setApplyEmpno(String applyEmpno) {
        this.applyEmpno = applyEmpno;
    }

    /**
     * @return APPLY_EMPNAME
     */
    public String getApplyEmpname() {
        return applyEmpname;
    }

    /**
     * @param applyEmpname
     */
    public void setApplyEmpname(String applyEmpname) {
        this.applyEmpname = applyEmpname;
    }

    /**
     * @return APPLY_EMPPHONE
     */
    public String getApplyEmpphone() {
        return applyEmpphone;
    }

    /**
     * @param applyEmpphone
     */
    public void setApplyEmpphone(String applyEmpphone) {
        this.applyEmpphone = applyEmpphone;
    }

    /**
     * @return MATERIAL_NO_TYPE
     */
    public String getMaterialNoType() {
        return materialNoType;
    }

    /**
     * @param materialNoType
     */
    public void setMaterialNoType(String materialNoType) {
        this.materialNoType = materialNoType;
    }

    /**
     * @return MATERIAL_TYPE_NAME
     */
    public String getMaterialTypeName() {
        return materialTypeName;
    }

    /**
     * @param materialTypeName
     */
    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    /**
     * @return PLANNER_NAME
     */
    public String getPlannerName() {
        return plannerName;
    }

    /**
     * @param plannerName
     */
    public void setPlannerName(String plannerName) {
        this.plannerName = plannerName;
    }

    /**
     * @return BUYER_NAME
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * @param buyerName
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * @return UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return NEW_VENDOR_CODE
     */
    public String getNewVendorCode() {
        return newVendorCode;
    }

    /**
     * @param newVendorCode
     */
    public void setNewVendorCode(String newVendorCode) {
        this.newVendorCode = newVendorCode;
    }

    /**
     * @return MANUFACTURER_NAME
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * @param manufacturerName
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * @return AGENT_NAME
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * @param agentName
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * @return MANUFACTURER_ADDRESS
     */
    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    /**
     * @param manufacturerAddress
     */
    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    /**
     * @return AGENT_ADDRESS
     */
    public String getAgentAddress() {
        return agentAddress;
    }

    /**
     * @param agentAddress
     */
    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    /**
     * @return MANUFACTURER_CONTACT
     */
    public String getManufacturerContact() {
        return manufacturerContact;
    }

    /**
     * @param manufacturerContact
     */
    public void setManufacturerContact(String manufacturerContact) {
        this.manufacturerContact = manufacturerContact;
    }

    /**
     * @return AGENT_CONTACT
     */
    public String getAgentContact() {
        return agentContact;
    }

    /**
     * @param agentContact
     */
    public void setAgentContact(String agentContact) {
        this.agentContact = agentContact;
    }

    /**
     * @return MANUFACTURER_TEL
     */
    public String getManufacturerTel() {
        return manufacturerTel;
    }

    /**
     * @param manufacturerTel
     */
    public void setManufacturerTel(String manufacturerTel) {
        this.manufacturerTel = manufacturerTel;
    }

    /**
     * @return AGENT_TEL
     */
    public String getAgentTel() {
        return agentTel;
    }

    /**
     * @param agentTel
     */
    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }
}