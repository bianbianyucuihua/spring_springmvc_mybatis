package com.hongyi.pojo;

import java.util.Date;

public class User1 {
    private Integer uid;
    private String uusername;
    private Date ubirthday;
    private String usex;
    private String uaddress;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUusername() {
        return uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    @Override
    public String toString() {
        return "User1{" +
                "uid=" + uid +
                ", uusername='" + uusername + '\'' +
                ", ubirthday=" + ubirthday +
                ", usex='" + usex + '\'' +
                ", uaddress='" + uaddress + '\'' +
                '}';
    }
}
