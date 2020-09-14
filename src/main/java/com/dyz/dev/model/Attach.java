package com.dyz.dev.model;

import javax.persistence.*;

@Table(name = "ERECALL_TBL_ATTACH_TABLE")
public class Attach {
	@Id
    @Column(name = "KEY_ID")
    private String keyId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_UID")
    private String fileUid;

    @Column(name = "TYPE")
    private String type;

    /**
     * @return KEY_ID
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * @param keyId
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
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
     * @return FILE_UID
     */
    public String getFileUid() {
        return fileUid;
    }

    /**
     * @param fileUid
     */
    public void setFileUid(String fileUid) {
        this.fileUid = fileUid;
    }

    /**
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}