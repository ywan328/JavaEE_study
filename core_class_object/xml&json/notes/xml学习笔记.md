# xml学习笔记

1:xml的概述

　　　1.1 xml是什么
　　　　　标记语言:语言中出现了<a></a>的标签
　　　　　　a:HTML 超文本标记语言 （语法非常严格，不能随意的定义标签）
　　　　　　b:XML 可扩展的标记语言(用户可以根据自己的需求，随意的定义标签)
　　　　　　<垃圾></垃圾>
　　　　　开发的组织:w3c 开源精神 HTML XML Java Script
　　　　　版本:使用 1.0

　　1.2 xml有什么用
　　　　a:存储数据
　　　　b:作为配置文件
　　1.3 xml怎么用


2:xml的语法
　　2.1 文档声明
　　　　<?xml version="1.0" encoding="UTF-8"?> encode：编码 decode：解码
　　　　1) 文档声明必须为<?xml开头，以?>结束；
　　　　2) 文档声明必须从文档的0行0列位置开始；
　　　　3) 文档声明只有2个属性：
　　　　　　a) versioin：指定XML文档版本。只会选择1.0；
　　　　　　b) encoding：指定当前文档保存时编码方式。可选属性，默认值是UTF-8；

　　2.2 元素(element)
　　　　1. 元素是XML文档中最重要的组成部分， 开始标签 元素体 结束标签
　　　　2. 普通元素的结构开始标签、元素体、结束标签组成。例如：<hello> 大家好 </hello>
　　　　3. 元素体：元素体可以是元素，也可以是文本，例如：<b><a>你好</a></b>
　　　　4. 空元素：元素没有元素体,空元素只有开始标签，而没有结束标签，但元素必须自己闭合，例如：<c/>
　　　　5. 元素命名：
　　　　　　a) 区分大小写
　　　　　　b) 不能使用空格，不能使用冒号:
　　　　　　c) 不建议以XML、xml、Xml开头
　　　　6. 格式化良好的XML文档，必须只有一个根元素。除了根元素，所有元素必须被其他元素包含


　　2.3 属性(attribute)
　　　　1. 属性是元素的一部分，它必须出现在元素的开始标签中
　　　　2. 属性的定义格式：属性名=属性值，其中属性值必须使用单引或双引
　　　　3. 一个元素可以有0~N个属性，但一个元素中不能出现同名属性
　　　　4. 属性名不能使用空格、冒号等特殊字符，且必须以字母开头


　　　　属性和子元素的选择
　　　　　　a:如果你描述的数据是对元素唯一的标识(id)，则应该放在属性中
　　　　　　b:如果你描述的数据需要进行再次扩展，必须放在子元素中
　　2.4 注释
　　　　XML的注释，以“<!--”开始，以“-->”结束。注释内容会被XML解析器忽略！
　　　　a)注释不能放在文件的第一行
　　　　b)注释的快捷键
　　　　　　注释 ：ctrl + shift + /
　　　　　　反注释 ：ctrl + shift + \
　　2.4 转义字符
　　　　 转义字符
　　　　　　因为很多符号已经被XML文档结构所使用，所以在元素体或属性值中想使用这些符号就必须使用转义字符，例如：“<”、“>”、“’”、“””、“&”。
　　　　　　< --> &lt;
　　　　　　> --> &gt;
　　　　　　" --> &quot;
　　　　　　' --> &apos;
　　　　　　& --> &amp
　　2.5 CDATA区
　　　　　　<![CDATA[
　　　　　　任意内容
　　　　　　]]>
　　　　当你的标签内容有大量的转义字符时，则可以使用CDATA区，一次性全部转义


3:xml的约束
　　xml约束:xml中的标签默认是可以随便扩展，这样就造成了xml的随意性太大，为了给xml一个统一 的规范,就必须使用xml约束

　　3.1 DTD约束
　　　　DTD（Document Type Definition），文档类型定义
　　　　　　约束：标签的名字，标签的属性，标签的顺序
　　　　　　我们的任务就是根据已经提供好的DTD约束文档来定义xml文件

