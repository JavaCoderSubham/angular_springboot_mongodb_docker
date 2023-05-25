package com.mongo.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    private String userId;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;
    private Integer age;
    private Boolean isActive;
    private Boolean checkBox;


}




