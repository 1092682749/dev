package com.dyz.dev.service.impl;


import com.dyz.dev.model.Admin;
import com.dyz.dev.service.AdminService;
import com.dyz.dev.towDao.AdminMapper;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2019/08/17.
 */
@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

}
