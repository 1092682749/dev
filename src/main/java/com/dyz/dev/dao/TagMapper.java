package com.dyz.dev.dao;

import com.dyz.dev.model.Tag;
import com.dyz.dev.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper extends Mapper<Tag> {
  List<Tag> findAllByModuleName(@Param("moduleNames") List<String> moduleNames);
}