　　3.2 DTD约束步骤
　　　　　步骤1：创建bean-dtd.xml文档，并将“bean.dtd”拷贝相同目录下
　　　　　步骤2：从DTD文档开始处，拷贝需要的“文档声明”
　　　　　步骤3：完成xml内容编写

　　3.4 DTD的文档声明
　　　　1: 内部DTD，在XML文档内部嵌入DTD，只对当前XML有效。
　　　　　　<?xml version="1.0" encoding="utf-8" ?>
　　　　　　<!DOCTYPE beans [
　　　　　　... //具体的语法
　　　　　　]>
　　　　　　<beans>
　　　　　　</beans>

　　　　2: 本地DTD，DTD文档在本地系统上，公司内部自己项目使用。
　　　　　　<?xml version="1.0" encoding="utf-8" ?>
　　　　　　<!DOCTYPE beans SYSTEM"bean.dtd">
　　　　　　<beans>
　　　　　　</beans>

　　　　3: 外部DTD—公共DTD，DTD文档在网络上，一般都有框架提供。
　　　　　　需要有网络，当第一次使用之后，则会在本地缓存。
　　　　　　<?xml version="1.0" encoding="UTF-8"?>
　　　　　　<!-- DTD的名字-->
　　　　　　<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
　　　　　　<!-- DTD的网络位置-->
　　　　　　"http://www.springframework.org/dtd/spring-beans-2.0.dtd">
　　　　　　<beans>

　　3.5 元素
　　　　<!ELEMENT 元素名 元素描述>
　　　　?:可以出现，但只能出现一次
　　　　*:允许出现多次，也可以是0次
　　　　+:该对象至少出现一次，但可以是多次
　　　　,:元素按照指定的顺序出现

　　　　//------------------------------------------
　　　　根元素:beans 而且有两个子元素：bean(0次或多次) 和import(0次或多次,而且必须按照指定的顺序出现
　　　　#PCDATA:表示元素体是文本

　　　　<!ELEMENT beans (bean*,import*) >
　　　　<!ELEMENT bean (property*)>
　　　　<!ELEMENT property (#PCDATA)>

　　　　<!ELEMENT import (#PCDATA)>

　　　　bean有三个属性:id className type
　　　　<!ATTLIST bean id ID #REQUIRED
　　　　className CDATA #REQUIRED
　　　　type CDATA #IMPLIED
　　　　>

　　　　<!ATTLIST property name CDATA #REQUIRED
　　　　value CDATA #REQUIRED
　　　　>

　　　　<!ATTLIST import resource CDATA #REQUIRED>

 


　　3.2 Schema约束
　　　　Schema是新的XML文档约束；
　　　　Schema要比DTD强大很多，是DTD 替代者；
　　　　Schema本身也是XML文档，但Schema文档的扩展名为xsd，而不是xml。
　　　　Schema 功能更强大，数据类型更完善
　　　　Schema 支持名称空间
　　3.3 约束文档和XML关系
　　　　W3C提出Schema约束规范时，就提供“官方约束文档”。我们通过官方文档，必须“自定义schema 约束文档”，开发中“自定义文档”由框架编写者提供。我们提供“自定义文档”限定，编写出自己的xml文档。
　　3.3 命名空间
　　　　默认的命名空间
　　　　xmlns="http://www.itcast.cn/bean"
　　　　显式的命名空间
　　　　xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
　　　　使用标签时，必须加前缀


　　4:xml解析
　　　　就是取出xml存储的数据(属性和文本)
　　　　<!-- xml文件-->

　　　　常用API如下：
　　　　1. SaxReader对象
　　　　　　a) read(…) 加载执行xml文档
　　　　2. Document对象
　　　　　　a) getRootElement() 获得根元素
　　　　3. Element对象
　　　　　　a) elements(…) 获得指定名称的所有子元素。可以不指定名称
　　　　　　b) element(…) 获得指定名称第一个子元素。可以不指定名称
　　　　　　c) getName() 获得当前元素的元素名
　　　　　　d) attributeValue(…) 获得指定属性名的属性值
　　　　　　e) elementText(…) 获得指定名称子元素的文本值
　　　　　　f) getText() 获得当前元素的文本内容