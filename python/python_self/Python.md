# Python

## 文件I/O

```
file object = open(file_name [, access_mode][, buffering])
```

- file_name：file_name变量是一个包含了你要访问的文件名称的字符串值。

- access_mode：access_mode决定了打开文件的模式：只读，写入，追加等。默认文件访问模式为只读(r)。

- buffering:如果buffering的值被设为0，就不会有寄存。如果buffering的值取1，访问文件时会寄存行。如果将buffering的值设为大于1的整数，表明了这就是的寄存区的缓冲大小。如果取负值，寄存区的缓冲大小则为系统默认。

  

一边循环一边计算的机制，称为生成器：generator，如果一个函数定义中包含`yield`关键字，那么这个函数就不再是一个普通函数，而是一个generator函数，调用一个generator函数将返回一个generator