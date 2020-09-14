package com.dyz.dev.model;

import javax.persistence.*;

@Table(name = "SOLVE_CENTER_CASE_ACTION")
public class CaseAction {
    @Column(name = "ACTION_TYPE")
    @Id
    private String actionType;

    @Column(name = "EMPLID")
    private String emplid;

    @Column(name = "EMPL_NAME")
    private String emplName;

    @Column(name = "CASE_ID")
    private Integer caseId;

    /**
     * @return ACTION_TYPE
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * @param actionType
     */
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    /**
     * @return EMPLID
     */
    public String getEmplid() {
        return emplid;
    }

    /**
     * @param emplid
     */
    public void setEmplid(String emplid) {
        this.emplid = emplid;
    }

    /**
     * @return EMPL_NAME
     */
    public String getEmplName() {
        return emplName;
    }

    /**
     * @param emplName
     */
    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }
}
