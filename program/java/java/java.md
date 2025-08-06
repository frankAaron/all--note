jdk：开发工具包

jre：核心类库，环境集合，运行环境

jvm：虚拟机

jdk>jre>jvm

代码---字节码---jvm---机器码

day2

## 变量

-   内存中的存储空间

-   todo变量的作用域

## 标识符：

小驼峰：变量

大驼峰：类

## 数据类型：

-   基本类型
-   引用数据类型   类，接口，数组，字符串，枚举，注解，

Boolean 1个字节

byte 一个字节   -128~127

用float加F标识

​	

## 类型转换

-   隐式转换：把一个取值范围小的转换成一个大的，给大的赋值，数据类型不统一先提升到大的
    -   byte -> short -> int-> long -> float -> double
        -   long占用8个字节
    -   byte shot char 转换为 int 进行数据运算

-   强制转换：造成精度损失

### 源码，反码，补码

在计算机上所有数字均为二进制数字

一个字节8比特

原码 -> 反码 -> 补码

源码：符号位（第一位为0为正数，第一位为1为负数）

反码：正数：相同

​           负数：源码除去符号位逐位取反

补码   正数相同

​		  负数： 反码末尾加1

补码 -> 原码  取反+1





package   便于管理

**扩展赋值预算符号，自带强制转换**

">> 1"等价于除以二



## 逻辑运算

& 与  

|   或

^ 异或   交换数据  a = a ^ b   b = a ^ b  a = a ^ b

! 非

短路与 &&   左边为false **右边就不执行**

短路非 ||  左边为true **右边就不执行**

### 三元运算符号

判断条件？x : y

如果条件为真结果为x，否则为x

与   或 

 方法区，字节码加载时进入

栈内存，return弹栈

### 方法重载

同名的方法，但形参个数不同，或者形参数据类型，顺序不同也行，与返回值无关

调用时根据实参区1分

switch case  case后面只能跟字面量 其基本类型：byte short char int 

case 1,2,3 -> System.out.println();   也可以

for循环内存释放，循环体内部的变量不能继续使用

while循环，变量能继续使用

continue 退出本次循环

random   类似于 Scanner 导包

## 数组

@分隔符

