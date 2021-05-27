package com.niu.springboot.service.impl;

import cn.hutool.core.util.StrUtil;
import com.niu.springboot.entity.User;
import com.niu.springboot.repository.MyMongodbRepository;
import com.niu.springboot.service.MongodbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Mongodb 业务实现类
 *
 * @author [nza]
 * @version 1.0 [2021/05/27 15:15]
 * @createTime [2021/05/27 15:15]
 */
@Service
@AllArgsConstructor
public class MongodbServiceImpl implements MongodbService {

    private final MyMongodbRepository myMongodbRepository;

    @Override
    public User getUserByUserName(String username) {
        return myMongodbRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("非法参数");
        }

        // 设置ID
        user.setId(UUID.randomUUID().toString());

        return myMongodbRepository.insert(user);
    }

    @Override
    public void deleteById(String id) {
        if (StrUtil.isEmpty(id)) {
            throw new IllegalArgumentException("非法参数");
        }
        myMongodbRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        if (user == null || StrUtil.isEmpty(user.getId())) {
            throw new IllegalArgumentException("非法参数");
        }
        boolean exists = myMongodbRepository.existsById(user.getId());
        if (!exists) {
            throw new IllegalArgumentException("非法的用户ID");
        }
        return myMongodbRepository.save(user);
    }
}
