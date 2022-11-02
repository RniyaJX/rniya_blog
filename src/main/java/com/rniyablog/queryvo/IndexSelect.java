package com.rniyablog.queryvo;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

/**
 * @author: Rniya
 * @date: 2022年09月26日 18:10
 * @Description:
 */
public class IndexSelect {

    private Integer blogs;
    private Integer comments;
    private Integer views;

    public IndexSelect() {
    }

    public Integer getBlogs() {
        return blogs;
    }

    public void setBlogs(Integer blogs) {
        this.blogs = blogs;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "IndexSelect{" +
                "blogs=" + blogs +
                ", comments=" + comments +
                ", views=" + views +
                '}';
    }
}
