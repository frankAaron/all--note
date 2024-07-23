# Python

## 2.1字面量

数字，字符串，列表，元组，集合，字典

## 2.2注释

#

## 2.3变量

记录数据变换

## 2.4数据类型

type()验证数据类型，能直接打印type()，也能将type的值存到变量中，也可以type变量

-   变量无类型，存储的数据有类型
-   有结果

## 2.5数据转换

万物皆可转字符串

浮点数转整数损失精度，不会四舍五入

## 2.6标识符

命名数字不可以用在开头，可以使用中文但是不推荐

不可以使用关键字（大小写敏感）

## 2.7算数运算符



global可以在函数内将局部变成全局

## 2.8列表中的方法

ndex查找列别中元素的下标索引

insert插入，第一个参数为插入位置（索引），第二个为更改的元素

append最后位置增加元素

extend在列表后追加一些元素

del指定下标

pop取出元素，可以接收，并在列表删除

remove第一个元素删除

clear清空列表

count计数

len

## 2.9字符串

index查找

replace（原，线），得到的是新的

split分割得到列表

strip去除前后的空格/字符串（多个子/分割成多个），默认是空格

## 3.0集合

pop随机取出一个元素

集合字典非序列类型不支持下标索引

*args 传入任意长度的参数结果为元组

**kwargs传入必须以字典传入key：value

函数里面调用函数，

### 文件I/O

```
file object = open(file_name [, access_mode][, buffering])
```

- file_name：file_name变量是一个包含了你要访问的文件名称的字符串值。

- access_mode：access_mode决定了打开文件的模式：只读，写入，追加等。默认文件访问模式为只读(r)。

- buffering:如果buffering的值被设为0，就不会有寄存。如果buffering的值取1，访问文件时会寄存行。如果将buffering的值设为大于1的整数，表明了这就是的寄存区的缓冲大小。如果取负值，寄存区的缓冲大小则为系统默认。

  

一边循环一边计算的机制，称为生成器：generator，如果一个函数定义中包含`yield`关键字，那么这个函数就不再是一个普通函数，而是一个generator函数，调用一个generator函数将返回一个generator

open打开文件

read方法，第二次会从上一次的结果继续

readline（s）读取一行（每一行作为一个元素作为列表）

close关闭文件解除文件的占用

with open as f：  自动将文件关闭

write写入

flush刷新写入

## json

json是一种转换方式，将一种语言转换成其他语言

jsomn无非就是单独的字典或者一个内部元素都是字典的列表

>   import json

ensure——ascii=False将ascii转化为汉字

dumps将python转化为json

loads将json转换为python       字符串准换成列表

## 类型注解

变量：类型

函数注解

def f(x:int) -> int:          

### 多态

多种状态

父类确定方法，子类确定行为（具体实现）

理解为一种标准，

科学计数法E

spark全球顶尖分布式计算框架

