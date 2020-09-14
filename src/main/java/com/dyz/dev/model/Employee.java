package com.dyz.dev.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHR_T_EMP")
public class Employee implements Serializable {
//    static final long serialVersionUID = 123123;
    @Id
    @Column(name = "EMP_NO")
    private String empNo;

    @Column(name = "E_NAME")
    private String eName;

    @Column(name = "CNAME_SH")
    private String cnameSh;

    @Column(name = "MAIL_NAME")
    private String mailName;


    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getCnameSh() {
        return cnameSh;
    }

    public void setCnameSh(String cnameSh) {
        this.cnameSh = cnameSh;
    }

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }
}
