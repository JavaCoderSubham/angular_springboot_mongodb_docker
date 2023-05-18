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
        UserInfo user = getById(id);

        if(user != null) {
            user.setName(userInfo.getName());
            user.setEmail(userInfo.getEmail());
            user.setPassword(userInfo.getPassword());
            user.setAge(userInfo.getAge());

            return repository.save(user);
        }

        return null;
    }

    private boolean isCheckUserInfo(String id) {
        UserInfo get = getById(id);
        return get != null;
    }

    @Override
    public void deleteById(String id) {
        if(isCheckUserInfo(id))
            repository.deleteById(id);
        throw new RuntimeException("Not Found");
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
