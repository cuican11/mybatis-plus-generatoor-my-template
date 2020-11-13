package com.hwgif.jwtauth.service;

import com.hwgif.jwtauth.common.db.domain.PageInfo;
import com.hwgif.jwtauth.common.db.domain.PageControl;
import com.hwgif.jwtauth.bean.User;


/**
* <p>
 *  服务类
 * </p>
*
* @author lc.huang
* @since 2020-11-07
*/
public interface UserService {

Integer insertUser(User var);

User find(Integer id);

Integer deleteLogical(Integer id);

Integer updateUser(User var);

PageControl<User> page(User var1, PageInfo pageInfo, String whereSql, String orderSql);

}