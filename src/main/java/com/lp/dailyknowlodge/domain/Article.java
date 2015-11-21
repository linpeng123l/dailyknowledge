package com.lp.dailyknowlodge.domain;

import java.util.Date;

/**
 * Created by linpe on 2015/11/2.
 */
public class Article {

    private long articleId;
    private String title;
    private String author;
    private String articlelAbstract;
    private Date postTime;
    private String masterImgUrl;
    private String contentUrl;
    private long praiseNum;
    private long stepNum;
    private long readNum;
    private long isDelete;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getMasterImgUrl() {
        return masterImgUrl;
    }

    public void setMasterImgUrl(String masterImgUrl) {
        this.masterImgUrl = masterImgUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public long getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(long isDelete) {
        this.isDelete = isDelete;
    }

    public String getArticlelAbstract() {
        return articlelAbstract;
    }

    public void setArticlelAbstract(String articlelAbstract) {
        this.articlelAbstract = articlelAbstract;
    }

    public long getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(long praiseNum) {
        this.praiseNum = praiseNum;
    }

    public long getStepNum() {
        return stepNum;
    }

    public void setStepNum(long stepNum) {
        this.stepNum = stepNum;
    }

    public long getReadNum() {
        return readNum;
    }

    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }
}
