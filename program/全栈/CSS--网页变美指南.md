# CSS--网页变美指南 

## 1.概念

- 层叠样式表，级联样式表，简称样式表
- 后缀为 .css
- 用于HTML文档中元素样式的定义

## 2.css存在的意义

- 网页更加美观

## 3.语法

由选择器或者一条或多条声明（样式）

选择器：需要改变样式的HTML元素，后跟大括号

每条生命由一个属性和一个值组成

属性是您希望设置的样式属性，每个属性有一个值。属性和值用冒号分开

## 4.引入方式

### 1.内联样式

- 在标签内部引入style=  属性与值用冒号隔开
- 缺点：维护成本高，不能同时控制多个标签

### 2.内部样式

- 头部增加style标签
- 缺点：多个页面会出现混乱

### 3.外部样式

- 创建.css的文件  用link标签引入
- 有点：利于多页面，改变起来方便

## 5.选择器

### 1.概念：

选择元素给对应的元素添加样式，通俗来就是改变样式的

### 2.类型：

1. 全局选择器(全局改变)     *开头   优先级最低
2. 元素选择器                         某一元素同时生效     (在head中使用)
3. 类选择器  class属性，双引号里跟名字，命名法都差不多，空格隔开    英文.索引
4. id选择器   针对某一特殊标题进行更改          id属性    #索引
5. 合并选择器    p，h两标签     用 , 衔接 

### 3.优先级：

内联样式 > id选择器 > 类选择器 > 元素选择器

先生效优先级较高的，同级从上往下开始但是下面会覆盖上面的

## 6.字体属性：

- color：颜色，#十六进制，rgb(0-255，0-255 ，0-255 )，rgb( ， ， ， 0-1透明度)
- font-size：     字体大小最小是12px
- font-weight ：bold/bolder/lighter/100-900(400中间值，700最粗)
- font-style  ：normal(正常)或者italic(斜体)
- font-family:字体样式

## 7.背景属性

- background-color：   与字体color相仿
- background-image ：url  ( 图片位置 )背景图像
- background-repeat     -x，-y ，no-repeat、 默认水平竖直均平铺
- background-size          length，percentage，cover，contain
- background-position  渲染位置

## 8.文本属性

- text-align    left、right、center   位置
- text-decoration  文本修饰 underline(下划线)  overline(上划线)  line-through(删除线)
- text-transform    文本大小写  captialize(每个单词开头大写)   uppercase(全部大写)  lowercase（全部小写）
- text-indent           首行缩进  两个字30px

## 9.表格属性

- border  边框大小，solid实线，边框颜色
- border-collapse : collapse  折叠(单)边框
- 设置高度宽度
- 文字对齐  ：默认左中对其对齐，使用  text-align  水平，vertical-align: top/center/bottom
- 表格填充   ：padding   填充空白
- 表格颜色

