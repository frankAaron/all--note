# 聪明办法学python chap4：条件

## if语句：

通过缩进判断是不是在if里面

## if else：

if成立else就不管了

if不成立执行else

`x = int(input())`

##  if elif else:

平行依次判断：

if ():  

elif():

elif():

else:

## 语法糖：(推导式)

def (n):

return n if (n>= 0) else -n

等价于：

def (n):

​	if n >= 0:

​		return n

​	else:

​		return -n

## match case:

类似于switch语句

match <condition>:

​	case <action>:

​	case _:(除此之外其他的)：

注意：

第一个成立并不会直接退出需要用到break跳出循环

