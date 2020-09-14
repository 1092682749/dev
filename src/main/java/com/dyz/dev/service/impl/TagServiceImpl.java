package com.dyz.dev.service.impl;

import com.dyz.dev.dao.TagMapper;
import com.dyz.dev.model.Tag;
import com.dyz.dev.service.TagService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by dyz on 2020/06/29.
 */
@Service
@Transactional
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    @Resource
    private TagMapper solveCenterTblTagMapper;

  @Override
  public List<Tag> findAllByModuleName(String moduleName) {
    List<String> moduleNames = Arrays.stream(moduleName.split(",")).filter(i -> !"".equals(i)).collect(Collectors.toList());
    return solveCenterTblTagMapper.findAllByModuleName(moduleNames);
  }
}
