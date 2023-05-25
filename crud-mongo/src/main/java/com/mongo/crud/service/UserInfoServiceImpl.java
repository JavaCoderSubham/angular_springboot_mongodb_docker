package com.mongo.crud.service;

import com.mongo.crud.entity.UserInfo;
import com.mongo.crud.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public List<UserInfo> getAll() {

        List<UserInfo> all = repository.findAll();
        List<UserInfo> perfect = all.parallelStream()
                .filter((user) -> user.getIsActive())
                .collect(Collectors.toList());

//        for(UserInfo user : all) {
//            if(user.getIsActive()) {
//                perfect.add(user);
//            }
//        }

        return perfect;
    }

    @Override
    public UserInfo getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserInfo create(UserInfo userInfo) {
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setIsActive(true);
        return repository.save(userInfo);
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

//    private boolean isCheckUserInfo(String id) {
//        UserInfo get = getById(id);
//        return get != null;
//    }

    @Override
    public void deleteById(String id) {
        UserInfo user = getById(id);
        if(user != null) {
            user.setIsActive(false);
        }
        repository.save(user);
    }

    @Override
    public void deleteAll() {
        List<UserInfo> getAll = getAll();
        for(UserInfo user : getAll) {
            user.setIsActive(false);
        }
    }

    @Override
    public void delete() {
        repository.deleteAll();
    }

}
