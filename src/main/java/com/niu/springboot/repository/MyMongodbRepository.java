package com.niu.springboot.repository;

import com.niu.springboot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <功能简述>
 *
 * @author [nza]
 * @version 1.0 [2021/05/27 15:11]
 * @createTime [2021/05/27 15:11]
 */
@Repository
public interface MyMongodbRepository extends MongoRepository<User, String> {

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @author nza
     * @createTime 2021/5/27 15:13
     * @return    {@link com.niu.springboot.entity.User}
     */
    User findByUsername(String username);
}
