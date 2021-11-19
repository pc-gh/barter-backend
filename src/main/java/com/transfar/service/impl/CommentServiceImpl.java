package com.transfar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.transfar.common.Result;
import com.transfar.dto.CommentDto;
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
    public Result getCommentListByPostId(CommentDto commentDto) {
        PageHelper.startPage(commentDto.getPageNum(),commentDto.getPageSize());
        List<Comment> commentList = commentMapper.getCommentByPostId(commentDto.getPostId());
        System.out.println("CommentServiceImpl-getCommentListByPostId-commentList:"+commentList.toString());
        if(commentList.size()>0){

            return new Result(200,commentList,"success");
        }
        return new Result();
    }
}
