package com.transfar.entity;


import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private String easyComment;
    private String detailComment;
    private String createTime;
    private Integer status;
}
