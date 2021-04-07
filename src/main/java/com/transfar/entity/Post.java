package com.transfar.entity;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String easyContext;
    private String detailContext;
    private String createTime;
    private String modifyTime;
    private String type;
    private Integer status;
}
