package com.dyz.dev.service.impl;

import com.dyz.dev.oneDao.ArticleMapper;
import com.dyz.dev.model.Article;
import com.dyz.dev.service.ArticleService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2019/08/14.
 */
@Service
@Transactional
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

}
