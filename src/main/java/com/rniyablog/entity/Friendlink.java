package com.rniyablog.entity;

/**
 * @author: Rniya
 * @date: 2022年09月23日 11:53
 * @Description:
 */
public class Friendlink {

    private Long id;
    private String link;
    private String img;
    private String avatar;
    private String title;
    private String webmaster;

    public Friendlink() {
    }

    public String getWebmaster() {
        return webmaster;
    }

    public void setWebmaster(String webmaster) {
        this.webmaster = webmaster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Friendlink{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", img='" + img + '\'' +
                ", avatar='" + avatar + '\'' +
                ", title='" + title + '\'' +
                ", webmaster='" + webmaster + '\'' +
                '}';
    }
}
