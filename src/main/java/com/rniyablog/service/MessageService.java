package com.rniyablog.service;

import com.rniyablog.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    int deleteMessageById(Long id);

    int saveMessage(Message message);
}
