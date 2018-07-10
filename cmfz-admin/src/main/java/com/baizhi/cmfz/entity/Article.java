package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zxl on 2018/7/9.
 */
public class Article implements Serializable{
    private String articleId;
    private String articleName;
    private String introduction;
    @JSONField(format = "yyyy-MM-dd ,HH:mm:ss")
    private Date articleDate;
    private String articleSrc;
    private String articleAuthor;
    private String articleStatus;

    public Article(String articleId, String articleName, String introduction, Date articleDate, String articleSrc, String articleAuthor, String articleStatus) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.introduction = introduction;
        this.articleDate = articleDate;
        this.articleSrc = articleSrc;
        this.articleAuthor = articleAuthor;
        this.articleStatus = articleStatus;
    }

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", articleDate=" + articleDate +
                ", articleSrc='" + articleSrc + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleSrc() {
        return articleSrc;
    }

    public void setArticleSrc(String articleSrc) {
        this.articleSrc = articleSrc;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }
}

