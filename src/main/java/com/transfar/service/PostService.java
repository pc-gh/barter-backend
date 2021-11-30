package com.transfar.service;

import com.transfar.common.Result;
import com.transfar.dto.PostDto;
import com.transfar.entity.Post;

import java.util.List;

public interface PostService {

    Result addPost(Post post);
    Result editPost(Post post);
    Result deletePost(int id);
    Result getPostListByUserId(PostDto postDto);
    Result getPostListByTitle(PostDto postDto);
    Result totalCount();

}
