package com.rniyablog.entity;

import net.sf.jsqlparser.util.validation.metadata.DatabaseException;

import java.util.Date;

/**
 * @author: Rniya
 * @date: 2022年09月06日 16:58
 * @Description:
 */
public class Message {

    private Long id;
    private String nickname;
    private String contact;
    private String contactNum;
    private String content;
    private Date createTime;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", contact='" + contact + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
