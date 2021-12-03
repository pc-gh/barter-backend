package com.transfar.service;

import com.transfar.entity.User;
import com.transfar.common.Result;

import java.util.List;

public interface UserService {
    Result getUserById(int id);
    Result userLogin(User user);
    Result userRegister(User user);
    Result editUserInformation(User user);
    Result deleteUser(int id);
    Result getUserByName(String userName);
}


