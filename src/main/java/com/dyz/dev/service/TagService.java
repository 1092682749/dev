package com.dyz.dev.service;
import com.dyz.dev.model.Tag;
import com.dyz.dev.utils.Service;

import java.util.List;


/**
 * Created by dyz on 2020/06/29.
 */
public interface TagService extends Service<Tag> {
  List<Tag> findAllByModuleName(String moduleName);
}
