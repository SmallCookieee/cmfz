package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by zxl on 2018/7/6.
 */
public class Guru implements Serializable {
    @Excel(name="上师ID")
    private String guruId;
    @Excel(name="上师法号")
    private String guruName;
    @Excel(name="上师图像")
    private String guruPhoto;
    @Excel(name="上师描述")
    private String guruSummary;

    public Guru(String guruId, String guruName, String guruPhoto, String guruSummary) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruPhoto = guruPhoto;
        this.guruSummary = guruSummary;
    }

    public Guru() {
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruSummary='" + guruSummary + '\'' +
                '}';
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruSummary() {
        return guruSummary;
    }

    public void setGuruSummary(String guruSummary) {
        this.guruSummary = guruSummary;
    }
}
