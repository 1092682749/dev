package com.dyz.dev.service.impl;

import com.dyz.dev.oneDao.UserMapper;
import com.dyz.dev.model.User;
import com.dyz.dev.service.UserService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2019/06/12.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper dUserMapper;

}
