package com.hwgif.jwtauth.service.impl;

import com.hwgif.jwtauth.common.db.domain.PageInfo;
import com.hwgif.jwtauth.common.db.domain.PageControl;
import com.hwgif.jwtauth.bean.User;
import com.hwgif.jwtauth.service.UserService;
import com.hwgif.jwtauth.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* <p>
 *  服务实现类
 * </p>
*
* @author lc.huang
* @since 2020-11-07
*/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

@Autowired
private UserDao userDao;

public Integer insertUser(User user){
if (user == null) {
return 0;
}

Integer i = userDao.insert(user);
return i;
}

public User find(Integer id){
return userDao.getEntityById(id);
}

public Integer deleteLogical(Integer id){
   User temp = new User();
   temp.setId(id);
   temp.setDelFlag(1);
   return userDao.update(temp);
}

public Integer updateUser(User user){
if (user == null) {
return 0;
}

Integer i = userDao.update(user);
return i;
}

public PageControl<User> pageAndSortById(User user, PageInfo pageInfo){
return userDao.getPageByObject(user, pageInfo, null, " order by id asc ");
}

public PageControl<User> page(User user, PageInfo pageInfo, String whereSql, String orderSql){
return userDao.getPageByObject(user, pageInfo, whereSql, orderSql);
}


}
