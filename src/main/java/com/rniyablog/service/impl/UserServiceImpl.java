package com.rniyablog.service.impl;

import com.rniyablog.dao.admin.UserDao;
import com.rniyablog.entity.User;
import com.rniyablog.service.UserService;
import com.rniyablog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Rniya
 * @date: 2022年09月04日 18:12
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User chickUser(String username, String password) {
        User user =  userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }


}
