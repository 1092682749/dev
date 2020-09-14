package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_PERMISSION")
public class Permission {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "P_NAME")
    private String pName;

    @Column(name = "P_DESC")
    private String pDesc;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "UPDAE_NT")
    private String updaeNt;

    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return P_NAME
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * @return P_DESC
     */
    public String getpDesc() {
        return pDesc;
    }

    /**
     * @param pDesc
     */
    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
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
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return UPDAE_NT
     */
    public String getUpdaeNt() {
        return updaeNt;
    }

    /**
     * @param updaeNt
     */
    public void setUpdaeNt(String updaeNt) {
        this.updaeNt = updaeNt;
    }

    /**
     * @return IS_DELETE
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
