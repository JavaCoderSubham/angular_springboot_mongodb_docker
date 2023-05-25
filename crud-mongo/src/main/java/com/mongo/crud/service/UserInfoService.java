package com.mongo.crud.service;

import com.mongo.crud.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getAll();

    UserInfo getById(String id);

    UserInfo create(UserInfo userInfo);

    UserInfo update(String id, UserInfo userInfo);

    void deleteById(String id);

    void deleteAll();

    void delete();

}






