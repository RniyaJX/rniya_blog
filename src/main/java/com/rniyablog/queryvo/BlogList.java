package com.rniyablog.queryvo;

import java.util.Date;

/**
 * @author: Rniya
 * @date: 2022年10月08日 21:33
 * @Description:
 */
public class BlogList {

    private String title;
    private Long id;
    private String firstPicture;
    private String description;
    private String flag;
    private int views;
    private int commentCount;
    private Date createTime;

    public BlogList() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogList{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", firstPicture='" + firstPicture + '\'' +
                ", description='" + description + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", commentCount=" + commentCount +
                ", createTime=" + createTime +
                '}';
    }
}
