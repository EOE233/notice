package com.zhbit.bean;

import java.util.Date;

public class Notice {
    private int nNo;         //ID
    private String nTitle;   //通知公告标题
    private String nContent; //通知公告内容
    private String nEditor;    //通知公告发布者
    private Date nCreateTime;//发布时间
    private int nType;        //通知公告类型
    private int uNo;        //发布者ID

    public Notice() {
    }

    public Notice(int nNo, String nTitle, String nContent, String nEditor, Date nCreateTime, int nType, int uNo) {
        this.nNo = nNo;
        this.nTitle = nTitle;
        this.nContent = nContent;
        this.nEditor = nEditor;
        this.nCreateTime = nCreateTime;
        this.nType = nType;
        this.uNo = uNo;
    }

    public int getuNo() {
        return uNo;
    }

    public void setuNo(int uNo) {
        this.uNo = uNo;
    }

    public int getnNo() {
        return nNo;
    }

    public void setnNo(int nNo) {
        this.nNo = nNo;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public String getnEditor() {
        return nEditor;
    }

    public void setnEditor(String nEditor) {
        this.nEditor = nEditor;
    }

    public Date getnCreateTime() {
        return nCreateTime;
    }

    public void setnCreateTime(Date nCreateTime) {
        this.nCreateTime = nCreateTime;
    }

    public int getnType() {
        return nType;
    }

    public void setnType(int nType) {
        this.nType = nType;
    }

    @Override
    public String toString() {
        return "Notice{" + "nNo=" + nNo + ", nTitle='" + nTitle + '\'' + ", nContent='" + nContent + '\'' + ", nEditor='" + nEditor + '\'' + ", nCreateTime=" + nCreateTime + ", nType=" + nType + '}';
    }
}
