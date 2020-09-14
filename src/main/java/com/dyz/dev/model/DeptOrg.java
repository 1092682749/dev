package com.dyz.dev.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHR_T_DEPT_ORG")
public class DeptOrg {
  @Id
    @Column(name = "DEPTID")
    private String deptid;

    @Column(name = "TREE_LEVEL_NUM")
    private BigDecimal treeLevelNum;

    @Column(name = "TREE_LEVEL")
    private String treeLevel;

    @Column(name = "TW_REPORT_DEPTID")
    private String twReportDeptid;

    @Column(name = "TW_CMOFFICE")
    private String twCmoffice;

    @Column(name = "TW_GM")
    private String twGm;

    @Column(name = "TW_AREA")
    private String twArea;

    @Column(name = "TW_FUNCSITE")
    private String twFuncsite;

    @Column(name = "TW_DIV")
    private String twDiv;

    @Column(name = "TW_DEPT")
    private String twDept;

    @Column(name = "TW_SECT")
    private String twSect;

    @Column(name = "MANAGER_ID")
    private String managerId;

    @Column(name = "TW_SITE_CODE")
    private String twSiteCode;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "DEPT_DESCRSHORT")
    private String deptDescrshort;

    @Column(name = "DEPT_DESCR")
    private String deptDescr;

    @Column(name = "DEPT_CHINESE")
    private String deptChinese;

    @Column(name = "DIV_DESCRSHORT")
    private String divDescrshort;

    @Column(name = "DIV_DESCR")
    private String divDescr;

    @Column(name = "DIV_CHINESE")
    private String divChinese;

    @Column(name = "AREA_DESCRSHORT")
    private String areaDescrshort;

    @Column(name = "AREA_DESCR")
    private String areaDescr;

    @Column(name = "AREA_CHINESE")
    private String areaChinese;

    @Column(name = "FUNC_DESCRSHORT")
    private String funcDescrshort;

    @Column(name = "FUNC_DESCR")
    private String funcDescr;

    @Column(name = "FUNC_CHINESE")
    private String funcChinese;

    @Column(name = "TW_DEPT_DESCRSHORT")
    private String twDeptDescrshort;

    @Column(name = "TW_DEPT_DESCR")
    private String twDeptDescr;

    @Column(name = "TW_DEPT_CHINESE")
    private String twDeptChinese;

    @Column(name = "LOCATION_DESCR")
    private String locationDescr;

    @Column(name = "TW_CMOFFICE1")
    private String twCmoffice1;

    @Column(name = "TW_GM1")
    private String twGm1;

    @Column(name = "TW_AREA1")
    private String twArea1;

    @Column(name = "TW_FUNCSITE1")
    private String twFuncsite1;

    @Column(name = "TW_DIV1")
    private String twDiv1;

    @Column(name = "TW_DEPT1")
    private String twDept1;

    @Column(name = "TW_SECT1")
    private String twSect1;

    @Column(name = "TW_DIV1_SHORT")
    private String twDiv1Short;

    @Column(name = "TW_DIV1_DESCR")
    private String twDiv1Descr;

    @Column(name = "TW_DIV1_CHIN")
    private String twDiv1Chin;

    @Column(name = "TW_AREA1_SHORT")
    private String twArea1Short;

    @Column(name = "TW_AREA1_DESCR")
    private String twArea1Descr;

    @Column(name = "TW_AREA1_CHIN")
    private String twArea1Chin;

    @Column(name = "TW_FUNCSITE1_SHORT")
    private String twFuncsite1Short;

    @Column(name = "TW_FUNCSITE1_DESCR")
    private String twFuncsite1Descr;

    @Column(name = "TW_FUNCSITE1_CHIN")
    private String twFuncsite1Chin;

    @Column(name = "TW_DEPT1_SHORT")
    private String twDept1Short;

    @Column(name = "TW_DEPT1_DESCR")
    private String twDept1Descr;

    @Column(name = "TW_DEPT1_CHIN")
    private String twDept1Chin;

    /**
     * @return DEPTID
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     * @param deptid
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    /**
     * @return TREE_LEVEL_NUM
     */
    public BigDecimal getTreeLevelNum() {
        return treeLevelNum;
    }

    /**
     * @param treeLevelNum
     */
    public void setTreeLevelNum(BigDecimal treeLevelNum) {
        this.treeLevelNum = treeLevelNum;
    }

    /**
     * @return TREE_LEVEL
     */
    public String getTreeLevel() {
        return treeLevel;
    }

    /**
     * @param treeLevel
     */
    public void setTreeLevel(String treeLevel) {
        this.treeLevel = treeLevel;
    }

    /**
     * @return TW_REPORT_DEPTID
     */
    public String getTwReportDeptid() {
        return twReportDeptid;
    }

    /**
     * @param twReportDeptid
     */
    public void setTwReportDeptid(String twReportDeptid) {
        this.twReportDeptid = twReportDeptid;
    }

    /**
     * @return TW_CMOFFICE
     */
    public String getTwCmoffice() {
        return twCmoffice;
    }

    /**
     * @param twCmoffice
     */
    public void setTwCmoffice(String twCmoffice) {
        this.twCmoffice = twCmoffice;
    }

    /**
     * @return TW_GM
     */
    public String getTwGm() {
        return twGm;
    }

    /**
     * @param twGm
     */
    public void setTwGm(String twGm) {
        this.twGm = twGm;
    }

    /**
     * @return TW_AREA
     */
    public String getTwArea() {
        return twArea;
    }

    /**
     * @param twArea
     */
    public void setTwArea(String twArea) {
        this.twArea = twArea;
    }

    /**
     * @return TW_FUNCSITE
     */
    public String getTwFuncsite() {
        return twFuncsite;
    }

    /**
     * @param twFuncsite
     */
    public void setTwFuncsite(String twFuncsite) {
        this.twFuncsite = twFuncsite;
    }

    /**
     * @return TW_DIV
     */
    public String getTwDiv() {
        return twDiv;
    }

    /**
     * @param twDiv
     */
    public void setTwDiv(String twDiv) {
        this.twDiv = twDiv;
    }

    /**
     * @return TW_DEPT
     */
    public String getTwDept() {
        return twDept;
    }

    /**
     * @param twDept
     */
    public void setTwDept(String twDept) {
        this.twDept = twDept;
    }

    /**
     * @return TW_SECT
     */
    public String getTwSect() {
        return twSect;
    }

    /**
     * @param twSect
     */
    public void setTwSect(String twSect) {
        this.twSect = twSect;
    }

    /**
     * @return MANAGER_ID
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    /**
     * @return TW_SITE_CODE
     */
    public String getTwSiteCode() {
        return twSiteCode;
    }

    /**
     * @param twSiteCode
     */
    public void setTwSiteCode(String twSiteCode) {
        this.twSiteCode = twSiteCode;
    }

    /**
     * @return LOCATION
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
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
     * @return DEPT_DESCR
     */
    public String getDeptDescr() {
        return deptDescr;
    }

    /**
     * @param deptDescr
     */
    public void setDeptDescr(String deptDescr) {
        this.deptDescr = deptDescr;
    }

    /**
     * @return DEPT_CHINESE
     */
    public String getDeptChinese() {
        return deptChinese;
    }

    /**
     * @param deptChinese
     */
    public void setDeptChinese(String deptChinese) {
        this.deptChinese = deptChinese;
    }

    /**
     * @return DIV_DESCRSHORT
     */
    public String getDivDescrshort() {
        return divDescrshort;
    }

    /**
     * @param divDescrshort
     */
    public void setDivDescrshort(String divDescrshort) {
        this.divDescrshort = divDescrshort;
    }

    /**
     * @return DIV_DESCR
     */
    public String getDivDescr() {
        return divDescr;
    }

    /**
     * @param divDescr
     */
    public void setDivDescr(String divDescr) {
        this.divDescr = divDescr;
    }

    /**
     * @return DIV_CHINESE
     */
    public String getDivChinese() {
        return divChinese;
    }

    /**
     * @param divChinese
     */
    public void setDivChinese(String divChinese) {
        this.divChinese = divChinese;
    }

    /**
     * @return AREA_DESCRSHORT
     */
    public String getAreaDescrshort() {
        return areaDescrshort;
    }

    /**
     * @param areaDescrshort
     */
    public void setAreaDescrshort(String areaDescrshort) {
        this.areaDescrshort = areaDescrshort;
    }

    /**
     * @return AREA_DESCR
     */
    public String getAreaDescr() {
        return areaDescr;
    }

    /**
     * @param areaDescr
     */
    public void setAreaDescr(String areaDescr) {
        this.areaDescr = areaDescr;
    }

    /**
     * @return AREA_CHINESE
     */
    public String getAreaChinese() {
        return areaChinese;
    }

    /**
     * @param areaChinese
     */
    public void setAreaChinese(String areaChinese) {
        this.areaChinese = areaChinese;
    }

    /**
     * @return FUNC_DESCRSHORT
     */
    public String getFuncDescrshort() {
        return funcDescrshort;
    }

    /**
     * @param funcDescrshort
     */
    public void setFuncDescrshort(String funcDescrshort) {
        this.funcDescrshort = funcDescrshort;
    }

    /**
     * @return FUNC_DESCR
     */
    public String getFuncDescr() {
        return funcDescr;
    }

    /**
     * @param funcDescr
     */
    public void setFuncDescr(String funcDescr) {
        this.funcDescr = funcDescr;
    }

    /**
     * @return FUNC_CHINESE
     */
    public String getFuncChinese() {
        return funcChinese;
    }

    /**
     * @param funcChinese
     */
    public void setFuncChinese(String funcChinese) {
        this.funcChinese = funcChinese;
    }

    /**
     * @return TW_DEPT_DESCRSHORT
     */
    public String getTwDeptDescrshort() {
        return twDeptDescrshort;
    }

    /**
     * @param twDeptDescrshort
     */
    public void setTwDeptDescrshort(String twDeptDescrshort) {
        this.twDeptDescrshort = twDeptDescrshort;
    }

    /**
     * @return TW_DEPT_DESCR
     */
    public String getTwDeptDescr() {
        return twDeptDescr;
    }

    /**
     * @param twDeptDescr
     */
    public void setTwDeptDescr(String twDeptDescr) {
        this.twDeptDescr = twDeptDescr;
    }

    /**
     * @return TW_DEPT_CHINESE
     */
    public String getTwDeptChinese() {
        return twDeptChinese;
    }

    /**
     * @param twDeptChinese
     */
    public void setTwDeptChinese(String twDeptChinese) {
        this.twDeptChinese = twDeptChinese;
    }

    /**
     * @return LOCATION_DESCR
     */
    public String getLocationDescr() {
        return locationDescr;
    }

    /**
     * @param locationDescr
     */
    public void setLocationDescr(String locationDescr) {
        this.locationDescr = locationDescr;
    }

    /**
     * @return TW_CMOFFICE1
     */
    public String getTwCmoffice1() {
        return twCmoffice1;
    }

    /**
     * @param twCmoffice1
     */
    public void setTwCmoffice1(String twCmoffice1) {
        this.twCmoffice1 = twCmoffice1;
    }

    /**
     * @return TW_GM1
     */
    public String getTwGm1() {
        return twGm1;
    }

    /**
     * @param twGm1
     */
    public void setTwGm1(String twGm1) {
        this.twGm1 = twGm1;
    }

    /**
     * @return TW_AREA1
     */
    public String getTwArea1() {
        return twArea1;
    }

    /**
     * @param twArea1
     */
    public void setTwArea1(String twArea1) {
        this.twArea1 = twArea1;
    }

    /**
     * @return TW_FUNCSITE1
     */
    public String getTwFuncsite1() {
        return twFuncsite1;
    }

    /**
     * @param twFuncsite1
     */
    public void setTwFuncsite1(String twFuncsite1) {
        this.twFuncsite1 = twFuncsite1;
    }

    /**
     * @return TW_DIV1
     */
    public String getTwDiv1() {
        return twDiv1;
    }

    /**
     * @param twDiv1
     */
    public void setTwDiv1(String twDiv1) {
        this.twDiv1 = twDiv1;
    }

    /**
     * @return TW_DEPT1
     */
    public String getTwDept1() {
        return twDept1;
    }

    /**
     * @param twDept1
     */
    public void setTwDept1(String twDept1) {
        this.twDept1 = twDept1;
    }

    /**
     * @return TW_SECT1
     */
    public String getTwSect1() {
        return twSect1;
    }

    /**
     * @param twSect1
     */
    public void setTwSect1(String twSect1) {
        this.twSect1 = twSect1;
    }

    /**
     * @return TW_DIV1_SHORT
     */
    public String getTwDiv1Short() {
        return twDiv1Short;
    }

    /**
     * @param twDiv1Short
     */
    public void setTwDiv1Short(String twDiv1Short) {
        this.twDiv1Short = twDiv1Short;
    }

    /**
     * @return TW_DIV1_DESCR
     */
    public String getTwDiv1Descr() {
        return twDiv1Descr;
    }

    /**
     * @param twDiv1Descr
     */
    public void setTwDiv1Descr(String twDiv1Descr) {
        this.twDiv1Descr = twDiv1Descr;
    }

    /**
     * @return TW_DIV1_CHIN
     */
    public String getTwDiv1Chin() {
        return twDiv1Chin;
    }

    /**
     * @param twDiv1Chin
     */
    public void setTwDiv1Chin(String twDiv1Chin) {
        this.twDiv1Chin = twDiv1Chin;
    }

    /**
     * @return TW_AREA1_SHORT
     */
    public String getTwArea1Short() {
        return twArea1Short;
    }

    /**
     * @param twArea1Short
     */
    public void setTwArea1Short(String twArea1Short) {
        this.twArea1Short = twArea1Short;
    }

    /**
     * @return TW_AREA1_DESCR
     */
    public String getTwArea1Descr() {
        return twArea1Descr;
    }

    /**
     * @param twArea1Descr
     */
    public void setTwArea1Descr(String twArea1Descr) {
        this.twArea1Descr = twArea1Descr;
    }

    /**
     * @return TW_AREA1_CHIN
     */
    public String getTwArea1Chin() {
        return twArea1Chin;
    }

    /**
     * @param twArea1Chin
     */
    public void setTwArea1Chin(String twArea1Chin) {
        this.twArea1Chin = twArea1Chin;
    }

    /**
     * @return TW_FUNCSITE1_SHORT
     */
    public String getTwFuncsite1Short() {
        return twFuncsite1Short;
    }

    /**
     * @param twFuncsite1Short
     */
    public void setTwFuncsite1Short(String twFuncsite1Short) {
        this.twFuncsite1Short = twFuncsite1Short;
    }

    /**
     * @return TW_FUNCSITE1_DESCR
     */
    public String getTwFuncsite1Descr() {
        return twFuncsite1Descr;
    }

    /**
     * @param twFuncsite1Descr
     */
    public void setTwFuncsite1Descr(String twFuncsite1Descr) {
        this.twFuncsite1Descr = twFuncsite1Descr;
    }

    /**
     * @return TW_FUNCSITE1_CHIN
     */
    public String getTwFuncsite1Chin() {
        return twFuncsite1Chin;
    }

    /**
     * @param twFuncsite1Chin
     */
    public void setTwFuncsite1Chin(String twFuncsite1Chin) {
        this.twFuncsite1Chin = twFuncsite1Chin;
    }

    /**
     * @return TW_DEPT1_SHORT
     */
    public String getTwDept1Short() {
        return twDept1Short;
    }

    /**
     * @param twDept1Short
     */
    public void setTwDept1Short(String twDept1Short) {
        this.twDept1Short = twDept1Short;
    }

    /**
     * @return TW_DEPT1_DESCR
     */
    public String getTwDept1Descr() {
        return twDept1Descr;
    }

    /**
     * @param twDept1Descr
     */
    public void setTwDept1Descr(String twDept1Descr) {
        this.twDept1Descr = twDept1Descr;
    }

    /**
     * @return TW_DEPT1_CHIN
     */
    public String getTwDept1Chin() {
        return twDept1Chin;
    }

    /**
     * @param twDept1Chin
     */
    public void setTwDept1Chin(String twDept1Chin) {
        this.twDept1Chin = twDept1Chin;
    }
}
