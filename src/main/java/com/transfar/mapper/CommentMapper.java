package com.transfar.mapper;

import com.transfar.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentMapper {

    //    查询
    List<Comment> getCommentByPostId(int id);
//    Comment getUserByUserName(String userName);

    //    删除
    int deleteByPrimeryKey(int id);
    int deleteByPostId(int postId);
    //    更新，修改帖子评论信息
    int update(Comment comment);
    int updateStatusById(Comment comment);
    int updateStatusByPostId(Comment comment);
    int updateStatusByUserId(Comment comment);

    //    插入，帖子
    int insert(Comment comment);


}
