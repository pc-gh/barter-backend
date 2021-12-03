package com.transfar.vo;

import com.transfar.entity.Comment;
import lombok.Data;

/**
 * @author zb
 * @version 1.0
 * @date 2021/12/3 10:33
 * @desc TODO
 */

@Data
public class CommentVo extends Comment {
    private String userName;
}
