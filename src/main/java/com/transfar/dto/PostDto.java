package com.transfar.dto;

import com.transfar.entity.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("帖子查询分页参数类")
public class PostDto{

    @ApiModelProperty("帖子标题")
    String title;
    @ApiModelProperty("用户id")
    Integer userId;
    @ApiModelProperty("当前页数")
    int pageNum;
    @ApiModelProperty("页面大小")
    int pageSize;
}
