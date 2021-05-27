package com.niu.springboot.service;

import com.niu.springboot.entity.User;

/**
 * Mongodb 业务类
 *
 * @author [nza]
 * @version 1.0 [2021/05/27 15:10]
 * @createTime [2021/05/27 15:10]
 */
public interface MongodbService {

    /**
     * 根据用户名称获取用户
     *
     * @param username 用户名称
     * @return {@link com.niu.springboot.entity.User} 用户实体
     * @author nza
     * @createTime 2021/5/27 15:14
     */
    User getUserByUserName(String username);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return {@link User} 更新后的实体
     * @author nza
     * @createTime 2021/5/27 15:18
     */
    User save(User user);

    /**
     * 根据ID删除
     *
     * @param id ID
     * @author nza
     * @createTime 2021/5/27 15:23
     */
    void deleteById(String id);

    /**
     * 更新用户信息
     *
     * @param user 用户实体
     * @return {@link User} 更新后的实体
     * @author nza
     * @createTime 2021/5/27 15:26
     */
    User update(User user);
}
