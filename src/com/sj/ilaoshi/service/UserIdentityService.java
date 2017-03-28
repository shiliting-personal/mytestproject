package com.sj.ilaoshi.service;

/**
 * 用来设置用户登录之后获取和保存用户的唯一标识字符串
 * Created by slt on 2017/3/28.
 */
public interface UserIdentityService {

    /**
     * 保存并返回用户的唯一标识符,返回null则标识保存失败
     * @param userId  登录的用户id
     * @return        唯一标识符，返回null则标识保存失败
     */
    String saveUniqueId(long userId);

    /**
     * 根据唯一标识符返回用户ID，如果返回null则表示唯一标识无效
     * @param uniqueId      用户唯一标识
     * @return              用户ID，如果为null则表示唯一标识无效
     */
    Long getUserId(String uniqueId);
}
