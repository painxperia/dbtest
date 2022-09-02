package com.zpain.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhangjun
 * @date 2021/10/21  13:10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Long id;
    private Long userId;
    private Long roleId;
}
