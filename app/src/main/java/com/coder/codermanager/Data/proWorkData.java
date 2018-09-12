package com.coder.codermanager.Data;

/**
 * Created by Rey on 2018/9/11.
 */

public class proWorkData {

    private String id;
    private String Name = "Egg";
    private String Time = "2018-09-11";
    private String Project = "線上預約APP";
    private String projectItem = "個人設定版面修改";
    private String Remarks = "備註測試123456789987546123168498";//備註

    public proWorkData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getProjectItem() {
        return projectItem;
    }

    public void setProjectItem(String projectItem) {
        this.projectItem = projectItem;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
}
