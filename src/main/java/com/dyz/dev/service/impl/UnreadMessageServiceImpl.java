package com.dyz.dev.service.impl;

import com.dyz.dev.dao.UnreadMessageMapper;
import com.dyz.dev.model.UnreadMessage;
import com.dyz.dev.service.UnreadMessageService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/07/15.
 */
@Service
@Transactional
public class UnreadMessageServiceImpl extends AbstractService<UnreadMessage> implements UnreadMessageService {
    @Resource
    private UnreadMessageMapper solveCenterTblUnreadMapper;

}
