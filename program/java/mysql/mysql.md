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
    -   ```
        alter table 表名 add constraint 外键名foreign key(外键字段) referneces主表（列名）on update cascade[表] on delete cascade;
        ```
    -   ![](image/%E5%A4%96%E9%94%AE%E5%88%A0%E9%99%A4%E6%88%96%E8%80%85%E6%9B%B4%E6%96%B0%E7%9A%84%E8%A1%8C%E4%B8%BA.png)

## 多表查询

### 一对多

多的一方建立外键，关联一的主键

### 多对多

建立中间表（公共属性）分别关联他们的主键（特有属性）

### 连接查询

-   内连接     **交集**
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
    
    -   联合查询
        -   多次查询结果合并   union   / union  all 会去重
        -   select  字段列表 from 表 a   **union**  select  字段列表 from b

### 子查询/ 嵌套查询

selcet    from  表1where column1  = （select  column1 from 表2）

-   标量子查询
    -   返回值为单个值
-   列子查询
    -   返回值为一列
        -   in
        -   not in
        -    any   满足一个即可
        -   some  跟any等同
        -   all    全满足
-   行子查询
    -   返回值为一行
        -   运算符
-   表子查询
    -   返回值为表   in

## 事务

操作集合，要么同时成功，要么同时失败

### 事务操作

-   设置提交方式

-   ```
    autocommit  1为自动提交，0为手动提交
    select  @@autocommit;
    set  @@autocommit=0;
    ```

-   提交事务

-   ```
    commit；
    ```

-   回滚事务

-   ```
     rollback
    ```

开启事务

​	start transaction

提交事务

commit

回滚事务

rollback

### 事务四大特性ACID

-   原子性
    -   事务不可分割，要么全部成功，要么全部失败
-   一致性
    -   数据一致
-   隔离性
    -   依赖隔离机制，事务之间不相互影响
-   持久性
    -   事务提交或者回滚会永久保存

### 并发事务问题

-   脏读
    -   一个事务读到另一个事务没有提交的数据
-   不可重复读
    -   一个事务读取同一条记录，但是两次读取的数据不同
-   幻读
    -   一个事务按照条件查询数据，没有对应的数据行，但是插入数据时，发现数据已经存在

### 隔离级别

-   read uncommitted
-   read commit
-   repeatable read  默认
-   serializable

查看事务级别

select @@transaction_isolation

设置事务级别

set session transaction  isolation level  隔离级别

## 存储引擎

### mysql体系结构

![](image/mysql%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.png)

### 存储引擎简介

存储引擎是存储数据，建立索引，更新/查询数据等技术的实现方式

存储引擎是基于表的      ---表类型

engine  默认innodb

### 存储引擎特点

#### innoDB

##### 特点

-   DML操作ACID模型，支持事务
-   行级锁，提高并发访问性能
-   支持外键约束

##### 文件

**.idb **  不能直接打开

##### 逻辑存储结构

表空间   ---    段   ---   区（1M）   ---   页（16k）   ---   行

![](image/InnoDB%E9%80%BB%E8%BE%91%E5%AD%98%E5%82%A8%E7%BB%93%E6%9E%84.png)

#### MyISAM

##### 特点

不支持事务，不支持外键

支持表锁，不支持行锁

访问速度快

##### 文件

sdi  表  ，能直接打开

myd   存储数据

myi   存储索引

#### Memory

由于数据存储在内存中，由于受到硬件和断电问题，只能将这些表作为临时表或缓存使用

#### 特点

内存存放

hash索引

#### 文件

sdi存储表结构信息

![](image/%E5%AD%98%E5%82%A8%E5%BC%95%E6%93%8E%E5%8C%BA%E5%88%AB.png)

### 选择

 InnoDB     处理事务，并发条件下要求数据一致

MyISAM	（读操作和插入操作）更新删除操作较少

MEMORY	访问速度快，无法缓存在内存中，无法保证数据安全

## 索引

有序数据结构，高效获取数据

### 优点

提高数据检索的效率，降低成本

降低数据排序成本，降低cpu消耗

### 缺点

占用磁盘空间

增删改效率低

### 索引结构

在存储引擎层实现，默认b+tree

![](image/%E7%B4%A2%E5%BC%95%E7%BB%93%E6%9E%84.png)

### B树

几阶几个指针，-1个key

![](image/b%E6%A0%91.png)

### B+树

所有数据都出现在叶子节点（单项链表），非叶子节点起到索引作用

![](image/b+%E6%A0%91.png)

### hash

利用hash算法，将键值换算成hash值，映射到槽位上

![](image/InnoDB%E4%BD%BF%E7%94%A8B+.png)

### 分类

|   分类   |         含义         |           特点           |  关键字  |
| :------: | :------------------: | :----------------------: | :------: |
| 主键索引 | 根据表中主键创建索引 | 默认自动创建，只能有一个 | primary  |
| 唯一索引 |    避免数据列重复    |        可以有多个        |  unique  |
| 常规索引 |   快速定位特定数据   |        可以有多个        |          |
| 全文索引 |    查找文本关键字    |        可以有多个        | fulltext |

| 分类     | 含义                                         | 特点         |
| -------- | -------------------------------------------- | ------------ |
| 聚集索引 | 数据存储与索引在一起，叶子节点保存**行数据** | 必须只有一个 |
| 二级索引 | 数据与索引分开，叶子节点关联主键             | 可以有多个   |

