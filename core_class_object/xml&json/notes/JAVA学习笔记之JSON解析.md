## JAVA学习笔记之JSON解析

什么是JSON？

JSON: JavaScript Object Notation JS对象简谱 , 是一种轻量级的数据交换格式。
JSON 分为对象格式和数组格式

- 对象格式：以大括号({})包括对象属性，对象属性以键值对的形式存储，键以字符串

  ```json
  {
  	"name":"三国演义",
  	"info":"经典名著"
  }
  ```

  

- 数组形式：以([])包括，但JSON的最外层必须为{}，即为对象格式，只有对象内部的属性才能使用数组形式存储

  ```java
  [元素1,元素2...]
  {
  	"city":["北京","上海","广州"]
  }
  ```

  如何在JAVA中使用JSON

  在开发场景下，我们常常需要使用 JSON 将 Java 中的对象 快速的转换为 JSON 格式的字符串或者将 JSON 格式的字符串, 转换为 Java 的对象。但在 Java 中，官方并没有内置相关 JSON 工具类。
  我们解析 JSON 通常会使用谷歌的 Gson 或者 阿里巴巴的 FastJson 等 Java 库，下面我们以 Gson 和 FastJson 为例解析JSON

  Gson

  - 将对象转换为 JSON 字符串
    - 转换JSON字符串的步骤:
      1. 引入JAR包
      2. 在需要转换JSON字符串的位置编写如下代码即可:
         `String json = new Gson().toJSON(要转换的对象);`

  案例
  Person类：

  

```java
public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
Person person = new Person();
person.setName("张三");
person.setAge(19);
String json = new Gson().toJson(person);
System.out.println(json);//{"name":"张三","age":19}
```

- 将JSON字符串转换为对象

  - 步骤

    1. 引入JAR包
    2. 在需要转换Java对象的位置, 编写如下代码:
       `对象 = new Gson().fromJson(JSON字符串,对象类型.class);`

  - 案例

    

```java
String s = "{\"name\":\"张三\",\"age\":19}";
Person person = new Gson().fromJson(s, Person.class);
System.out.println(person); //Person{name='张三', age=19}
```

如果在中不存在对应的对象，我们可以把 JSON 转换为 Map 集合

- 案例

  ```java
  String s = "{\"name\":\"张三\",\"age\":19,\"parent\":[\"李四\",\"王五\"]}";
  HashMap map = new Gson().fromJson(s, HashMap.class);
  List parent = (List) map.get("parent");
  System.out.println(parent.get(1));
  ```

注意：如果属性值为数组，Gson 会将其自动转换为 List 对象

FastJson

- 将对象转换为JSON字符串
  - 转换JSON字符串的步骤:
    1. 引入JAR包
    2. 在需要转换JSON字符串的位置编写如下代码即可:
       `String json=JSON.toJSONString(要转换的对象);`
  - 案例

```java
Person person = new Person();
person.setName("赵六");
person.setAge(30);
String json = JSON.toJSONString(person);
System.out.println(json);//{"age":30,"name":"赵六"}
```

将JSON字符串转换为对象

- 步骤

  1. 引入JAR包
  2. 在需要转换Java对象的位置, 编写如下代码:
     `类型 对象名=JSON.parseObject(JSON字符串, 类型.class);`
     或
     `List<类型> list=JSON.parseArray(JSON字符串,类型.class);`

- 案例

  ```java
  String s = "{\"age\":30,\"name\":\"赵六\"}";
  Person person = JSON.parseObject(s, Person.class);
  System.out.println(person);//Person{name='赵六', age=30}
  ```

  将 JSON 数组转换为List对象

  ```java
  List<String> list = JSON.parseArray("[\"王五\",\"李四\",\"张三\"]",String.class);
  System.out.println(list.get(1));//李四
  ```

  Gson 与 FastJson 在将对象转换为 JSON 字符串的区别

  - Gson在转换 Person 对象得到的 JSON 字符串是 `{"name":"张三","age":19}`

  - FastJson在转换 Person 对象得到的 JSON 字符串是 `{"age":30,"name":"赵六"}`

  - 从上面就可以看出，两者返回的字符串是有区别的，其键的顺序不同

  - 我们来测试一下它们的排序方式，为 Person 类添加一个 sex 属性
    修改后的 Person 类：

    ```java
    public class Person {
    
    	private String name;
    	private int age;
    	private char sex;
    
    	public Person() {
    	}
    
    	public char getSex() {
    		return sex;
    	}
    
    	public void setSex(char sex) {
    		this.sex = sex;
    	}
    
    
    	public String getName() {
    		return name;
    	}
    
    	public void setName(String name) {
    		this.name = name;
    	}
    
    	public int getAge() {
    		return age;
    	}
    
    	public void setAge(int age) {
    		this.age = age;
    	}
    
    	@Override
    	public String toString() {
    		return "Person{" +
    				"name='" + name + '\'' +
    				", age=" + age +
    				", sex=" + sex +
    				'}';
    	}
    
    	@Override
    	public boolean equals(Object o) {
    		if (this == o) return true;
    		if (o == null || getClass() != o.getClass()) return false;
    		Person person = (Person) o;
    		return age == person.age &&
    				sex == person.sex &&
    				Objects.equals(name, person.name);
    	}
    
    	@Override
    	public int hashCode() {
    		return Objects.hash(name, age, sex);
    	}
    }
    ```

    

Gson：重新将对象转换为JSON字符串

```java
    Person person = new Person();
    person.setAge(19);
    person.setSex('男');
    person.setName("张三");
    String json = new Gson().toJson(person);
    System.out.println(json);//{"name":"张三","age":19,"sex":"男"}
```

从结果我们并不能看出其顺序，我们尝试调整在 Person 类的 sex 属性的声明位置进行调整
原先顺序：

```java
private String name;
private int age;
private char sex;
```

修改后顺序：

```java
private String name;
private char sex;
private int age;
```

我们再进行测试

```java
Person person = new Person();
person.setAge(19);
person.setSex('男');
person.setName("张三");
String json = new Gson().toJson(person);
System.out.println(json);//{"name":"张三","sex":"男","age":19}
```

通过对比我们可以发现通过 Gson 转换得到的 JSON 字符串中的属性是*根据其在对象中的声明顺序进行排序的*

FastJson：

```java
Person person = new Person();
person.setName("赵六");
person.setSex('男');
person.setAge(30);
String json = JSON.toJSONString(person);
System.out.println(json);//{"age":30,"name":"赵六","sex":"男"}
```

从返回结果我们可以看出 FastJson 转换的 JSON 字符串的属性其顺序是是*根据按属性名的ASCll码决定的*