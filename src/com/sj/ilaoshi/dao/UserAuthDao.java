package com.sj.ilaoshi.dao;

import com.sj.ilaoshi.entity.UserAuth;

/**
 * 用户首选关联持久层
 * Created by slt on 2017/3/27.
 */
public interface UserAuthDao {
    UserAuth findOne(long id);
}
