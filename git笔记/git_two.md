## git标签管理

标签方便查找

git tag 标签名，创建标签

git tag查看标签

git tag 标签名 commit对应的号码，可以补标签

git show 标签名 查看标签信息

-a指定标签名，-m指定说明文字，标签的说明

git tag -a 标签名 -m "  "`可以指定标签信息

git push origin 标签名（tags），推送某个（全部）标签到远程

git tag -d 标签名，删除一个本地标签

git push origin :refs/tags/标签名，删除一个远程标签

注：先删本地在远程

## Linux

##### locate

###### 快功能单一只能搜索文件名

找不到新命令（在数据库搜索mlocate一天一次刷新）

updatedb强制更新 

###### whoami我在哪

###### whatis

###### which命令执行的位置/别名位置

###### whereis 搜索命令的命令

cd，找不到内置命令shell的内置

依赖环境变量$PATH

##### find 精确查询文件名

find	

字符串搜索命令遍历

不区分大小写

find /root -nouser检查是否是所有者以便删除垃圾文件

外来数据 proc和sys除外

find /var/log -mtime +10查找10天前修改的文件

-10 10天内修改的文件

//10 10天当天修改的文件

+10 10天前修改的文件

atime 文件访问时间

ctime 改变文件属性

mtime 修改文件内容

find . size 25k文件大小25k

k小写 M大写 不加单位也不行

-25k小于

25k等于

+25k大于

-a逻辑与，两个条件都满足

-o或

-exec ls -lh {}\;  执行并显示详细信息

例如find /etc -size +20k -a -size -50k -exec ls -lh{}\;基本格式

###### i节点

ls -i 文件名

find查询文件名，利用i节点

###### 通配符  搜索含糊的文件

*任意内容

？任意一个字符

a【mn】任意一个中括号内的字符am，an

” “加上便于通配符的识别

###### grep命令

搜索字符串

-v取反

-i忽略大小写

包含匹配只要有就可以

正则表达式

##### 帮助命令

###### man

man 命令名称

-f passwd 

man -f相当于whatis

man -5 passwd

man -4 null

man -8 ifconfig

###### --help 

专门获取shell 内部命令帮助

whereis  看是不是内部命令

###### infor

获取详细命令（所有命令）

-u 进入上层界面

-n 进入下一个帮助小节

-p 进入上一个帮助小节

-q 退出

##### 压缩解压文件目录

###### .zip

格式：zip 名字.zip 文件名

压缩文件不一定比原文件小

zip -r 目录（mkdir出来的).zip 目录名

解压缩      unzip 文件名.zip

###### .gzp

gzip 源文件 压缩文件并删除源文件

gizp -c 文件> 压缩文件

 gzip -r 压缩目录下方的文件不推荐使用

解压缩 gunzip -d 压缩文件

​             gunzip  压缩文件

###### .bzip2 

bzip 文件

bzip -k 文件保留源文件

bzip -d 解压缩

bunzip -k

###### tar

tar -cvf 打包文件名 源文件

-c打包

-v显示过程

-f指定打包后的文件名

##### 关机或者重启

#####  shutdown安全

-c:取消关机

-h关机

-r重启

ctrl c：

reboot重启

init 5 启动图形界面

runlevel 查询运行等级

X代表图形界面

养成习惯正确退出：logout注销





 



