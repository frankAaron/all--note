## MySql启动：

```
net start mysql80
net stop mysql80
mysql -u root -p
```



注释

 -- 



## DDL

数据定义     分号

### 数据库操作

-   查询
    -   show database();    // 查询所有数据库
    -   select database();    //查询当前数据库
-   创建
    -   creat database
-   删除
    -   drop database
-   使用
    -   use 数据库名

### 表操作   

-   查询
    -   show  tables  查询当前数据库所有表
    -   desc       查询表结构
    -   show create table  表名

-   创建
    -   create table 表名（   id   int      ，    ，    ）  [comment   ]；
-   修改
    -   alter   table  表名 add 字段名  类型  
    -   alter   table  表名 modify 字段名  类型  //修改数据类型
    -   alter   table  表名 change 旧字段名   新字段名 类型
    -   alter  table  表名  drop  字段名
    -   alter table  rename to  新表名
-   删除
    -   drop table 表名
    -   truncate  table  表名  // 删除并重新创建

### 数据类型

-   数值类型
    -   tinyint
    -   int
    -   float
    -   double（位数，小数点几位）

-   字符串类型
    -   char        知道长度
    -   varchar  不知道确定长度

-   时间类型
    -   date			年月日
    -   time            时分秒
    -   datetime   YYYY-MM-DD   HH-MM-SS

## DML

操作表里面的

-   添加
    -   insert into  表名（字段）   values  （值1）
    -   insert  into 表名   values
-   删除
    -   delete  from
-   改
    -   update  表名 set  字段1 = 值1，字段2=值2

## DQL

语法

```sql
select distinct{去重}  聚合函数（查询内容） as  '别名'  from   表名   where 条件 group by  分组   having  分组条件   order  by  排序  limit 起始索引，查询记录数  
```

### 条件

![](image/%E6%9D%A1%E4%BB%B6%E8%BF%90%E7%AE%97%E7%AC%A6.png)

### 聚合函数

作用某一列

null不计算

![](image/%E8%81%9A%E5%90%88%E5%87%BD%E6%95%B0.png)

分组查询

-   where
    -   优先执行，不满足则不分组

-   having
    -   可以使用聚合函数

where>聚合函数>having

### 排序查询

-   asc升序  默认
-   desc降序

多字段排序，第一个字段值相同，再按照第二个字段进行排序

### 分页查询  limit

从0开始，类似于数组

起始索引 = （ 页 - 1）- 每页展示的记录

### 执行顺序

from -> where -> group by -> select ->having ->order by-> limit   

**根据执行顺序可得from后起的表的别名必须使用，即起别名后剩下的语句调用表时只能用别名**

## DCL

-   查询用户
    -   select \* from user
-   创建用户
    -   create user ' 用户名‘@’主机名' identified by ‘密码’
-   修改用户名密码
    -   alter user ' 用户名‘@’主机名'  identified with mysql_native_password by ‘新密码’
-   删除用户
    -   drop user ' 用户名‘@’主机名' 

-    权限控制
    -   查询权限
        -   show grants for ' 用户名‘@’主机名' 
    -   授予权限
        -   grant 权限列表 on 数据库.表名  to ' 用户名‘@’主机名' 
    -   撤销权限
        -   revoke  权限列表 on 数据库.表名  from ' 用户名‘@’主机名' 

权限列表![](image/%E6%9D%83%E9%99%90%E6%8E%A7%E5%88%B6.png)

## 函数

### 字符串函数

类似于聚合函数

位于select后

![](image/%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%87%BD%E6%95%B0.png)

substring  中start起始值为1

### 数值函数

![](image/%E6%95%B0%E5%80%BC%E5%87%BD%E6%95%B0.png)

###  日期函数

![](image/%E6%97%A5%E6%9C%9F%E5%87%BD%E6%95%B0.png)

### 流程函数

![](image/%E6%B5%81%E7%A8%8B%E5%87%BD%E6%95%B0.png)

## 约束

-   非空约束    ---not null
    -   字段数据不能为null
-   唯一约束    ---unique
    -   数据是唯一的，不可重复
-   主键约束    ---primary key
    -   唯一标识
-   默认约束    ---default
    -   采用默认值
-   检查约束    ---check
    -   保证字段满足条件
-   外键约束    ---foreign key
    -   两张表的连接
    -   alter table 表名 add constraint 外键名foreign key(外键字段) referneces主表（列名）
    -   alter table 表名 dropforeign key外键名
    -   alter table 表名 add constraint 外键名foreign key(外键字段) referneces主表（列名）on update cascade[表] on delete cascade;

![](image/%E5%A4%96%E9%94%AE%E5%88%A0%E9%99%A4%E6%88%96%E8%80%85%E6%9B%B4%E6%96%B0%E7%9A%84%E8%A1%8C%E4%B8%BA.png)

## 多表查询

### 一对多

多的一方建立外键，关联一的主键

### 多对多

建立中间表（公共属性）分别关联他们的主键（特有属性）

### 连接查询

-   内连接     交集
    -   隐式内连接   （先做笛卡尔积，过滤）
        -   select   字段列表 from 表1，表2 where  条件
    -   显式内连接  （优先，性能好  先看条件再连接）
        -   select 字段列表   from  表1  join 表2   on   条件
-   外连接         （两个连接可以相互转化）
    -   左外连接   查询左表所有数据+交集   （表1在左，表2在右）
        -   select  字段  from  表1  left  join  表2 on 条件
    -   右外连接    查询右表所有数据+交集
        -   select  字段  from  表1 right  join  表2 on 条件
-   自连接
    -   自己和自己连接，起别名
        -   select  __ from  表1  join 表2 on 条件

### 子查询