[ 当前为数组空间

I 数据类型

十六进制内存地址

打印字符串看不见地址，

length 动态获取数组长度

初始化：  默认值

​		整数：0

​		小数：0.0

​		布尔false

​		字符 ‘\u0000’   \u unicode编码

​		引用数据类型(数组，类，接口)：null

new 出来的东西在**堆内存**中 像Scaner  Random  数组

栈内存存放地址，堆内存存放数据，栈内存通过地址找到堆内存的数据并进行修改

array1 = array2  地址复制，即指向相同的空间，二者变一个都变

数组会开辟空间，操作的是地址，变量实在栈内存中，所以要return

```
string arr[]=new String[]
```



## 类

java想要创建对象，先创建类。

有new进堆

int类

## this

就近原则  重名    地址问题   不加this找地址不如传参近

调用本类的成员变量

this即 代指本类

静态无法访问非静态

## 构造方法

每创建一个对象执行一次构造方法

系统提供默认构造方法

## 封装

权限修饰符号

-   private 修饰的东西（变量和方法）只能在一个类当中

-   defalut   默认权限，只能在同一个包中

-   protected  不同包的子类中 

-   public  在任意位置访问

JavaBeen 实体类  成员变量私有化   空参    只负责数据处理

## API帮助文档

1.  索引搜索类
2.  看包  **看是不是java.lang   核心包不用import**
3.  看类的介绍
4.  看这个类的构造方法
5.  看这个类的成员方法

## String类

String 赋值即创建对象

-   不可改变但可以共享
-   字符串创建就不能更改（地址），只能使用新的对象进行替换

常量池，在堆内存中记录字符串，只要有  " "就会在常量池中创建

`String s1 = "abc"` --> 创建一个对象   `String s2 = new String("abc")` ---> 创建两个对象，   拷贝常量池中”abc“地址的副本   

字符串 "+" 号拼接会在StringBuilder创建一个对象，常量池一个对象

常量拼接和变量拼接不一样  

```java
String s1 = "abc";
String s2 = "ab";
System.out.print(s1+s2);
```



字符串是字节数组，数组给的是地址

### 方法

-   **substring** 找到初始位置的索引 即切片 
-   **indexOf(x)**  查找第一个x的索引 没有返回-1

-   **length** 返回长度

-   **compareTo** 从第一个开始比较相同返回0，不相同返回第一个不相等的字符差，ascii  如果长度不同返回长度差，前面的减去后面的   s1.compareTo（s2） s1 - s2

-   **equals**   判断两个字符串的值是否相等， == 只能判断地址是否相等

-   **toCharArray**  将字符串编程字符数组

-   **charAt(int index)**  给索引找字符串的字符

-   字符串的length是方法要  (  )

-   **replace**(旧，新)  替换

-   **split**  切割跟py的一样  根据正则表达式    \\\\   转义



## StringBuffer类

StringBuffer  类优于  String类

可变字符序列  也可以理解位容器，可以将任意类型转换成字符串

拼接在一个对象里面

方法

-   append添加数据返回对象自己
-   reverse将内容反转
-   length返回长度
-   toString 将其转换成字符串

## 

## ArrayList集合

ArrayList集合  导包 util

初始为0只有通过添加的时候才会变成10，扩容元数组的1.5倍数= 的数组

1.  构造方法  创建ArrayList对象  add方法添加数据

2.  集合容器创建细节   可以添加任意数据类型，数据类型不够严谨

    创建 加 < type> 对存储数据做类型限制，

    <>泛型 对集合数据进行限制

    不允许编写基本数据类型   

    int --> Integer

    char --> Character

**成员方法**

-   增

    -   add  直接增  返回值恒威true
    -   add(index，内容)   容易出现索引越界  一般是查对

-   删

    -   remove(index)  删除index的元素  返回值为被删除的元素
    -   remove（内容） 根据内容删除  

-   改

    -   set（index, element）修改index的元素为新元素 返回值为被覆盖的元素

        --------------------------------以上返回值都不接收--------------------

-   查

    -   get (index)  根据索引找到集合中的元素 
    -   size（） 返回元素个数  



删除

```java
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("test")){
               list.remove(i);
               i--;
            }
        }
```

```java
        for (int i = list.size()-1; i >=0 ; i--) {
            if(list.get(i).equals("test")){
               list.remove(i);
            }
        }
```

```java
        for (int i = 0; i <list.size() ; ) {
            if("test".equals(list.get(i))){
                list.remove(i);
            }else i++;
        }
```



## static关键字

修饰成员变量，成员方法

特点

-   被类的所有对象共享   即创建了一个默认值  可以修改
-   可以通过类名调用   即 sc. --->   Scanner.   推荐类名调用
-   **优先于对象存在  在类进入字节码文件，static就开始创建静态区   不是new  完创建的**

成员方法加static：

​           工具类，不能封装的类，帮助完成任务的。

不需要创建对象，直接类名  .  

如果一个类全是工具，需要私有化该类，防止其他类创建该类的对象



### 注意

静态方法只能访问静态成员  

不允许使用this关键字   this出现在new之后，static在new之前

## 继承

类与类产生关系 

子类可以调用父类的成员变量，成员方法，构造方法  就近原则  super 用父类的成员变量

## 重写Override

子类和父类中，出现了函数完全相同（方法名，参数，返回值）

## super

调用父类方法时要用

this    调用自己的

super   调用父类

在子类继承中，其实已经有父类的成员变量，所以没有重复可以省略

## final

父类中的方法，不希望子类对父类进行修改   防止子类对父类的修改

final  修饰的可以有父类，不能有子类

final  修饰成员变量   不能被再次修改

final  修饰引用数据类型不可改边的是地址值不可改变  内容可以改变

## 抽象类

abstract  

-   抽象类不能实例化
    -   如果可以实例话，就可以调用abstract方法，abstract方法内部没有东西
-   存在构造方法   
    -   为了子类继承
-   抽象类可以存在普通方法
-   抽象类的子类
    -   要么重写抽象类中的所有抽象发放
    -   抽象类

final 修饰的子类  强制不能重写， abstract 强制重写

private   不能找到

static     类方法  .  

## 接口

指定规则   interface 子方法全部都是abstract

没有成员变量，没有普通     方法 

class  类名  implements Inter

接口成员特点

-   成员变量   只能定义常量，public  static  abstract
-   成员方法  只能是抽象方法
-   构造方法/： 无

类和接口的各种关系

-   类和类
    -   继承关系，只能单继承，但是可以多层继承
-   类和接口
    -   实现关系，可以单实现，也可以多实现，继承一个类（默认继承object类），实现多借口
-   接口和接口
    -   继承关系，可以单继承，也可以多继承

```java
public class Damo{
    public static void main(String[] args) {

    }
}
interface i{ 
    abstract void show();
    abstract void method();
}
abstract class i2 implements i {

}
class i3 implements i{

    @Override
    public void show() {

    }

    @Override
    public void method() {

    }
}
```



## 多态

编译看左边运行看右边

-   优点
    -   可以提高程序的扩展性
-   缺点
    -   不能用子类特有成员

instanceof  判断左边的引用是否等于有右边的数据类型

```
public class Damo{
    public static void main(String[] args) {
        eat(new Dog());
        eat(new Cat());
    }

    public static void eat(Animal animal){
        animal.eat();
    }
}
abstract class Animal{
    public  abstract void eat();
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("1");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("2");
    }
}
```

## 接口特性

解决接口升级问题，允许接口中定义非抽象方法，但是需要使用关键字default修饰，这些方法都是默认方法

private   私有化方法

## 代码块

-   局部代码块
    -      用 { } 包裹限定变量的生命周期，提前释放内存
-   构造代码块
    -   在构造方法之前就会执行代码块
    -   本质是代码块放到构造方法头部
    -   将多个构造方法重复的东西抽取出来                      
-   静态代码块
    -   随着类的加载而执行    只会加载一次
    -   在类加载的时候做一些数据的初始化操作

## 内部类

创建格式

```java
Out.Inner n  =  new Out().new Inner();
```

```java
class Outer{
    int num = 10;
    class Inner{
        int num = 20;
        public void setNum(){
            int num  = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}
```



## 匿名内部类

实现接口使代码更加简介

```
new Inter(){
	public void show(){
	sout("匿名内部类...show...");
	}
}
```

不能完全取代普通接口，

参数是接口，接口抽象方法不多就用匿名内部类



lambda   有且仅有一个接口   **@FunctionalInterface   (函数式编程式接口)**

```
userInter((重写函数所需要传的参数) -> { 方法体代码 });
```

lamda表达式的省略写法

参数省略不写

## object类

### tostring

将地址值（类名...打印出来的地址）转换成里面的值

### equals

对象内容之间的比较

```java
stu1.equals(stu2) ---> false
底层代码
public boolean equals(Object obj){
	return (this == obj);   //等价于 stu1 == stu2 
}
```

一般重写equals方法

```java
public boolean equals(Object obj){
	向下转型
        
	Student stu = (Student) obj;
	this.age == stu.age;  //不能直接"."是因为父类不能调用子类
}
```

objects  是object的子类   常见的是equals和isNull

```
好处：内部有非null判断
```

## math类

数学类

-   abs  获得参数绝对值
-   ceil  向上取整
-   floor(float a)  向下取整
-   round   四舍五入
-   max
-   pow(double a，double b)  a的b次幂
-   random     返回为double的随机数，


## System类

exit  终止虚拟机   参数最好是0

currentTimeMillis  返回当前系统的时间   从1970.1.1 到现在的毫秒值

arraycopy(数据源数组，起始索引，目的地数组，目的地数组的起始索引，拷贝个数)

## BigDecimal

解决小数运算中的不精确问题

-   BigDecimal(double val)不推荐

-   ---------------------------------

    BigDecimal(String  val)

-   BigDecimal.valuOf(double val)

```java
BigDecimal bd1 = BigDecimal.valuOf();
```

成员方法

-   add   加法
-   subtract    减法
-   multipy      乘法
-   divide       除法
-   divide(,保留几位小数,RoundingMode)     
    -   up 进一法
    -   down  去尾法
    -   half_up  四舍五入

```
bd1.divide(bd2)
```

## 包装类

将基本数据类型变成类

```java
int i =1;
Integer i1 = Integer.valueOf(i);   //将基本数据类型包装成类
i1.inValue(i);    //将包装类型拆成基本数据类型
// 自动装箱
Integer i1 = i;
int i = i1;
```

```java
Integer.toBinaryString(i);   //转二进制
Integer.toOctalString(i);    //转八进制
Integer.toHexString(i);		//转十六进制
Integer.parseInt(i);		//将数字字符串转换成整数
Integer.parseINt(sc.nextLine()); //将输入的字符转为int
```

自动装箱的时候，如果装箱的数据范围是-128~127，==号比较结果是true，反之是false

## Arrays工具类

操作数组的工具类

-   toString（x）    返回一个带有   [ 中间有逗号的方法 ]
-   equals（x，y）      比较内容
-   binarySearch（x，a）  
    -   查找在x数组中的a号元素   有则返回索引，不存在返回（-插入点）-1
    -   乱序不可以 
-   sort（x）对数组进行默认升序排序

## 冒泡排序

```JAVA
int [] arr = {11, 22, 33, 44, 55};
for (int i = 0; i < arr.length-1; i++) {
    for (int j = 0; j < arr.length-i-1; j++) {
        if (arr[j] < arr[j+1]){
            int t = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = t;
        }
    }
}
System.out.println(Arrays.toString(arr));
```

## 选择排序

```java
int []arr = {11,22,33,44,55};
for (int i = 0; i < arr.length; i++) {
    for (int j = i+1; j < arr.length; j++) {
        if(arr[i] > arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
System.out.println(Arrays.toString(arr));
```

## 二分查找

```java
int[] arr = {11, 22, 33, 44, 55};
int c = 44;
int min = 0;
int max = arr.length - 1;

while (min <= max) {
    int mid = (min + max) / 2;
    if (arr[mid] != c) {
        if (arr[mid] > c) {
            max = mid - 1;
        } else {
            min = mid + 1;

        }
    } else {
        System.out.println(mid+1);
        break;
    }
}
```

## 正则表达式

【】对单个字符

```java
"".matches(regex);   ---> 返回值是一个bool值
```

```java
//将正则表达式封装成一个Pattern对象
Pattern pattern = Pattern.compile(regex);
//获取匹配器对象
Matcher matcher = pattern.matcher(data);
//通过匹配器爬取信息
while(matcher.find()){
    System.out.println(matcher.group());
}
```

## data类

>   Data d = new Data();

-   getTime
-   setTime  修改时间

jdk8之后   线程安全

- 日历类

  - LocalData  年，月，日

  - LocalTime  时，分，秒

  - LocalDataTime  年，月，日，时，分，秒

    - now   当前时间

    - of 设置时间

    - ```java
      LocalDateTime now = LocalDateTime.now();
      LocalDateTIme of = LocalDateTime.of();
      ```

    - tolocaltime转换

  - 修改时间

    - 返回均为对象
    - with  直接修改成指定的  只能修改一个   不行就of 整体进行修改
    - plus   加上
    - minus减去
    - isBefore  在他之前
    - isAffter 在他之后

- 日期格式化类

  - DataTimeFormatter  时间格式化和解析

    - ```java
      LocalDateTime now = LocalDateTime.now();
      //获取格式化对象
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日");
      //格式化
      String time = formatter.format(now);
      //解析
      String te = "2005年11月03日";
      LocalDate parse = LocalDate.parse(te,formatter);
      ```

- 时间类

  - Instant 时间线

  - ZoneId 时区

  - ZoneDateTime 带时区的时间

    - ```
      ZoneId.getAvailableZoneIds().var;
      ZoneId zoneId = ZoneId.systemDefault();  //获取系统默认时长
      ZoneId of = ZoneId.of(指定时区);
      Instant.now().atZone(of).var;
      ```

    - ```
      instant now = Instant.now(); //世界标准时间
      instant.ofEpochM/S   //获取instant对象，根据秒/毫秒/纳秒
      instant.now().atZone(ZoneId.systemDefault()); //指定时区
      now.isBefore()
      now.isAfter()
      minus
      plus
      ```

    - ```
      minus
      plus
      with
      ```

- 工具类

  - Period  时间间隔  年月日

  - Duration  时间间隔  时分秒纳秒

  - ChronoUnit  时间间隔  所有单位

  - ```
    Period.betwenn().var;
    period.toDats();
    ChronnoUnit.YEARS.between(birthday,today); //today-bir
    ```

```

```

```java
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
Date date = new Date();
String r = simpleDateFormat.format(date);
System.out.println(r);
```

parse  将日期字符串转换成日期对象，日期对象转换

## 递归

## 异常

-   看懂异常api    帮助文档有
-   异常体系
    -   严重级别 Error
        -   栈内存溢出
        -   堆内存溢出
    -   Exception
        -   编译时异常   可能会出现问题    ---运行之前解决
        -   运行时异常 

-   异常处理

    -   对于异常默认处理  向上抛出  虚拟机会自动创建对象   程序终止后续代码不能继续

    - try...catch 捕获异常后续代码可以继续进行

      ```java
      try{
      可能出现异常代码
      }  catch(异常){
      处理方案
      }catch(){
      
      }
      //优化   缺点 不能精准改进，大异常放后面
      try{
          
      }catch(Exception e){
          
      }
      ```
    
    - throws
    
      -   可以声明多个，在主方法后面
      -   throw抛出去内部
      -   throws函数方法
    
    
    ```java
    //可以自定义异常
    if(){
    
    }else{
    	throw new Exception("errorexception");
    }
    
    Exception e；
    String m = e.getMessage();
    ```
    
    面临的异常
    
    如果要暴露就throw，
    
    

自定义异常

- 定义一个异常类继承Exception  /RuntimeException
- 重写构造器

细节

- ```
  string getMesssage()   获取异常信息
  ```

- ```
  void printStackTrace()  展示完整异常，但不会终止程序的运行
  ```

- 子类继承父类，重写方法不能抛出父类没有的或者比父类大的异常

## 集合

- 单列（单词增加一个）集合 collection
  - list接口
    - 存取有序，有索引，能加重复的
    
    - boolean add     添加
    
        - ```
            list.add(0,"赵六")；
            ```
    
    - void clear    清空所有
    
    - boolean remove  删除   重写equals方法
    
    - boolean contains  判断是否包含给定对象  重写equals方法
    
    - boolean isEmpty
    
    - int size
    
  - set接口
    - 无序，没有索引，不能重复
  
- 集合的遍历

  - 迭代器遍历

    - ```java
      Collection<Student> c = new Arraylist<>();
      c.add(new Student());
      c.iterator().var;
      // c.next()  : 从集合中返回一个
      // bollean  hasNext  ：判断是否有
      while(c.hasNext()){
      	Student stu = it.next();
      	sout(stu);
      }
      
      ```
    - ```
      //增强for循环，底层逻辑是迭代器
      for(数据类型 变量名: 数组或集合){
      
      }
      ```
    - ```
      //forearch
      c.forEach();
      ```

  - list集合

    - add

      - 当存入整数是时，需要自己装箱

      - Integer.calueOf();

      - ```
          list.add(0,"赵六");
          ```

      - ```
          list.add("张三");
          list.add("李四");
          list.add("王五");
          list.add("张三");
          ```

    - remove(index)

        - 返回删除的值

    - set(index,string)

        - 覆盖

    - get(index)

        - 返回指定索引处的元素

  - list集合遍历

    - LIstIterator
      - previous	逆序遍历
      - hasPrevious
    - 普通for循环

  - LinkedList

    - 常见方法
      - addFirst

      - getFirst

      - getLast()

      - removeFirst()

    - 双向连表，表面上是根据索引，实际上是判断
    
  - Treeset

    - 添加节点

      - 小的左边走
      - 大的右边走
      - 一样的不走

    - 取出顺序

      - 中序遍历

    - 排序（当添加元素会自动调用compareTo）

      - 自然排序

        - 学生类需要继承compareTo接口，泛型为添加的类

          - ```
            Class Student implements CompareTo<Student>{
            
            }
            ```

          - 需要重写方法

          ```
          public int compareTo(){
          	//return 0;	 只有第一个
          	//return 1;  正序
          	//return -1; 倒序  原因跟添加节点相关，根据返回值比较   
          	//this - o  正序
          	//o - this  倒序
          	int ageResult = o.age - this.age;
              int result = ageResult == 0 ? o.name.compareTo(This.name)
          	
          	
          }
          ```

    - 比较排序

      - ```
        TreeSet<Student> ts =new TreeSet<>({
        	public int compareTo(Student 01,Student o2){
        	
        	}//优先比较器	
        })
        ```

      - 不满意自比较其带类的排序规则用

    - 去重

  - HashSet

    - 去重   
      - 重写equals和hashCode，先走hashCode  equals是在hashCode返回值相同时调用
    - 原理
      - HashCode是地址值是十六进制
      - 创建HashSet,内存存在一个长度为16的数组  底层创建HashMap
      - 调用集合的添加方法，会拿着对象的hashCode方法计算存入的索引，hash值%数组长度  ---->     源码是 (n-1)&hash  等价于hash%16   前面的运算快
          - 调用hashCode  得到原始hash值
          - 右移16位  hash扰动
          - 减少链表挂载量
      - 判断是不是null，是存入，不是调用equals  ，不能排序
      - 底层结构
          - 数组
          - 链表
          - 红黑树
              - 扩容数组
                  - 数组元素个数（size）到达了16*0.75  = 12   因子
                  - 链表挂在元素超过阈值8并且数组长度没有超过64
                  - 重新计算hash值
              - 链表转红黑树
    - LInkedHashSet
      - 可以存储有序   不重复，无索引  双链表
  
- 双列集合   map

### collection工具类

#### 可变参数, 

可以接收多个参数

```
int ...nums  //数据类型 ... 参数名
```

#### collection

```
<T> boolean addAll(Collection<? super T>,elements);  //批量添加 TreeSet 自动去重
void shuffle(list<?> list)							//打乱集合
<T> int binarySearch(List<T> list,T key)  			//二分查找法查找元素
<T> void max/min									//默认排序获取最值
<T> void swap(list ,int i,int j)  					//交换i和j的位置，i和j是索引
```

## 红黑树

![](java/%E7%BA%A2%E9%BB%91%E6%A0%91%E8%A7%84%E5%88%99.png)

## Map集合

key  Value 绑定    

HashMap  键唯一

TreeMap 建排序

LinkedHashMap：建唯一且能排序

```
put（key，value）  添加元素（key重复，覆盖value） 返回值是覆盖的值
remove(key)  根据key删除整个
isEmpty
size
clear
containsKey     判断有没有这个key
containValue   判断有没有value
```

遍历

```
get（key）    得到key对应的value
keySet  所有的key都在一个集合
Set<String> keySet = hm.keySet();
for(String key : keySet){
	map.get();
}
```

建值对象

```
Set<Map.Entry<String,String>> entrySet = hm.entrySet();
for(Map.Entry<String,String>> entry : entrySet){
	entry.getKey();
	entry.getValue();
}
```

````
hm.forEach((k,v) -> sout())
````

## stream流

简化集合数组的

### 获取stream流

单列集合

.stream(s).forEach(s -> sout(s));

双列集合

map.entrySet().stream

数组

Arrays.stream();

杂数据

Stream.of()

### 中间方法

filter  返回值是stream流对象，可以继续使用  对流中的数据进行过滤

```java
list.stream().filter(s -> s.startWith()).filter(s -> s.length() == 3).forEach(s -> sout(s));
```

limit  前几个元素

```
//取出前三个元素
list.stream().limit(3).forEach(s -> sout(s));
```

skip跳过几个元素

concat（Stream a, Stream b） 合并流对象

```
Stream.concat(s1,s2)
```

distinct   去重   需要重写hashCode 和equals

### 终结方法

count

forEach



## file类

自动创建

```
File(pathname)            
File(String parent,child)   对比一就是拆开路径
File(File parent chile)		
isDirectory    
isFile
exists
lengrh  文件的大小  文件夹的字节大小不能用
getAbsolutePath  文件绝对路径
getName  文件名称
lastModified   最后修改时间
```

创建和删除

```
createNewFile  创建一个空文件
mkdirs 创建多级文件夹
delete 删除空文件
```

遍历

```
listFiles()   返回的是下一级的File数组
```

## IO流

-   字节流     ---->万能流
    -   InputStream	字节输入流  
        - ```
          文件路径且存在
          FileInputStream fis = new FileIutputStream(String name/File file) 
          ```
    
        - ```
          fis.read(byte[]);
          String 的一个构造方法(arr[],offset,len);
          ```
    
        -   
    -   OutputStream   字节输出流
    
        -   
    
        -   ```
            //FileOutputStream fos = new FileOutputStream(String name/File file，true)  //true  追加
            //fos.write（byte/String.getBytes()/byte b,int off（起始索引位置）, int len）数组
            //关联文件不存在会自动创建，存在：会清空现有的，再开始写入
            ```
    
    -   关流
    
        -   ```
            try(FileOutputStream fos = new FileOutputStream(String name/File file){
            	fos.write();
            }catch(IOException e){
            
            }
            //原因实现了Autoclose接口
            ```
        -   
    
- 字符流   --->纯文本文件

  - reader 

    - ```
      FileReader(String,File)
      fr.read(char[]);
      ```
    - 
  - wtiter

    - ```
      FileWriter 
      write();
      flush();//刷新数据
      close();
      ```

- 编码：字符转字节

  -   中文字符第一个是负数,通常是负数
  -   String getBytes();默认utf-8
  -   String getBytes

- 编码

## 加密解密

io流    

加密：字节^2

解密：字节^2 ^2

## 字符缓冲流

buffereReader

readLine

## 多线程

### 进程和线程

进程：正在运行的进程     

-   独立性  独立进行，一个进程不能访问其他进程
-   动态性   
-   并发性   在cpu上交替执行

线程 每一个任务就是线程   

多线程 --> 提高执行效率，处理多个任务  java默认是多线程

Thread

-   继承Thread类
-   重写run方法
-   将线程任务写在run方法中
-   创建线程对象
-   调用start方法    会自动调用run方法

```
public class Damo{
    public static void main(String[] args) throws ParseException {
        D1 d1 =new D1();
        d1.start();
        for (int i = 0; i < 200; i++) {
            System.out.println(i);
        }
    }

}
class D1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(i);
        }
    }
}
```

Runnable接口  扩展性强

-   实现Runnable
-   重写run
-   将线程任务写在run方法
-   创建线程任务资源
-   创建线程对象，将资源传入
-   使用线程对象调用start方法

```
public class Damo{
    public static void main(String[] args) throws ParseException {
        D2 d2 =new D2();
        Thread thread = new Thread(d2);
        thread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println(i);
        }
    }
}

class D2 implements Runnable{
	// 构造方法
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName+i);
        }
    }
}
```

Callable

-   实现callable   有一个泛型
-   重写call方法
-   FutureTask 封装线程资源
-   传入线程任务
-   调用start方法

```
public class Damo{
    public static void main(String[] args) throws Exception {
        D3 d3 = new D3();
        FutureTask<Integer> task1 = new FutureTask<>(d3);
        FutureTask<Integer> task2 = new FutureTask<>(d3);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        Integer result = task1.get();
        System.out.println("result"+result);
    }
}

class D3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
```

```
String getName() 获取线程
void  setName()  设置线程名称
Thread.currentThread().getName()
void sleep  休眠
setPriority(1~10)设置线程的优先级  使得线程更容易抢到线程优先完成  默认是5
getPriority
setDaemon(true)守护线程
```

抢占式调度	随即

非抢占式调度  轮流

### 线程安全

多线程公用一份资源会出现安全问题

同步技术  让任意时刻只能有一个线程

```
synchronized(任意对象,最好使用类对象的字节码--->是同一把锁){

}
```

同步方法的所对象

- 非静态方法   this
- 静态方法   本类的字节码对象

lock  

- 互斥锁    

  - ```
    ReentrantLock lock = new ReentrantLock();
    lock.lock()
    lock.unlock() 
    ```

  - 

### 线程通信

确保能按照预定的顺序执行

```
wait() 休眠线程
D.class.wait();
notify()  //唤醒线程
D.class.notify()
D.class.notifyAll();
lock
await   指定单线程等待
signal
需要实现lock 并实现newCondition
```

生命周期

![](java/%E7%BA%BF%E7%A8%8B%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F.png)

线程池

降低线程成本，提升性能

自带线程池（一般不用）

```
ExecutorService pool = Executors.newCachedThreadPool();  //线程对象多
//submit 提交线程
pool.submit(new Runnable() {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
});
pool.shutdown();


ExecutorService pool = Executors.newFixedThreadPool();  //传参数指定线程对象
```

自定义线程池

![](java/%E8%87%AA%E5%AE%9A%E4%B9%89%E7%BA%BF%E7%A8%8B%E5%AF%B9%E8%B1%A1%E5%8F%82%E6%95%B0.png)

```
//有界 new ArrayBlockingQueue<>()
ThreadPoolExecutor pool = new ThreadPoolExecutor(
        2,
        5,
        60,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10),
        Executors.defaultThreadFactory(),
        new ThreadPoolExecutor.AbortPolicy()
);

for (int i = 0; i <= 13 ; i++) {
	pool.submit(new Runnable() {
         @Override
         public void run() {
          System.out.println();
     }
});
}
```

临时线程创建时间：线程数 > 核心线程数 +任务数

拒绝时间   线程任务数> 最大线程数 + 任务数

自定义线程池拒绝策略

![](java/%E8%87%AA%E5%AE%9A%E4%B9%89%E7%BA%BF%E7%A8%8B%E6%8B%92%E7%BB%9D%E7%AD%96%E7%95%A5.png)

### 单例设计模式

消耗资源过多

![](java/%E5%BB%B6%E8%BF%9F%EF%BC%88%E6%87%92%E6%B1%89%E5%BC%8F%EF%BC%89.png)

## 泛型

约束操作数据类型，将运行期的错误到编译期

只能使用引用数据类型

E  element   方法中

T   type    类中

K  key

V  value

？通配符   

extends  E 	可以传入E和他的子类

super  E 	传入E的父类

### 泛型类

创建对象

### 泛型方法

创建对象

非静态的方法：内部的泛型，会根据类的泛型区匹配

静态方法：声明独立的泛型，在调用参数时，确定具体的类型(static在类进行字节码编译的时候就已经创建了)

```java
pubilc static <T> void studyArrayList(T[] arr){
    
}
```

### 泛型接口

实现类和实现接口没有制定，跟着类走

接口的时候自己定，实现类实现接口的时候确定类型

```
interface Inter<E>{
	
}
```





## 注意

String  ， StringBuilder  ， ArrayList    打印对象名不是地址

链式编程，只有在返回值为对象时才行（  . 方法）

字符串常量和变量作比较，常量在起前面

接口可以多继承，类只能单继承

