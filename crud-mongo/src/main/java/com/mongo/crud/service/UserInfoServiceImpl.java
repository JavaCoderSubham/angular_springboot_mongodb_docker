package com.mongo.crud.service;

import com.mongo.crud.entity.UserInfo;
import com.mongo.crud.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public List<UserInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public UserInfo getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserInfo create(UserInfo userInfo) {
        userInfo.setUserId(UUID.randomUUID().toString());
        return userInfo;
    }

    @Override
    public UserInfo update(String id, UserInfo userInfo) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
