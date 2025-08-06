# html

## 1.工具选择与安装

- 浏览器：谷歌(使用)，IE浏览器，火狐
- ide：vscode(建议)

## 2.vs快捷键

- 格式化:`Shift+Alt+F`
- 向上移动或者向下移动一行：`Alt+Up or Alt+Down`
- 快速复制一行代码：`Shift+Alt+Up or Shift+Alt+Down`
- 快速查找：`Ctrl+F`
- 快速替换：`Ctrl+H`

## 3.HTML

### 1.简介：

HTML5是描述网页的一种语言，

HTML是一种标签语言,标签是用< >包裹的

包括    单标签，双标签（有头尾即html    /html）

### 2.DOCTYPE声明：

!DOCTYPE html(是声明不是骨架)位于标签前面，作用：避免浏览器的怪异模式

### 3.注释

<!--   -->

### 4.骨架：

1.html   代表是网页，要有一对

2.head  是头部文件包括一些信息，给编程人员看

3.body  定义主题，给用户看

4.title    (在head里面)是标题标签标签名，利于seo的优化有利于用户点击

   SEO：在网页出现的位置顶端还是底部顶端有利于增加访问量

5.meta  (单标签也在head中)描述html网页的属性，关键词编码格式常用utf-8

### 5.标签

#### 1.标题介绍与应用：

1. 从h1-h6标签从大到小，h$*6自动生成6个标签

2. 正确使用标签，h1为重要标签，h2其次

3. 注：不要为了加粗而去使用标签，标签只用于标题

   正确使用有益于SEO

4. 属性：位于标签的 > 前  align="left/center/right",不推荐使用

#### 2.段落，换行，水平线    p   br   hr

1. p      标签定义，承载段落，每个p标签会空大概一行

2. br   (单标签)两行中间无空行，即正常换行

3. hr，水平线

   属性：color="red"：改变颜色

   ​			width="300px"：改变宽度(px像素单位)

   ​			size="20px"：宽度

   ​			align="lift/right"默认center：改变位置

#### 3.图片    img

- img(单标签)src="名字"，名字需要跟html文件在一个文件夹下面

​       属性：src：路径，地址或者名称

​			alt：当图片没出现是文本替代

​			width：宽度

​			height：规定高度，高度改变会改变图片本身

​			title：鼠标悬停给予提示文本

- 路径：

  绝对路径：本地文件所在的路径

  相对路径：同级：用   ./  寻找，可省略，也可用名字，在同一路径可直接访问

  ​					子级：同级下的子级通过 ./寻找

  ​					父级:   同级下的父级，用 ../返回上一级

  网络路径：通过浏览器的地址进行访问

#### 4.超链接       a

- 可以跳转，箭头变小手
- 用 a 标签中间可以是字词话
- 属性：**href**后跟网站的下划线（蓝色（没点过），紫色（点过）或者红色（点击时，不松开鼠标时））css可以可以调整下划线以达到美观
- 照片也可以超链接

#### 5.文本        

- em        定义着重文字
- b            加粗
- i             斜体字
- strong  定义加重语气
- del         定义删除字
- span      元素没有特定含义，为使用css方便用

#### 6.列表标签

##### 有序 ol

- 有序列表是一个项目，始于   ol + li   类似于   html
- ol属性： type="1  /  a / A  / i  / I "
- 可以嵌套使用，建议不要多层嵌套，修改很麻烦

##### 无序 ul 

- 跟md文档一样无序

- ul 属性：disc实心圆   

    				circle空心圆  

  ​                   square方块 

  ​					none不显示

- 可以嵌套
- 导航可以应用css改变位置
- 快捷键 ul>li*n就会出现n个li标签

#### 7.表格 table

- 行，列，单元格：同行等高，同列等宽

- 表格：table  行tr  列td   

- 快捷键：table>tr*num>td num{表格内容}

- 属性：border     单元格的像素，不推荐使用，展示出表格的效果

  ​			width       宽度

  ​			height

