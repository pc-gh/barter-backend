package com.transfar.controller;


import com.transfar.common.Result;
import com.transfar.entity.Comment;
import com.transfar.service.impl.CommentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "评论接口")
@RequestMapping("/comment")
public class CommentController {

    String errorName = "CommentController";

    @Autowired
    CommentServiceImpl commentService;

    @PostMapping(value = "/addComment",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("添加评论")
    public Result addComment(@RequestBody Comment comment){

        try{

            return commentService.addComment(comment);


        }catch(Exception e){
            System.out.println(errorName+"##addComment##"+e.getMessage());
            return new Result();
        }

    }

    @PostMapping(value = "/deleteComment/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("删除评论")
    public Result deleteComment(@PathVariable("id") int id){

        try{

            return commentService.deleteComment(id);
        }catch(Exception e){
            System.out.println(errorName+"##deleteComment##"+e.getMessage());
            return new Result();
        }

    }

    @GetMapping(value = "/getCommentList/{postId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("获取帖子评论列表")
    public Result getCommentList(@PathVariable("postId") int postId){

        try{

            return commentService.getCommentListByPostId(postId);
        }catch(Exception e){
            System.out.println(errorName+"##getCommentList##"+e.getMessage());
            return new Result();
        }

    }

    @PostMapping(value = "/editComment",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("修改评论(废弃)")
    public Result editComment(@RequestBody Comment comment){

        try{

            return commentService.editeComment(comment);
        }catch(Exception e){
            System.out.println(errorName+"##editeComment##"+e.getMessage());
            return new Result();
        }

    }




}
