package com.transfar.service.impl;

import com.transfar.entity.Comment;
import com.transfar.entity.Post;
import com.transfar.entity.User;
import com.transfar.mapper.CommentMapper;
import com.transfar.mapper.PostMapper;
import com.transfar.mapper.UserMapper;
import com.transfar.service.UserService;
import com.transfar.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public User getUserById(int id) {
        System.out.println("=============================================UserImpl，getUserById："+id+"=============================================");
        User user = userMapper.getUserByPrimeryKey(id);
        if (user!=null){

            return user;
        }
        System.out.println("=============================================UserImpl，getUserById："+user+"=============================================");
        return new User();
    }

    @Override
    public Result userLogin(User user) {
        User userResult = userMapper.login(user.getUserName(), user.getPassword());
        System.out.println(userResult.toString());
        if (userResult!=null){
            return new Result(200,userResult,"success");
        }

        return null;
    }

    @Override
    public Result userRegister(User user) {
        int l = userMapper.insert(user);
        if (l>0){
            return new Result(200,l,"success");
        }

        return new Result();
    }

    @Override
    public Result editUserInformation(User user) {
        int l = userMapper.updateByPrimeryKey(user);

        return new Result(200,l,"success");
    }

    @Override
    public Result deleteUser(int id) {
//        int i = userMapper.deleteByPrimeryKey(id);
        User user = new User();
        user.setId(id);
        user.setStatus(0);
        Post post = new Post();
        Comment comment = new Comment();
        post.setStatus(0);//隐藏
        post.setUserId(id);
        comment.setUserId(id);
        comment.setStatus(0);//隐藏

        int i = userMapper.updateStatus(user);
        int t = postMapper.updateStatusByUserId(post);
        int l = commentMapper.updateStatusByUserId(comment);


        return new Result(200,i,"success");
    }


}
