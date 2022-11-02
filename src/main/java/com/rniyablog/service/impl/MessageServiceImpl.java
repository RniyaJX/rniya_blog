package com.rniyablog.service.impl;

import com.rniyablog.dao.admin.MessageDao;
import com.rniyablog.entity.Message;
import com.rniyablog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月23日 12:06
 * @Description:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> findAll() {
        return messageDao.getAllMessages();
    }

    @Override
    public int deleteMessageById(Long id) {
        return messageDao.deleteMessageById(id);
    }

    public int saveMessage(Message message){
        message.setCreateTime(new Date());
        return messageDao.saveMessage(message);
    }
}
