#  建立项目数据库的表
#  Module One  权限模块
#    airsys_user
#    airsys_role
#    airsys_resource

#   Module Two   人资模块[其实并没有统一的标准，就是根据实际情况设置表]
#   ...
#   ...

#  Module Tree  行政模块[考勤管理 行政管理 车辆管理  办公用品管理]
#  ...
#  ...

# 例子模块  仅有一张表
create table  t_user{
       id int primary key auto_increment,
       name varchar(50) not null,
       pwd  varchar(100),
       age int,      
       birth date
};
  create table if not exists user(
     id int primary key auto_increment,
       name varchar(50) not null,
      age integer
      );







