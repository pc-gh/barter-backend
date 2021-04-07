package com.transfar.controller;

import com.transfar.entity.User;
import com.transfar.service.impl.UserServiceImpl;
import com.transfar.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    String errorName = "UserController";

    @Autowired
    UserServiceImpl userService;


    @ApiOperation("用户登录")
    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result userLogin(@RequestBody User user){

        try{

            return userService.userLogin(user);


        }catch (Exception e){
            System.out.println(errorName+"##userLogin##"+e.getMessage());
            return new Result();

        }
    }

    @ApiOperation("用户注册")
    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result userRegister(@RequestBody User user){
        try{
            return userService.userRegister(user);
        }catch (Exception e){
            System.out.println(errorName+"##userRegister##"+e.getMessage());
            return new Result();
        }
    }

    @ApiOperation("用户修改信息")
    @PostMapping(value = "/editInformation",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result editUserInformation(@RequestBody User user){
        try{
            return userService.editUserInformation(user);

        }catch (Exception e){
            System.out.println(errorName+"##editUserInformation##"+e.getMessage());
            return new Result();

        }

    }

    @PostMapping(value = "/deleteUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("删除用户")
    public Result deleteUser(int id){
        try{
            return userService.deleteUser(id);
        }catch (Exception e){
            System.out.println(errorName+"##deleteUser##"+e.getMessage());
            return new Result();

        }
    }


}
