# 聪明办法学python Talk 2 如何debug

## 1.为什么要调试

- 程序运行（前提过编译器）使得我们只能看到结果错误，即逻辑错误，逻辑错误并不好找，更何况遇到的代码较长就跟不好找到错误，而debug就是便于找到错误，
- 错误大部分是自己的问题，先自己找找问题，别急着怀疑电脑，放平心态慢慢找

## 2.看懂报错

- ide  会找到一些语法bug   看行数(line)快速找到位置,可以拷贝下来询问

## 3.一些debug的小方法

- print：能看到在哪里，但是解决不了
- assert ：如果不符合就直接报错，但是会中断运行

## 4.vscode 的debug

创建 .json文件选择 python：当前文件
就会出现如图所示的一个文件

进入.py文件左边有变量还有监视，堆栈
断点在想打断点的行号左边单机出现红色小圆点即可
上面有几个箭头依次是

- 继续——运行到下一个断点
- 单步跳过——只执行当前行
- 单步调试——进入函数内部进行调试
- 重启——重新运行