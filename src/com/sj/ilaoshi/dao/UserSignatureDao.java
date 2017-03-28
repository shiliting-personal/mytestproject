package com.sj.ilaoshi.dao;

import com.sj.ilaoshi.entity.UserSignature;

import java.util.Map;

/**
 * 用户签名关联持久层
 * Created by slt on 2017/3/27.
 */
public interface UserSignatureDao {
    UserSignature findOne(long id);

    UserSignature findBySecretId(long secretId);

    void addOne(Map map);
}
