package com.dyz.dev.model;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.ConstructorArgs;

import javax.persistence.*;

@Table(name = "SOLVE_CENTER_TBL_FILE")
public class IMMFile {
    @Column(name = "FORM_NO")
    private String formNo;

    @Column(name = "FORM_TYPE")
    private String formType;

    @Column(name = "FILE_FID")
    @Id
    private String fileFid;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *  type_specifications
     *  type_quality
     *  type_green_purchase
     *  type_safe_table
     *  type_approve_letter
     */

    @Column(name = "FILE_CLASSIFY")
    private String fileClassify;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "DELETED")
    private String deleted;

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
     * @return FORM_TYPE
     */
    public String getFormType() {
        return formType;
    }

    /**
     * @param formType
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * @return FILE_FID
     */
    public String getFileFid() {
        return fileFid;
    }

    /**
     * @param fileFid
     */
    public void setFileFid(String fileFid) {
        this.fileFid = fileFid;
    }

    /**
     * @return FILE_CLASSIFY
     */
    public String getFileClassify() {
        return fileClassify;
    }

    /**
     * @param fileClassify
     */
    public void setFileClassify(String fileClassify) {
        this.fileClassify = fileClassify;
    }

    /**
     * @return FILE_NAME
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return FILE_PATH
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

}
