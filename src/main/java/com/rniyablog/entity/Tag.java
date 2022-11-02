package com.rniyablog.entity;

/**
 * @author: Rniya
 * @date: 2022年09月06日 17:00
 * @Description:
 */
public class Tag {

    private Long id;
    private String tagName;

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + tagName + '\'' +
                '}';
    }
}
