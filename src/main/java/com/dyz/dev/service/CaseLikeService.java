package com.dyz.dev.service;
import com.dyz.dev.model.CaseLike;
import com.dyz.dev.utils.Service;


/**
 * Created by dyz on 2020/06/19.
 */
public interface CaseLikeService extends Service<CaseLike> {
  public String likeOrUnlike(CaseLike caseLike);

}
