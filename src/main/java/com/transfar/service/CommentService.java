package com.transfar.service;


import com.transfar.common.Result;
import com.transfar.entity.Comment;

public interface CommentService {
    Result addComment(Comment comment);
    Result editeComment(Comment comment);
    Result deleteComment(int id);
    Result getCommentListByPostId(int postId);
}
