package com.zpain.dbtest.entity;

import lombok.*;

import java.util.Date;

/**
 * @author zhangjun
 * @date 2021/10/20  15:24
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;

}
