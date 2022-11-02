package com.rniyablog.dao.admin;

import com.rniyablog.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月23日 12:07
 * @Description:
 */

@Mapper
@Repository
public interface MessageDao {
    List<Message> getAllMessages();
    int deleteMessageById(Long id);
    int saveMessage(Message message);
}
