package com.zpain.dbtest.service;

import com.zpain.dbtest.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangjun
 * @date 2022-09-02  13:45
 */
@Repository
public interface UserService {
    List<User> getAllUser(@Param("username") String username, @Param("password") String password);

    List<User> getUser(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);


    Cursor<User> getUserCursor(@Param("limit") Integer limit);

    int saveUser(List<User> list);
}
