package com.niu.springboot;

import com.niu.springboot.entity.User;
import com.niu.springboot.service.MongodbService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MongodbServiceTest {

    @Autowired
    private MongodbService mongodbService;

    @Test
    void testMongoDb() {

        User user = new User()
                .setUsername("pepsi")
                .setPassword("123456");
        user = mongodbService.save(user);
        log.info("保存用户: {}", user);

        user.setUsername("pepsi2");
        user = mongodbService.update(user);
        log.info("编辑用户: {}", user);

        user = mongodbService.getUserByUserName(user.getUsername());
        log.info("查询用户: {}", user);

        mongodbService.deleteById(user.getId());
        log.info("删除用户");

        user = mongodbService.getUserByUserName(user.getUsername());
        log.info("查询用户: {}", user);
    }
}
