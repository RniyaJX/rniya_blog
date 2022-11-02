package com.rniyablog.service;

import com.rniyablog.entity.Friendlink;

import java.util.List;

public interface FriendlinkService {

    List<Friendlink> getFriendlinkList();

    int saveFriendlink(Friendlink friendlink);

    int delete(Long id);

    Friendlink findFriendlinkById(Long id);

    int editFriendlink(Friendlink friendlink);
}
