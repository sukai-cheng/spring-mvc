create table user
(
    user_id   bigint auto_increment comment '用户ID'
        primary key,
    user_name varchar(30)  not null comment '用户账号',
    pass_word varchar(255) not null comment '密码'
)
    comment '用户信息表';

INSERT INTO mes.user (user_name, pass_word)
VALUES ('admin', 'admin123')
