package com.dyz.dev.service.impl;

import com.dyz.dev.dao.AttachMapper;
import com.dyz.dev.model.Attach;
import com.dyz.dev.service.AttachService;
import com.dyz.dev.utils.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2019/08/14.
 */
@Service
@Transactional
public class AttachServiceImpl extends AbstractService<Attach> implements AttachService {
    @Resource
    private AttachMapper attachMapper;

}
