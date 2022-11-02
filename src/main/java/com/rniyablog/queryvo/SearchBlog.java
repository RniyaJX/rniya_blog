package com.rniyablog.queryvo;

/**
 * @author: Rniya
 * @date: 2022年09月12日 22:43
 * @Description: 博客管理列表查询博客
 */
public class SearchBlog {

    private Long blogId;
    private String blogTitle;
    private String flag;

    public SearchBlog() {
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SearchBlog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", flag=" + flag +
                '}';
    }
}
