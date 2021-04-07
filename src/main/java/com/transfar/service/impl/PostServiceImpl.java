package com.transfar.service.impl;

import com.transfar.common.Result;
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
    public Result getPostListByUserId(int userId) {

        List<Post> postList = postMapper.getPostListByUserId(userId);
<<<<<<< HEAD
        if (postList.size()>0){
=======
        if (postList!=null){
>>>>>>> 5a59ffc706500563eb6d6949433453e0a171913c
            return new Result(200,postList,"success");
        }

        return new Result();
    }

    @Override
    public Result getPostListByTitle(String title) {
        List<Post> postList = postMapper.getPostListByTitle(title);
<<<<<<< HEAD
        if(postList.size()>0){
=======
        if(postList!=null){
>>>>>>> 5a59ffc706500563eb6d6949433453e0a171913c
            return new Result(200,postList,"success");

        }
        return new Result();
    }
}
