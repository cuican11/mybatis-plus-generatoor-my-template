package com.hwgif.jwtauth.dao.impl;

import com.hwgif.jwtauth.common.db.dao.BaseDao;
import com.hwgif.jwtauth.bean.User;
import com.hwgif.jwtauth.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
* <p>
 * 
 * </p>
*
* @author lc.huang
* @since 2020-11-07
*/
@Repository
public class UserDaoImpl extends BaseDao<Integer, User> implements UserDao {

}

