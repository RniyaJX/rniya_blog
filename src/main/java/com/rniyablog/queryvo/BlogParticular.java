package com.rniyablog.queryvo;

import com.rniyablog.entity.Comment;
import com.rniyablog.entity.Tag;
import com.rniyablog.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月28日 16:51
 * @Description:
 */
public class BlogParticular {

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

    private List<BlogTags> blogTags = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public BlogParticular() {
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

    public List<BlogTags> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<BlogTags> blogTags) {
        this.blogTags = blogTags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "BlogParticular{" +
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
                ", blogTags=" + blogTags +
                ", comments=" + comments +
                '}';
    }
}
