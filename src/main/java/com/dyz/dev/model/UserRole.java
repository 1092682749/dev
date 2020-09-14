package com.dyz.dev.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "SOLVE_CENTER_USER_ROLE")
public class UserRole {
    @Column(name = "ID")
    @Id
    private String id;

    @Column(name = "U_ID")
    private String uId;

    @Column(name = "R_ID")
    private String rId;

    @Column(name = "U_TYPE")
    private String uType;

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
     * @return U_ID
     */
    public String getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(String uId) {
        this.uId = uId;
    }

    /**
     * @return R_ID
     */
    public String getrId() {
        return rId;
    }

    /**
     * @param rId
     */
    public void setrId(String rId) {
        this.rId = rId;
    }

    /**
     * @return U_TYPE
     */
    public String getuType() {
        return uType;
    }

    /**
     * @param uType
     */
    public void setuType(String uType) {
        this.uType = uType;
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
