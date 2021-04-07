# 壹無

idea：壹無（易物），barter。

风格：繁体古风。

logo：双手相扣。

用户身份：普通用户、管理员。

功能：以物易物的论坛。看帖（评论、点赞）、发帖、我的。

模块：看、写（删）、我（与我相关帖）。

页面设计：主要页面设计为top+button+content。

价值：闲置物品重新利用，提高资源利用率，响应供给侧改革。

技术方案：`springboot+mybatis+html->bootstrap`。



表设计：

| 表名称 | 字段                                                         | 功能                 | 备注 |
| ------ | ------------------------------------------------------------ | -------------------- | ---- |
| user   | id,user_name,real_name,password,sex,tel,status               | 记录登录注册用户信息 |      |
| post   | id,user_id,easy_content,detail_context,create_time,modify_time,type,status | 记录帖子内容         |      |
| coment | id,user_id,post_id,easy_comment,detail_comment,create_time,status | 评论                 |      |



logo字体生成：

`http://www.diyiziti.com/Builder/`

墨刀原型：

`https://modao.cc/app/eb7193222e6c979b5cabaaaf4a30b54f744a94e5?simulator_type=device&sticky`



1520*692