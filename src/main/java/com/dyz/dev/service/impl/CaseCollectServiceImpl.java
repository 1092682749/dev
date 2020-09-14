package com.dyz.dev.service.impl;

import com.dyz.dev.dao.CaseCollectMapper;
import com.dyz.dev.model.CaseCollect;
import com.dyz.dev.service.CaseCollectService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/07/16.
 */
@Service
@Transactional
public class CaseCollectServiceImpl extends AbstractService<CaseCollect> implements CaseCollectService {
    @Resource
    private CaseCollectMapper solveCenterTblCollectMapper;

}
