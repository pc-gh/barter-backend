package com.transfar.service.impl;

import com.transfar.common.Result;
import com.transfar.entity.Comment;
import com.transfar.mapper.CommentMapper;
import com.transfar.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Result addComment(Comment comment) {
        int l = commentMapper.insert(comment);
        if (l>0){
            return new Result(200,l,"success");
        }

        return new Result();
    }


    @Override
    public Result editeComment(Comment comment) {
        int l = commentMapper.update(comment);
        if(l>0){
            return new Result(200,l,"success");

        }
        return new Result();
    }

    @Override
    public Result deleteComment(int id) {
//        int l = commentMapper.deleteByPrimeryKey(id);
        Comment comment = new Comment();
        comment.setId(id);
        comment.setStatus(0);
        int l = commentMapper.updateStatusById(comment);
        if (l>0){

            return new Result(200,l,"success");
        }

        return new Result();
    }

    @Override
    public Result getCommentListByPostId(int postId) {
        List<Comment> commentList = commentMapper.getCommentByPostId(postId);
        if(commentList.size()>0){
            return new Result(200,commentList,"success");

        }

        return new Result();
    }
}
