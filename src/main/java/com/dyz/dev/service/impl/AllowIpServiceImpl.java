package com.dyz.dev.service.impl;

import com.dyz.dev.dao.AllowIpMapper;
import com.dyz.dev.model.AllowIp;
import com.dyz.dev.service.AllowIpService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/07/20.
 */
@Service
@Transactional
public class AllowIpServiceImpl extends AbstractService<AllowIp> implements AllowIpService {
    @Resource
    private AllowIpMapper solveCenterTblAllowIpMapper;

}
