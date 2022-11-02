package com.rniyablog.service.impl;

import com.rniyablog.dao.admin.FriendlinkDao;
import com.rniyablog.entity.Friendlink;
import com.rniyablog.service.FriendlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年10月09日 21:59
 * @Description:
 */
@Service
public class FriendlinkServiceImpl implements FriendlinkService {
    @Autowired
    private FriendlinkDao friendlinkDao;

    @Override
    public List<Friendlink> getFriendlinkList() {
        return friendlinkDao.getFriendlinkList();
    }

    @Override
    public int saveFriendlink(Friendlink friendlink) {
        return friendlinkDao.saveFriendlink(friendlink);
    }

    @Override
    public int delete(Long id) {
        int f = friendlinkDao.deleteById(id);
        return f;
    }

    @Override
    public Friendlink findFriendlinkById(Long id) {
        return friendlinkDao.findFriendlinkById(id);
    }

    @Override
    public int editFriendlink(Friendlink friendlink) {
        return friendlinkDao.updateFriendlink(friendlink);
    }
}
