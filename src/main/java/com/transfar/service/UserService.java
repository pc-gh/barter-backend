package com.transfar.service;

import com.transfar.entity.User;
import com.transfar.common.Result;

public interface UserService {
    User getUserById(int id);
    Result userLogin(User user);
    Result userRegister(User user);
    Result editUserInformation(User user);
    Result deleteUser(int id);
}


