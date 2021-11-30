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



#### 表设计

| 表名称 | 字段                                                         | 功能                 | 备注 |
| ------ | ------------------------------------------------------------ | -------------------- | ---- |
| user   | id,user_name,real_name,password,sex,tel,status               | 记录登录注册用户信息 |      |
| post   | id,user_id,easy_content,detail_context,create_time,modify_time,type,status | 记录帖子内容         |      |
| coment | id,user_id,post_id,easy_comment,detail_comment,create_time,status | 评论                 |      |



logo字体生成：

`http://www.diyiziti.com/Builder/`

墨刀原型：

`https://modao.cc/app/eb7193222e6c979b5cabaaaf4a30b54f744a94e5?simulator_type=device&sticky`

后端地址：

```
http://120.79.197.164:9285/barter/
```

1520*692



#### 优化日志

| 时间       | 任务                                                         | 完成情况                        | 备注              |
| ---------- | ------------------------------------------------------------ | ------------------------------- | ----------------- |
| 2021.11.19 | 添加跨域配置、添加根据用户名查找用户接口                     | 完成                            |                   |
| 2021.11.29 | <font color='red'>接入shiro认证授权功能</font>、后续增加帖子及评论总数接口 | <font color='red'>未完成</font> | 完成shiro接入配置 |
| 2021.11.30 | 新增帖子总数接口、新增根据帖子id评论总数接口、新增根据用户id评论总数接口新增根据用户id分页获取评论接口 | 完成                            |                   |
|            |                                                              |                                 |                   |
|            |                                                              |                                 |                   |
|            |                                                              |                                 |                   |



#### Q&A

* 页面跳转授权前段做还是后端做？

  后端做了那么前段的页面跳转是不是都要axios走后端接口？