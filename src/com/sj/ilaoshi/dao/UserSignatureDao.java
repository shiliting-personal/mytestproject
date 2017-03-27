package com.sj.ilaoshi.dao;

import com.sj.ilaoshi.entity.UserSignature;

/**
 * 用户签名关联持久层
 * Created by slt on 2017/3/27.
 */
public interface UserSignatureDao {
    UserSignature findOne(long id);
}
