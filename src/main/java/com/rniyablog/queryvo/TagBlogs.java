package com.rniyablog.queryvo;

/**
 * @author: Rniya
 * @date: 2022年09月19日 21:09
 * @Description:
 */
public class TagBlogs {

    private Long tagId;
    private String tagName;
    private Integer blogNum;

    public TagBlogs() {
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

    public void setBlogNum(Integer blogNum) {
        this.blogNum = blogNum;
    }
}
