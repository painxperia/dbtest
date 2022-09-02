package com.zpain.dbtest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.zpain.dbtest.entity.User;
import com.zpain.dbtest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DbtestApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void batchInsert() {
        List<User> allUser = userService.getAllUser("", "");
        log.info("list:{}",allUser.size());
    }

    @Test
    public void test(){
        List<User> user = userService.getUser(1, 2);
        PageInfo<User> userPageInfo = new PageInfo<>(user);
        log.info("list:{}", JSON.toJSONString(userPageInfo));
    }

}
