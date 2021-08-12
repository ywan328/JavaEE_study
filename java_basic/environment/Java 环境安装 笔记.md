***Java 环境安装 笔记***

**Java体系概括**

Java SE：Java Platform，Standard Edition

标准版：各应用平台的基础，桌面开发和低端商务应用的解决方案。

Java EE：Java Platform，Enterprise Edition 

企业版：以企业为环境而开发应用程序的解决方案 

Java ME ：Java Platform, Micro Edition 

微型版：致力于消费产品 和嵌入式设备的最佳解决方案

**Java 的特性** 

一种纯面向对象的编程语言。 

一种与平台无关（跨平台）的语言。(它提供了在不同平台下运行的解释环境) 

一种健壮的语言，吸收了 C/C++语言的优点。 

有较高的安全性。(自动回收垃圾，强制类型检查，取消指针)

**Java 技术的两种核心机制** 

Java 虚拟机(Java Virtual Machine) JVM 

垃圾回收器(Garbage Collection) GC

**Java** 

**虚拟机(JVM)**

JVM 可以理解成一个可运行 Java 字节码的虚拟计算机系统 

它有一个解释器组件，可以实现 Java 字节码和计算机操作系统之间的通信 

对于不同的运行平台，有不同 的 JVM。

**垃圾回收器(GC)** 

不再使用的内存空间应当进行回收-垃圾回收。 

在 C/C++等语言中，由程序员负责回收无用内存。 

Java 语言消除了程序员回收无用内存空间的责任： 

JVM 提供了一种系统线程跟踪存储空间的分配情况。并在 JVM 的空闲时，检查并释放那些可以被释放的存储空间。 

垃圾回收器在 Java 程序运行过程中自动启用，程序员无法精确控制和干预。

**什么是JDK**

JDK(Java Development Kits)-- Java 开发工具集 

JRE(Java Runtime Environment)Java 运行时环境 

JVM 

Java API (应用程序编程接口) 

 Java 编译器(javac.exe)、Java 运行时解释器(java.exe)、Java 文档化化工具(javadoc.exe)及其它工具及资源

主要功能:

加载代码：由类加载器(class loader)完成； 

校验代码：由字节码校验器(byte code verifier)完成； 

执行代码：由运行时解释器(runtime interpreter)完成。

**JDK概括**

JDK 全称 Java Development ToolKit，是 Java 语言开发工具包。JDK 是整个 JAVA 的核心，包括了 Java 运行环 

境（Java Runtime Environment），一堆 Java 工具（javac/java/jdb 等）和 Java 基础的类库（即 Java API 包括 

rt.jar）。

而目前 Java 11 为最新的 LTS（长期支持）版本 ，所以我们的任务编码采用 JDK11。

注意 安装JDK时一定要记住安装的文件夹的路径!

安装JDK11成功后,需要设置环境变量:

系统环境变量设置:  编辑Path: JDK11安装的文件夹的路径+;

**Eclipse概括**

Eclipse 是一个开放源代码的、基于 Java 的可扩展开发平台。就其本身而言，它只是一个框架和一组服务， 

用于通过插件组件构建开发环境。幸运的是，Eclipse 附带了一个标准的插件集，包括 Java 开发工具（Java 

Development Kit，JDK）。

**Eclipse安装**

步骤 1. (安装) 

eclipse 是一款绿色软件 

, 将下载完毕的 eclipse 压缩包, 解压就完成了安装 . 

步骤 2. (运行) 

打开解压后文件夹中的 eclipse.exe

**eclipse 创建 Java 工程**

创建Java project

**Java最基础的语法**

注释 ：java 程序有三种注释方式 

单行注释：//注释 

多行注释：/*注释*/ 

文档注释：/**注释*/ 

java 代码的位置 

class 必须编写在.java 文件中 （具体详情参考 helloWorld 工程） 

语法规则： 

java 是严格区分大小写的 

java 是一种自由格式的语言 

代码分为结构定义语句和功能执行语句 

功能执行语句的最后必须用分号结束



**代码语句分类**

1.结构定义语句

2.功能执行语句:一般这个语句在结构定义语句里,并且这个语句后面必须以分号结尾!