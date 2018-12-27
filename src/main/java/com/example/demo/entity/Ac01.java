package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/12/18
 *
 *******************************************************************************/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ac01 {
    private  Long aac001;
    private String aac002;
    private String aac003;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAac001() {
        return aac001;
    }

    public void setAac001(Long aac001) {
        this.aac001 = aac001;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }
}
