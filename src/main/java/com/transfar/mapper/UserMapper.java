package com.transfar.mapper;

import com.transfar.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    //    查询
    User getUserByPrimeryKey(int userId);
    List<User> getUserByUserName(String userName);

    //    删除
    int deleteByPrimeryKey(int id);
    //    更新，修改用户信息
    int updateByPrimeryKey(User user);
    int updateStatus(User user);

    //    插入，注册新增用户
    int insert(User user);

    User login(String userName,String password);

}
