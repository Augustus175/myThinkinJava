#### 使用javac在命令行编译执行java

*（以下所有的操作都是在新建的文件夹javajartest下进行）*
**jar命令**

```
用法: jar {ctxui}[vfm0Me] [jar-file] [manifest-file] [entry-point] [-C dir] files ...
选项包括: 
    -c  创建新的归档文件
    -t  列出归档目录
    -x  从档案中提取指定的 (或所有) 文件
    -u  更新现有的归档文件
    -v  在标准输出中生成详细输出
    -f  指定归档文件名
    -m  包含指定清单文件中的清单信息
    -e  为捆绑到可执行 jar 文件的独立应用程序
        指定应用程序入口点
    -0  仅存储; 不使用情况任何 ZIP 压缩
    -M  不创建条目的清单文件
    -i  为指定的 jar 文件生成索引信息
    -C  更改为指定的目录并包含其中的文件
如果有任何目录文件, 则对其进行递归处理。
清单文件名, 归档文件名和入口点名称的指定顺序
与 'm', 'f' 和 'e' 标记的指定顺序相同。

示例 1: 将两个类文件归档到一个名为 classes.jar 的归档文件中: 
       jar cvf classes.jar Foo.class Bar.class 
示例 2: 使用现有的清单文件 'mymanifest' 并
           将 foo/ 目录中的所有文件归档到 'classes.jar' 中: 
       jar cvfm classes.jar mymanifest -C foo/ .
```
##### 使用jar命令对class文件进行打包

- 怎样生成可执行的jar包
 - 直接在文件夹下新建HelloWorld.java文件

```
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World !");
    }
}
```

 - 在命令行下进行编译

```
javac HelloWorld.java
```
  这时候生成HelloWorld.class文件，使用**java HelloWorld**命令运行，结果打印Hello World ！
 - 在直接在文件夹下编辑manifest文件（文件名没有要求）内容如下

```
Main-Class: HelloWorld
```
*网上很多都说要在Main-Class这一行最后添加一个空格，并且最后要空一行，但是没有这样做一样也不报任何错误，尚不清楚什么原因*
 - 使用jar命令进行文件打包

```
jar cvfm Hello.jar manifest HelloWorld.class
```
其中
-c创建新的jar文件
-v生成详细的报告并打印
-f指定jar包的名字
-m指定包含的MANIFEST清单文件
最后是需要打包的文件或文件夹

 - 执行jar命令，打印出*Hello World !*

```
java -jar Hello.jar
```

##### 使用jar命令对文件夹进行打包

- 在com/gosly/demo/文件夹下新建java文件

```
package com.gosly.demo;

public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello Jar !")
    }

    public void print(){
        System.out.println("Hello com.gosly.demo -->> HelloJar !")
    }
}
```
- 对文件进行编译生成.class文件

```
javac com/gosly/demo/HelloWorld.java
```

- 新建文件manifest（文件名随意）内容如下

```
Main-Class: com.gosly.demo.HelloWorld
```
- 执行jar命令

```
jar cvfm Hello.jar manifest com/
```
- 执行运行命令

```
java -jar Hello.jar
```

##### 引用外部jar包的整个过程

- 在文件夹org/zzb/demo下新建文件Test.java文件

```
package org.zzb.demo;

import com.gosly.demo.HelloWorld;

public class Test{
    public static void main(String[] args){
        HelloWorld hw = new HelloWorld();
        hw.print();
    }
}
```
- 编译
 - 编译的时候除了需要添加需要引用的jar包位置还要手动显式的引入默认jar包的加载路径
可以使用以下代码进行输出

```
import java.net.URLClassLoader;

/**
 * Created by zhangzhibo-dell on 17-11-5.
 */
public class App {
    public static void main(String[] args) {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }
    }
}
```
 - 输出结果为

```
Connected to the target VM, address: '127.0.0.1:34119', transport: 'socket'
/usr/lib/jvm/jdk1.7.0_79/jre/lib/charsets.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/deploy.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/dnsns.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/localedata.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/sunec.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/sunjce_provider.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/sunpkcs11.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/zipfs.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/javaws.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/jce.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/jfr.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/jfxrt.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/jsse.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/management-agent.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/plugin.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/resources.jar
/usr/lib/jvm/jdk1.7.0_79/jre/lib/rt.jar
```
其实在idea里面任意代码运行后在运行窗口的第一行都会打印出classpath的加载路径

```
/usr/lib/jvm/jdk1.7.0_79/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:34119,suspend=y,server=n -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/jdk1.7.0_79/jre/lib/charsets.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/deploy.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/dnsns.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/localedata.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/sunec.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/ext/zipfs.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/javaws.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/jce.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/jfr.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/jfxrt.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/jsse.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/management-agent.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/plugin.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/resources.jar:/usr/lib/jvm/jdk1.7.0_79/jre/lib/rt.jar:/home/zzb/IdeaProjects/myProject/myThinkinJava/target/classes:/usr/local/idea/idea-IU-172.3968.16/lib/idea_rt.jar com.thinkinjava.myjava.chap06.Ap
```
可以清晰的看到classpath的加载路径，并且java的加载路径就是JDK的安装目录因此使用/usr/lib/jvm/*表示加载所有的jar包

- 编译命令

```
javac -classpath .:/home/zzb/javajardemo/Hello.jar:/usr/lib/jvm/* org/zzb/demo/Test.java
```
- 可以执行一下看一下是否有错

```
java -classpath .:/home/zzb/javajardemo/Hello.jar:/usr/lib/jvm/* org.zzb.demo.Test
```
*同样需要加入classpath*
- 新建manifest文件，内容如下

```
Main-Class: org.zzb.demo.Hello
Class-Path: /home/zzb/javajardemo/Hello.jar
```

当需要引入多个jar包时使用空格分隔
- 对文件夹进行打包

```
jar cvfm Test.jar manifest org/
```

- 执行打包文件

```
java -jar Test.jar
```
