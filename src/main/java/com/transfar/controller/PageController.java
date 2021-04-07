package com.transfar.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
@Api(tags = "页面跳转接口")
public class PageController {


//    @RequestMapping(value = "/index")
//    @ApiOperation(value = "/index")
//    public String default(){
//
//
//        return "index";
//    }

    @GetMapping(value = "/index")
    @ApiOperation("首页跳转")
    public String index(){


        return "index";
    }



    @GetMapping(value = "/login")
    @ApiOperation("登录页跳转")
    public String login(){


        return "login";
    }

    @GetMapping(value = "/register")
    @ApiOperation("注册页跳转")
    public String register(){


        return "register";
    }

    @GetMapping(value = "/mine")
    @ApiOperation("我的")
    public String mine(){


        return "mine";
    }


    @GetMapping(value = "/detail")
    @ApiOperation("帖子详情页跳转")
    public String detail(){


        return "detail";
    }

    @GetMapping(value = "/send_post")
    @ApiOperation("发帖")
    public String send_post(){


        return "send_post";
    }




}
