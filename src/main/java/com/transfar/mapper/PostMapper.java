package com.transfar.mapper;


import com.transfar.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.transfar.entity.Post;

import java.util.List;

public interface PostMapper {

    //    查询
    Post getPostByPrimeryKey(int id);
    List<Post> getPostListByTitle(String title);
    List<Post> getPostListByUserId(int id);

    //    删除
    int deleteByPrimeryKey(int id);
    //    更新，修改帖子信息
    int update(Post post);
    int updateStatusById(Post post);
    int updateStatusByUserId(Post post);

    //    插入，注册新增用户
    int insert(Post post);

//    获取总帖子数
    int totalCount();

}
