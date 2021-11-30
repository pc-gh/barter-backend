package com.transfar.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.transfar.dto.PostDto;
import com.transfar.entity.Post;
import com.transfar.common.Result;
import com.transfar.service.PostService;
import com.transfar.service.impl.PostServiceImpl;
import com.transfar.utils.TimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "帖子接口")
@RequestMapping("/post")
public class PostController {

    String errorName = "PostController";
    @Autowired
    PostServiceImpl postServiceImpl;

    @ApiOperation("上传帖子")
    @PostMapping(value = "/addPost",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result addPost(@RequestBody Post post){
        try{
            System.out.println(post.toString());
            return postServiceImpl.addPost(post);
        }catch (Exception e){

            System.out.println(errorName+"##PostController##addPost##"+e.getMessage());
            return new Result();
        }
    }

    @ApiOperation("编辑帖子")
    @PostMapping(value = "/editPost",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result editPost(@RequestBody Post post){
        try{
            return postServiceImpl.editPost(post);
        }catch (Exception e){
            System.out.println(errorName+"PostController##editPost##"+e.getMessage());
            return new Result();
        }
    }


    @ApiOperation("删除帖子")
    @PostMapping(value = "/deletePost/{postId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result deletePost(@PathVariable("postId") int postId){
        try{
            return postServiceImpl.deletePost(postId);
        }catch (Exception e){
            System.out.println(errorName+"PostController##deletePost##"+e.getMessage());
            return new Result();
        }
    }

    @PostMapping(value = "/getPostList",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("获取帖子")
    public Result getPostListByUserId(@RequestBody PostDto postDto){
        try{
            return postServiceImpl.getPostListByUserId(postDto);

        }catch (Exception e){
            System.out.println(errorName+"PostController##getPostListByUserId##"+e.getMessage());
            return new Result();

        }

    }

    @ApiOperation("标题模糊搜索帖子")
    @PostMapping(value = "/getPostListByTitle",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result getPostListByTitle(@RequestBody PostDto postDto){
        try{
            return postServiceImpl.getPostListByTitle(postDto);
        }catch (Exception e){
            System.out.println(errorName+"PostController##getPostListByTitle##"+e.getMessage());
            return new Result();
        }

    }

    @ApiOperation("获取帖子总数")
    @GetMapping(value = "/getTotalCount",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result getTotalCount(){
        try{
            return postServiceImpl.totalCount();
        }catch (Exception e){
            System.out.println(errorName+"PostController##getTotalCount##"+e.getMessage());
            return new Result();
        }
    }

}