- 单元格合并：colspan=几就是合并几水平合并

  ​                       rowspan垂直合并，遵循   保留先出现的那个（记得删掉后面的，不删会出现空白，多出不删的东西）

  ![不插入的后果](C:\Users\zhume\Pictures\Screenshots\屏幕截图 2023-12-21 204242.png)

#### 8.form表单

- 从键盘上输入需要用表单，用来填写信息，从而能采集用户信息，例如：登录注册，输入框

- form表单属性：action：服务器地址，name：表单名字 method：get提交能看到并且只提交小量数据，post看不到并且提交大量数据

- 元素：表单标签，表单域，表单按钮 通过input(单标签)输入框

  ![样例](C:\Users\zhume\Pictures\Screenshots\屏幕截图 2023-12-21 205835.png)

- 文本框：文本域，

- 用户名：input

- 密码：input，type="password"
- 提交文件，submit，
- value改变文本

#### 9.新标签        老版本不兼容

语义化              div     容器元素   增加清晰度

- head 头部标签
- nav导航
- artical 文章独立完整
- section章节
- aside侧边栏
- footer脚步

### 6.块元素与行内元素

#### 1.块元素：

- 独占一行
- 可以设置width height
- 一般块元素可以包含行内元素和其他块级元素
- 常见的有：div,form,h1`h6,hr,p,table,ul

#### 2.行内元素

- 行内元素不会独占一行，只占自身大小
- 行内元素设置width height属性无效
- 一般内联元素包含内联元素不包含块元素
- 常见行内元素的有     a,b,em,i,span,strong     文本标签
- 块级元素，能识别宽高：button，img，

# 考试

&nbsp;&nbsp; &nbsp;&nbsp 空格字符加；

pre标签格式化文本

div标签

ul li两个标签嵌套

table th tr td

input  type（test password radio checkbox submit reset）  value  

textarea

text-align 属性规定元素中的文本的水平对齐方式。常用的值有：

-   left ：把文本排列到左边。默认值：由浏览器决定。
-   right ：把文本排列到右边。
-   center ：把文本排列到中间。
-   justify ：实现两端对齐文本效果。
-   inherit ：规定应该从父元素继承 text-align 属性的值

letter-spacing   

-   normal：默认。规定字符间没有额外的空间，相当于值为 0。
-   length：定义字符间的固定空间（允许使用负值），如12px、-5px等
-   inherit：规定应该从父元素继承 letter-spacing 属性的值

line-height 属性设置行间的距离（行高）。不允许使用负值。常用的值有：

-   normal：默认，设置合理的行间距。
-   number：设置数字，此数字会与当前的字体尺寸相乘来设置行间距。
-   length：设置固定的行间距。
-   % ：基于当前字体尺寸的百分比行间距。
-   inherit：规定应该从父元素继承 line-height 属性的值

text-decoration 属性规定添加到文本的修饰，下划线、上划线、删除线等。

text-decoration 属性是以下三种属性的简写：

-   text-decoration-line
-   text-decoration-color
-   text-decoration-style

其中，text-decoration-line 属性常用值有：

-   none：默认。定义标准的文本。
-   underline：定义文本下的一条线。
-   overline：定义文本上的一条线，也用作删除线。
-   line-through：定义穿过文本下的一条线。
-   blink：定义闪烁的文本。IE、Chrome 或 Safari 不支持 “blink” 属性值。
-   inherit：规定应该从父元素继承 text-decoration 属性的值。任何的版本的 Internet Explorer （包括 IE8）都不支持属性值 “inherit”

CSS 字体属性定义文本的字体系列、大小、加粗、风格（如斜体）和变形（如小型大写字母）。常用属性有：

-   font-family：字体系列，在 CSS 中，有两种不同类型的字体系列名称：`通用字体系列` - 拥有相似外观的字体系统组合（比如 “Serif” 或 “Monospace”）；`特定字体系列` - 具体的字体系列（比如 “Times” 或 “Courier”）。
-   font-size：字号，有三种方式：`px`、`em`和`百分比`。
-   font-style：常用于规定斜体文本。该属性有三个值：`normal` - 文本正常显示；`italic` - 文本斜体显示；`oblique` - 文本倾斜显示。通常情况下，italic 和 oblique 文本在 web 浏览器中看上去完全一样。
-   font-weight：将文本设置为粗体。该属性常用值有：`normal` -正常字体；`bold` -粗体；`bolder` -比所继承值更粗的一个字体加粗；`lighter` -比所继承值更细的一个字体加细。

background-image：规定要使用的背景图像。常用值为：url(‘URL’)图片链接、none不显示图像。

background-repeat：规定如何重复背景图像。repeat-x 和 repeat-y 分别导致图像只在水平或垂直方向上重复，no-repeat 则不允许图像在任何方向上平铺。

background-attachment：规定背景图像是否固定或者随着页面的其余部分滚动。默认滚动，可设置为 fixed 不滚动。

background-position：规定背景图像的位置。常用值为：关键字（top、bottom、left、right 和 center）、长度值（如 100px 或 5cm）、百分比（比较复杂，很少使用）。

table 标签代表表格，常用的CSS属性有：

- width：宽，可以是值，也可以是百分比。
- height：高，可以是值，也可以是百分比。
- border：属性设置表格边框，可以为table、th、td设置，属性有border-width（如10px）、border-style（如solid）、border-color（如blue）。border设置的是双线条边框，折叠为单一边框可用border-collapse。
- border-collapse：属性设置是否将表格边框折叠为单一边框；折叠则设置值为collapse。
- text-align：属性设置表格中文本水平对齐方式。比如左对齐、右对齐或者居中
- vertical-align：属性设置表格中文本垂直对齐方式。比如顶部对齐、底部对齐或居中对齐
- padding：属性控制表格中内容与边框的距离，需为 td 和 th 元素设置。

@font-face规则，可以实现定义您喜欢的字体（前提是字体需放到服务器上）。必须有的值为：

- font-family：必需的。定义字体的名称。
- src：必需的。定义该字体下载的网址。

定义字体语法：

```
@font-face
{
font-family:字体名称
src: url('网址'),
}
```

transition 属性设置元素当过渡效果，是一个简写属性，用于设置四个过渡属性：

- transition-property：规定设置过渡效果的 CSS 属性的名称。
- transition-duration：规定完成过渡效果需要多少秒或毫秒。
- transition-timing-function：规定速度效果的速度曲线。
- transition-delay：定义过渡效果何时开始。

语法：`transition: property duration timing-function delay;`

transform 属性还可以用来实现3D效果。常用值有：

- scale3d(x,y,z)：定义 3D 缩放转换。
- scaleX(x)：定义 3D 缩放转换，通过给定一个 X 轴的值。
- scaleY(y)：定义 3D 缩放转换，通过给定一个 Y 轴的值。
- scaleZ(z)：定义 3D 缩放转换，通过给定一个 Z 轴的值。
- rotate3d(x,y,z,angle)：定义 3D 旋转。
- rotateX(angle)：定义沿 X 轴的 3D 旋转。
- rotateY(angle)：定义沿 Y 轴的 3D 旋转。
- rotateZ(angle)：定义沿 Z 轴的 3D 旋转。
- perspective(n)：定义 3D 转换元素的透视视图。

position 属性指定一个元素（静态的，相对的，绝对或固定）的定位方法的类型。常用值有：

- absolute：生成绝对定位的元素，相对于 static 定位以外的第一个父元素进行定位。元素的位置通过 “left”, “top”, “right” 以及 “bottom” 属性进行规定。
- fixed：生成固定定位的元素，相对于浏览器窗口进行定位。元素的位置通过 “left”, “top”, “right” 以及 “bottom” 属性进行规定。
- relative：生成相对定位的元素，相对于其正常位置进行定位。因此，“left:20” 会向元素的 LEFT 位置添加 20 像素。
- static：默认值。没有定位。
