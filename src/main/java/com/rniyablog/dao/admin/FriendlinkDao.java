package com.rniyablog.dao.admin;

import com.rniyablog.entity.Friendlink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendlinkDao {
    List<Friendlink> getFriendlinkList();

    int saveFriendlink(Friendlink friendlink);

    Friendlink selectFriendlinkByTitle(String title);

    int deleteById(Long id);

    Friendlink findFriendlinkById(Long id);

    int updateFriendlink(Friendlink friendlink);
}
