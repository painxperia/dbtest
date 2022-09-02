//package com.zpain.dbtest.service.impl;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.zpain.dbtest.entity.Role;
//import com.zpain.dbtest.entity.User;
//import com.zpain.dbtest.mapper.RoleMapper;
//import com.zpain.dbtest.mapper.UserMapper;
//import com.zpain.dbtest.service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//
///**
// * @author zhangjun
// * @date 2022-06-14  13:07
// */
//@Service
//public class TestServiceImpl implements TestService {
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private TestService testService;
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public String test1() {
//        Role role = new Role(9L, "test6", 6);
//        roleMapper.insert(role);
//        test2();
//        return "ok";
//    }
//
//    @Override
//    @Transactional(propagation=Propagation.NEVER)
//    public String test2() {
//        User user = new User();
//        user.setId(10L);
//        user.setEmail("123");
//        user.setUsername("123");
//        user.setPassword("123");
//        userMapper.insert(user);
//
//        return null;
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public String test3() {
//        try {
//            roleMapper.insert(null);
//            userMapper.insert(null);
//
//            //todo
//
//        }catch (Exception e){
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
//
//        return null;
//    }
//}
