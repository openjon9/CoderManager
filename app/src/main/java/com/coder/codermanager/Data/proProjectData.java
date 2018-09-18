package com.coder.codermanager.Data;

/**
 * Created by Rey on 2018/9/7.
 */

public class proProjectData {

    private String ID;
    private String Name = "test";                      //名稱
    private String imgUrl;                    //圖片網址
    private String client = "main_page_2";                    //客戶
    private String clientWindow;              //客戶窗口
    private String proLeader;                 //專案負責人
    private String proExecution;              //專案執行
    private String testUser;                  //測試者
    private String proStatus;                 //專案狀態
    private String proType;                   //專案類型
    private String executionContext;          //執行內容
    private String Related;                   //相關技術
    private String toDoNumber;                //代辦數量
    private String toDoBug;                   //代辦Bug
    private String upTime;                    //最後修改時間
    private String upUser;                    //最後管理者


    public proProjectData(String ID) {
        this.ID = ID;
    }

    public proProjectData() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientWindow() {
        return clientWindow;
    }

    public void setClientWindow(String clientWindow) {
        this.clientWindow = clientWindow;
    }

    public String getProLeader() {
        return proLeader;
    }

    public void setProLeader(String proLeader) {
        this.proLeader = proLeader;
    }

    public String getProExecution() {
        return proExecution;
    }

    public void setProExecution(String proExecution) {
        this.proExecution = proExecution;
    }

    public String getTestUser() {
        return testUser;
    }

    public void setTestUser(String testUser) {
        this.testUser = testUser;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getExecutionContext() {
        return executionContext;
    }

    public void setExecutionContext(String executionContext) {
        this.executionContext = executionContext;
    }

    public String getRelated() {
        return Related;
    }

    public void setRelated(String related) {
        Related = related;
    }

    public String getToDoNumber() {
        return toDoNumber;
    }

    public void setToDoNumber(String toDoNumber) {
        this.toDoNumber = toDoNumber;
    }

    public String getToDoBug() {
        return toDoBug;
    }

    public void setToDoBug(String toDoBug) {
        this.toDoBug = toDoBug;
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
