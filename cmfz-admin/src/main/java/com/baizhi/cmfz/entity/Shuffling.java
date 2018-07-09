package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zxl on 2018/7/5.
 */
public class Shuffling implements Serializable {

    private String id;
    private String path;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String description;
    private String status;

    public Shuffling(String id, String path, Date date, String description, String status) {
        this.id = id;
        this.path = path;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public Shuffling() {
    }

    @Override
    public String toString() {
        return "Shuffling{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
