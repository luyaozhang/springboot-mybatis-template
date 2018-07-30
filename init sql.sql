drop table loginuser;
CREATE TABLE `loginuser` (
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `workgroup` varchar(20) DEFAULT NULL COMMENT '组别',
  `privilege` int(11) DEFAULT NULL COMMENT '权限',
  `datachange_lasttime` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  PRIMARY KEY (`username`),
  UNIQUE KEY `loginuser_name_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录用户组';
)

drop table book;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '书名',
  `price` double DEFAULT NULL COMMENT '单价',
  `sellnum` int(11) DEFAULT NULL COMMENT '销量',
  `datachange_lasttime` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='书籍';

select * from loginuser;
select * from user;
select * from book;

show variables like '%char%';

insert into loginuser values('luyao','123','客服',1,'2018-10-10');
insert into book values(2,'哈哈',23,5,'2018-06-10');
insert into book values(3,'book3',23,7,'2018-06-10');
insert into book values(4,'book4',23,5,'2018-06-10');


















