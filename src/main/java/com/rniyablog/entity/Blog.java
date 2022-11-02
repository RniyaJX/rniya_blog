package com.rniyablog.entity;

import com.rniyablog.queryvo.BlogTags;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月06日 15:54
 * @Description:
 */
public class Blog {

    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private boolean commentable;
    private String flag;
    private boolean published;
    private boolean shareStatement;
    private boolean recommend;
    private String description;
    private int views;
    private Date createTime;

    private User user;
    private Long userId;
    private List<Comment> comments = new ArrayList<>();

    private String tagIds;

    private List<BlogTags> tags = new ArrayList<>();

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public List<BlogTags> getTags() {
        return tags;
    }

    public void setTags(List<BlogTags> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String init(List<BlogTags> blogTags){
        if (!blogTags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (BlogTags bt : blogTags){
                if(flag){
                    ids.append(",");
                }else{
                    flag = true;
                }
                ids.append(bt.getTagId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", commentable=" + commentable +
                ", flag='" + flag + '\'' +
                ", published=" + published +
                ", shareStatement=" + shareStatement +
                ", recommend=" + recommend +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", createTime=" + createTime +
                ", user=" + user +
                ", userId=" + userId +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                ", tags=" + tags +
                '}';
    }
}
