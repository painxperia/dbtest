package com.zpain.dbtest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.zpain.dbtest.entity.User;
import com.zpain.dbtest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    public void setUser(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            List<User> list = IntStream.rangeClosed(1, 10000).mapToObj((i) -> {
                User user = new User();
                user.setId((long) i);
                String format = String.format("zpain:%s", i);
                user.setUsername(format);
                user.setPassword(format);
                user.setEmail(format);
                return user;
            }).collect(Collectors.toList());
            userService.saveUser(list);
            stopWatch.stop();
            log.info("用时:{}",stopWatch.getTotalTimeSeconds());
        }catch (Exception e){
            log.error("e:",e);
        }
    }

    @Test
    @Transactional
    public void getUser(){
        Cursor<User>  list = userService.getUserCursor(20);
        list.forEach( l->{
            log.info("user:{}",JSON.toJSONString(l));
        } );
    }

}
