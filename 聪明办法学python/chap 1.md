# chap 1

 <!--python 比其他语言简洁  快乐学python-->

*python "   "与   '   '  无区别*

## 注释

- 单行注释  #
- 多行注释     '''     or     """

## 输出  print  

- end 控制结尾（默认有换行）

   `print ("Data",end = "  转义字符 ")`

- sep 控制分隔参数（默认空格分隔，加法去除空格） `print("I","am",sep="分隔字母")`

- 内部自动做算数运算

- 字符串前有  **f**   （fstring）可以体现变量的值 

   `print(f"your age is {age}")`

  {age}就可以体现你给变量age赋的值，同时{ age+age}可以做运算

- 多行输出用  """ 文本 """   

## Error

- Syntax Error 语法错误   
- Logical Error 逻辑错误    
- Running Error 运行时错误    即 crash

## 输入   input

- `name = input("enter your name :")`  即C语言中的 scanf

- `age = int (input ("enter you age"))`    强制转化

- split  使得用户输入更多的数 

   `a,b = input().split(",")`可以使得输入两个用逗号隔开的数会分别对ab赋值

## 库

库的调用使得python很方便

import  math 类似于c语言的头文件

*浮点误差*

