package com.transfar.dto;

import com.transfar.entity.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("评论分页查询参数类")
public class CommentDto{
    @ApiModelProperty("帖子id")
    Integer postId;
    @ApiModelProperty("当前页数")
    int pageNum;
    @ApiModelProperty("用户id")
    int userId;
    @ApiModelProperty("页面大小")
    int pageSize;
}
