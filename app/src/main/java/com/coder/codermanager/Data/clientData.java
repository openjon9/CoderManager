package com.coder.codermanager.Data;

/**
 * Created by Rey on 2018/9/13.
 */

public class clientData {


    private String id;
    private String logo;
    private String name = "公司名稱";
    private String editor = "10203040";//統編
    private String URL = "www.test.com";//公司網址
    private String proNumber = "100";//專案數量
    private String upTime = "2018-08-29 15:29:34";
    private String upUser = "egg";//最後管理者

    public clientData(String id) {
        this.id = id;
    }

    public clientData(String id, String proNumber) {
        this.id = id;
        this.proNumber = proNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getUpUser() {
        return upUser;
    }

    public void setUpUser(String upUser) {
        this.upUser = upUser;
    }
}
