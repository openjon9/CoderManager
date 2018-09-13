package com.coder.codermanager.Data;

/**
 * Created by Rey on 2018/9/13.
 */

public class homePmListData {

    private String id;
    private String priority = "低"; // 優先
    private String status = "處理中";
    private String project = "測試";
    private String title = "標題";
    private String workSave;
    private String principal;//負責人
    private String testUser;
    private String startTime;
    private String completeTime;
    private String type;
    private String upTime;//修改時間
    private String manaUser; //管理者

    public homePmListData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkSave() {
        return workSave;
    }

    public void setWorkSave(String workSave) {
        this.workSave = workSave;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTestUser() {
        return testUser;
    }

    public void setTestUser(String testUser) {
        this.testUser = testUser;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getManaUser() {
        return manaUser;
    }

    public void setManaUser(String manaUser) {
        this.manaUser = manaUser;
    }
}
