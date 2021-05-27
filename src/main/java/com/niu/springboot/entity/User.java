package com.niu.springboot.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 用户实体
 *
 * @version 1.0 [2021/05/27 15:05]
 * @author [nza]
 * @createTime [2021/05/27 15:05]
 */
@Document(collection = "user")
@Data
@Accessors(chain = true)
@ToString
public class User {

    @Id
    private String id;

    @Field("username")
    private String username;

    private String password;
}
