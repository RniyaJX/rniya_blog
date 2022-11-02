package com.rniyablog.queryvo;

/**
 * @author: Rniya
 * @date: 2022年09月28日 17:24
 * @Description:
 */
public class BlogTags {

    private Long blogId;
    private Long tagId;
    private String tagName;
    private int blogNum;

    public BlogTags() {
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    @Override
    public String toString() {
        return "BlogTags{" +
                "blogId=" + blogId +
                ", tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", blogNum=" + blogNum +
                '}';
    }
}
