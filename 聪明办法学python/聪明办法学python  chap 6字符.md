# 聪明办法学python  chap 6字符

## 四种引号：

单引号，双引号区分不大

两种引号可以在打印中打印出引号；

三引号：写多好，注释

## 换行号

- \转义字符    \n代表换行 也可以在多行print时打\来排除换行保持美观

  双引号\ ""  

## repr and print：

输出看起来一样，实际却不一样repr可以识别转义的字符(”里面的全部内容“)

## 字符串常量运算：

import string

ascii_letters：26个字母小写和大写一次打出

ascii_lowercase只打印小写

ascii_uppercase只打印大写

digits：0-9一次打印

printable：0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~

whitespace：' \t\n\r\x0b\x0c'

字符相加(相接)，相乘(复制几次)

in 判断字符串是不是在另一个里面

## 索引切片：

索引找位置

[]  左闭右开   默认参数0    第三个参数step步长

翻转字符串[::-1]   join函数  join(reverse())

enumerate获得元素的序号

zip(a,b)

`for a,b in zip(s,s2)`分别给a，b

split ()自动产生列表,但不储存

splitlines()  按行输出

## 强制转换：

str(input())

## 库函数

len()    获取字符串长度

chr()    ASCLL对应字符

ord()    字符对应的ASCLL值

eval执行算法，有风险

import ast        ast.

isalnum  判断字符（非字符true）

isalpha  判断是否全是字母（全是并且不区分大小写true）

isdigit    判断是否全是数字（全是true）

islower  是否是小写（小写true）

isspace  判断是否是空格  （是true）

isupper 判断是否是大写 （有大写true）

.strip()去除头尾的空格

.replace 换 

.count 记录出现次数 区分大小写

.startswith（）判断开头是否是  end

,find 找到对应的索引

.index  与find一样

`Open()` 函数

Python `open()` 函数用于打开一个文件，并返回文件对象，在对文件进行处理过程都需要使用到这个函数。

`open(file, mode)` 函数主要有 `file` 和 `mode` 两个参数，其中 `file` 为需要读写文件的路径。`mode` 为读取文件时的模式，常用的模式有以下几个：

- `r`：以字符串的形式读取文件。
- `rb`：以二进制的形式读取文件。
- `w`：写入文件。
- `a`：追加写入文件。

**文件对象**

`open` 函数会返回一个 文件对象  需要close才能执行下一次

- `close( )`: 关闭文件
- 在r与rb模式下：
  - `read()`: 读取整个文件
  - `readline()`: 读取文件的一行
  - `readlines()`: 读取文件的所有行
- 在w与a模式下：
  - `write()`:
  - `writelines()`:

import with

with open 不需要close