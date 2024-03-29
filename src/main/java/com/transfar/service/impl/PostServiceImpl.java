package com.transfar.service.impl;

import com.github.pagehelper.PageHelper;
import com.transfar.common.Result;
import com.transfar.dto.PostDto;
import com.transfar.entity.Comment;
import com.transfar.entity.Post;
import com.transfar.mapper.CommentMapper;
import com.transfar.mapper.PostMapper;
import com.transfar.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    PostMapper postMapper;
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Result addPost(Post post) {
        int l = postMapper.insert(post);
        if(l>0){
            return new Result(200,l,"success");
        }
        return new Result();


    }

    @Override
    public Result editPost(Post post){
        int l = postMapper.update(post);
        if(l>0){

            return new Result(200,l,"success");
        }
        return new Result();
    }

    @Override
    public Result deletePost(int postId) {
//        int l = postMapper.deleteByPrimeryKey(id);
//        int t = commentMapper.deleteByPostId(id);

        Comment comment = new Comment();
        Post post = new Post();

        comment.setPostId(postId);
        comment.setStatus(0);

        post.setId(postId);
        post.setStatus(0);
            int t = postMapper.updateStatusById(post);
            int l = commentMapper.updateStatusByPostId(comment);
            if (t>0) {
                return new Result(200, t, "success");

            }

            return new Result();

        }

    @Override
    public Result getPostListByUserId(PostDto postDto) {

        PageHelper.startPage(postDto.getPageNum(),postDto.getPageSize());
        List<Post> postList = postMapper.getPostListByUserId(postDto.getUserId());
        if (postList.size()>0){
            return new Result(200,postList,"success");
        }

        return new Result();
    }

    @Override
    public Result getPostListByTitle(PostDto postDto) {

        PageHelper.startPage(postDto.getPageNum(),postDto.getPageSize());
        List<Post> postList = postMapper.getPostListByTitle(postDto.getTitle());
        if(postList.size()>0){
            return new Result(200,postList,"success");

        }
        return new Result();
    }

    @Override
    public Result totalCount(){

        int count = postMapper.totalCount();
        if(count>0){
            return new Result(200,count,"success");
        }

        return new Result();

    }

    @Override
    public Result getPostByPostId(int postId){
        Post postByPostId = postMapper.getPostByPrimeryKey(postId);
        if(postByPostId!=null){
            return new Result(200,postByPostId,"success");

        }

        return new Result();

    }
}
