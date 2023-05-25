package com.mongo.crud.controller;

import com.mongo.crud.entity.UserInfo;
import com.mongo.crud.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @GetMapping("/getAll")
    public List<UserInfo> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public UserInfo getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public UserInfo create(@RequestBody UserInfo userInfo) {
        return service.create(userInfo);
    }

    @PutMapping("/update/{id}")
    public UserInfo update(@RequestBody UserInfo userInfo, @PathVariable String id) {
        return service.update(id, userInfo);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("/delete")
    public void delete() {
        service.delete();
    }


}
