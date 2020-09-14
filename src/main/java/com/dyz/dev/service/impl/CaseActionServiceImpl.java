package com.dyz.dev.service.impl;

import com.dyz.dev.dao.CaseActionMapper;
import com.dyz.dev.model.CaseAction;
import com.dyz.dev.service.CaseActionService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/06/15.
 */
@Service
@Transactional
public class CaseActionServiceImpl extends AbstractService<CaseAction> implements CaseActionService {
    @Resource
    private CaseActionMapper solveCenterCaseActionMapper;

}
