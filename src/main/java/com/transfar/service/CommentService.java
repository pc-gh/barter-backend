package com.transfar.service;


import com.transfar.common.Result;
import com.transfar.dto.CommentDto;
import com.transfar.entity.Comment;

public interface CommentService {
    Result addComment(Comment comment);
    Result editeComment(Comment comment);
    Result deleteComment(int id);
    Result getCommentListByPostId(CommentDto commentDto);
    Result totalCountByPostId(int postId);
    Result getCommentListByUserId(CommentDto commentDto);
    Result totalUserCommentCount(int userId);
}
