# C语言：基本语法，数据类型：

- ## 基本语法

- ## 数据类型

- ## 变量

## 基本语法：

### 正常运行要有：

关键字，标识符，常量，字符串

例如：`printf("hello,world\n")`

### 注释：

- 为了方便知道代码的作用以便自己或者读者更好的读取代码

- //表示单行注释
- /* */在这个范围内都会被注释用于多行注释

### 空格：

- 为了增加可读性，需要一些空格，例如`a=1`为了增加可读性可以写成：`a = 1`
- 但是像定义变量的那种需要空格来区分，例如：`int a`

### 标识符：

用来命名的，大小写有区分，可以用数字字母下划线，但是不能用标点：@&￥

### 关键字：(打多了便认识了)

- break跳出循环
- case开关语句分支
- char声明字符变量或函数返回类型
- const定义变量，那么他的值就不能被改变
- continue结束当前循环
- default开关(switch语句)中的分支
- do循环语句的循环体
- double双精度浮点变量
- enmu声明枚举类型
- for循环
- auto 自动声明变量

## 数据类型：

### 算术类型：

#### 整数类型：

char    1个字节

unsigned char 1个字节

int       4个字节

unsigned   int  4个字节

#### 浮点类型：

float  单精度浮点类型

double双精度浮点类型

long double

可以用sizeof()求最大字节数

### void类型：

无需返回值

### 类型转换：

例如：`int a = 1`    `float b = (a + 2.0)`  



