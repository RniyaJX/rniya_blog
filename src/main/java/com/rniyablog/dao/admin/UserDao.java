package com.rniyablog.dao.admin;

import com.rniyablog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: Rniya
 * @date: 2022年09月04日 18:55
 * @Description:
 */

@Mapper
@Repository
public interface UserDao {

    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    User getUserByUserId(Long id);
}