#### 选取规则

-   有主键   主键是聚集
-   无主键    第一个唯一索引
-   无主键，无唯一索引   自动生成

#### 回表查询

二级索引查聚集索引数据，聚集索引导出数据

### 语法

-   创建索引
    -   create 关键字 index  index_name on table_name(id,...联合索引)  
-   查看索引
    -   show  index from  table_name
-   删除索引
    -   drop index index_name on table_name

### SQL性能分析

#### SQL执行频率

show [session |   global ] status  (like)   增删改查

#### 慢查询日志

记录表所有执行时间超过默认10秒的所有SQL语句日志

show  variables  like 'slow_query_log'   查看是否开启

>   **/etc/my.cnf**

slow_query_log = 1 开启慢查询

long_query_time=2   SQL语句执行时间

#### profile

select  @@have_profiling; 看到是否支持profile操作

select @@profiling  查看是否开启

set  profiling = 1    打开开关

show  profiles;

show  profiles (cpu) for query query_id

#### explain执行计划

位于DML之前

explain  select  ……

-   id
    -   执行select子句或者操作表的顺序  id相同，执行顺序从上到下，id不同，值越大，越先执行
-   select_type
    -   表示slect类型
-   type
    -   连接类型，性能由好到坏（NULL不经过表、system、const、eq_ref、range、index、all  全表扫描）
-   possible_key
    -   可能用到的索引
-   Key
    -   实际使用索引，如果为NULL，没有使用索引
-   Key_len
    -   索引中使用的字节数
-   rows
    -   必须要执行的查询的函数，不准确
-   filtered
    -   返回结果的行数占需求读取函数的百分比

### 索引使用

#### 最左前缀法则

查询从索引的最左列开始，并且不跳过索引中的列，如果跳过某一列，**索引将部分失效（后面的索引失效）**

例如：（abc）

建立这样的索引相当于建立了索引a、ab、abc三个索引

#### 范围查询

联合索引中，出现范围查询（<，>），范围查询右侧的列索引失效

#### 索引列运算

在索引列上进行运算操作，索引将失效

#### 字符串不加引号

字符串类型字段使用时不加引号，索引失效

#### 模糊查询

尾部模糊，索引不失效，头部模糊将失效

#### or连接的条件

用or分开，如果or前的条件中的列有索引，后面的列中没有索引，那么涉及的索引都不会被用到（只要有一侧没有就么没有）

#### 数据分布影响

如果MySQL评估使用索引比全表满，则不适用索引------->回表查询也需要时间，所以不走索引

#### SQL提示

在SQL语句中加入认为提示达到优化目的

当一个字段既有联合索引又有单独索引sql默认用联合索引

use index;    	//告诉数据库用  （建议）---->mysql评估速度

```mysql
EXPLAIN SELECT * FROM TB_USER USE INDEX() WHERE 
```

ignore index;   //告诉数据库不用

```mysql
EXPLAIN SELECT * FROM TB_USER IGNORE INDEX() WHERE 
```

force index		//高速数据库必须用

```mysql
EXPLAIN SELECT * FROM TB_USER FORCE INDEX() WHERE 
```

#### 覆盖索引

查询使用索引，并且需要返回的列----> 在该索引中已经全部能找到，减少select  \* 

using  index condition   查找使用索引，需要回表查询

using where ；using index ：查找使用索引，需要的数据在索引中能找到，不需要回表查询

#### 前缀索引

![](image/%E5%89%8D%E7%BC%80%E7%B4%A2%E5%BC%95.png)

#### 单列索引与联合索引

单列索引：一个索引只包含单个列

联合索引：一个索引包括多个列

### 索引设计原则

1.  针对于数据量较大，且查询比较频繁的表建立索引
2.  针对常作为查询条件，排序，分组操作的字段建立索引
3.  尽量选择区分度高的列作为索引，尽量建立唯一索引，区分度高，使用索引的效率高
4.  字符串类型的字段，字段的长度较长，可以针对于字段的特点，建立前缀索引
5.  尽量使用联合索引，减少单列索引，查询时，联合索引可以覆盖索引，节省存储空间，避免回表查询，
6.  控制索引的数量，索引并不是多多益善，索引越多，维护索引结构的代价也就越大，影响增删改查
7.  如果索引列不能存储NULL值，请在创建表时使用NOT NULL约束。当优化器知道每列是否包含NULL值时，它可以更好的确定哪个索引最有效的用于查询

## SQL优化

### 插入数据

#### insert优化

![](image/insert%E4%BC%98%E5%8C%96.png)

#### 大批量插入数据

如果一次性插入大批量数据可以是使用load指令进行插入

mysql --local-infile -u root -p //客户端连接服务器，加上参数

set global local_infile =1   //设置全局参数为1，开启从本地加载文件导入数据的开关

load data local infile '/root/sql1.log' into table 'tb_user' fields terminated by ',' lines terminated by '\n'		//执行load指令将准备好的数据，加载到表结构中

### 主键优化

#### 数据组织方式

在InnoDB储存引擎中，表数据都是根据主键顺序组织存放，这种存储方式称为索引组织表

#### 页分裂

页可以为空，也可以填充一半，也可填充100%，每个页包含2-N行数据（如果一行数据多大，会溢出），根据主键排列

![](image/%E9%A1%B5%E5%88%86%E8%A3%82.png)
