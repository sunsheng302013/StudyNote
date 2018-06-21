# springTest_1

标签 ：mybatis

---

## 1.项目架构 ##
demo的整体架构
![demo架构图.png-31.7kB][1]
整个项目分成了三层：
controller层：主要是调用service层中的方法，并对数据进行最终处理，将数据返回给终端。
service层：调用dao层中的方法，并对dao方法返回的数据进行处理。Service层方法主要对业务逻辑进行处理。
dao层：dao层直接对数据库进行操作。dao层的方法往往比较多，理论上数据库的每个操作都需要使用一个dao方法来实现。

分层的意义：
任何一个商业项目的代码量是一个非常巨大的，分层的作用就是将项目中代码职责进行划分，便于梳理代码流程，也方便开发者分工合作。
最基础的分层就是分Controller，Service，Dao三层，但是实际上项目的复杂程度是超乎想象的，三层架构是远远不够的。现在企业开发通常使用maven对项目进行管理。使用maven可以将一个项目按照职责划分为多个小项目，小项目中再按照功能进行分层。

三层架构中Controller通常与终端进行交互的，Service和Dao层都分为接口以及接口的实现类。简单项目可能用不上接口（比如现在这个），但是对于复杂项目而言，接口可以定义业务逻辑，通过其实现类再实现差异化，便于开发和管理，同时业务扩展的时候也方便开发。


## 2.spring配置文件applicationContext.xml ##
spring项目最核心的是spring的配置文件：applicationContext.xml。这个配置文件中要配置spring IOC和AOP的各种配置选项，以及管理其他框架。spring项目启动时会首先读取配置文件，然后扫描整个spring项目代码，根据配置文件将合适的类生成相应的bean。

但是第一个demo中spring并没有和mybatis整合，而且使用注解进行IOC和AOP，所以applicationContext.xml文件非常之简单：只有两句：

```
<!--扫描包中的注解，生成相应bean--> 
<context:component-scan base-package="com.mybatis.*" />

<!-- 开启aop注解方式--> 
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```
而且这个项目并没有使用aop，所以开启aop这个配置都不需要写。

ApplicationContext.xml的复杂程度是随着项目的复杂程度递增的，甚至为了便于查看，还需要根据xml中配置的不同将配置文件分为多个xml。

applicationContext文件配置好之后，运行Main方法

```
package com.mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.controller.TeacherController;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        TeacherController tc = ac.getBean(TeacherController.class);

        tc.deleteTeacher(2);
    }
}
```
在Main方法中通过ClassPathXmlApplicationContext("classpath:applicationContext")就可以获取配置上下文 ApplicationContext ac;
这个时候spring容器已经扫描所有的注解，根据注解生成了Bean对象，
通过ac.getBean("TeacherController.class);
就可以直接获取到TeacherController对象。

## 3.Mybatis配置

### 1.配置文件mybatisConfig.xml
mybatis框架也需要通过一个配置文件来启动，因为这个项目中spring并不管理mybatis，所以mybatisConfig.xml中配置内容相对较多。spring管理mybatis的话，这部分配置内容会转移到applicationContext.xml中。
```
<?xml version="1.0" encoding="UTF-8" ?>    
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">    
<configuration>  
    <!-- 读入properties配置文件 -->  
    <properties resource="database.properties">  
          
    </properties>  
    <!-- 对象别名 -->  
    <typeAliases>  
        <typeAlias type="com.mybatis.pojo.Teacher" alias="Teacher"/>  
        <typeAlias type="com.mybatis.pojo.Course" alias="Course"/>
    </typeAliases>  
    <!-- 数据源配置 -->  
    <environments default="development">  
        <environment id="development">  
            <!-- 事务类型 -->  
            <transactionManager type="JDBC"/>  
            <!-- 数据源 -->  
            <dataSource type="POOLED">  
                <property name="driver" value="${jdbc.driver}"/>  
                <property name="url" value="${jdbc.url}"/>  
                <property name="username" value="${jdbc.username}"/>  
                <property name="password" value="${jdbc.password}"/>  
            </dataSource>  
        </environment>  
    </environments>  
    <!-- 注册xml文件 -->  
    <mappers>  
        <!-- 注册UserMainMapper.xml文件，UserMainMapper.xml位于com.lanhuigu.mybatis.map这个包下，    
            所以resource写成com/lanhuigu/mybatis/map/UserMainMapper.xml-->  
        <mapper resource="com/mybatis/maper/TeacherMapper.xml"/>
        <!-- 将map下的*.java和*.xml都注册到SqlSession实例中
        <package name="com.lanhuigu.mybatis.map"/>   -->  
    </mappers>  
</configuration> 
```
mybatisConfig.xml的主要作用有：
1.设置别名，别名就是将一个类的地址信息com.mybatis.pojo.Teacher，设置成Teacher，主要是在mybatis的映射文件xxxMapper.xml中使用，目的是为了方便输入。
2.配置数据源信息，mybatis连接数据库，需要根据这部分信息与数据库连接。
需要注意的地方是：

### 2.配置数据源信息

```
<!-- 读入properties配置文件 -->  
    <properties resource="database.properties">
```
设置这个之后，mybatis会读取项目中database.properties，resource的位置默认是src下面，所以database.properties在src下面。
database.properties内容为：
```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC
jdbc.username=root
jdbc.password=012315
```

与mybatisConfig.xml中jdbc.driver，jdbc.url，jdbc.username相对应的

```
<dataSource type="POOLED">  
    <property name="driver" value="${jdbc.driver}"/>  
    <property name="url" value="${jdbc.url}"/>  
    <property name="username" value="${jdbc.username}"/>  
    <property name="password" value="${jdbc.password}"/>  
</dataSource> 
 value="${jdbc.driver}" value中也可以直接写相应的值。
```

### 3.映射文件

在mybatisConfig.xml中还需要配置映射文件

```
<mappers>  
    <mapper resource="com/mybatis/maper/TeacherMapper.xml"/>
</mappers>  
```
resource中填写映射文件地址+文件名，映射文件的位置没有规定，可以将映射文件和对应接口放在同一个包下，也可以为映射文件单独建立一个包。推荐第二种，在spring整合时可以一次性扫描所有映射文件。这里使用第一种。

映射文件中主要用于sql查询语句。
一个映射文件对应一个接口，接口中有未实现的方法。
namespace中填写对应的接口，将映射文件和接口关联。

核心标识：
<select>：查询语句填写在<select> sql查询语句</select>中
id：对应映射接口TeacherMapper中的未实现的方法
resultMap：resultMap的名称，据此找到对应的resultMap

<resultMap>：结果集映射的配置标签，返回值类型，这个如果查询语句比较简单，是可以不填写的，对于复杂查询，尤其是多表关联的查询语句，
可以通过resultMap设置返回参数的类型。

type对应的是与查询表关联的实体类。
id="Teacher_Course"指这个result的名称，通过id与<select>关联。

`子元素说明`
id property = "id" column="t_id :这个id用于设置主键字段与领域模型属性的映射关系
result元素 ，用于设置普通字段与领域模型属性的映射关系
association:一对一关系，只有一个查询结果
collection:一对多关系，
这两个关键词主要用于多表关联查询，多表关联查询查出的多个表的结果，为了和表的实体相对应，就需要使用
association,collection这两个关键词。这个比较重要，需要单独写一章，这里就不说了。

```
<mapper namespace="com.mybatis.maper.TeacherMapper">

    <select id = "getTeacher" resultMap = "Teacher_Course">
        select t.id as t_id, t.name as t_name, t.age as t_age, c.courseName as c_courseName 
        from teacher t, course c 
        where t.courseName = c.courseName and t.id = #{id}
    </select>
    
    <resultMap type="com.mybatis.pojo.Teacher" id="Teacher_Course">
            <id property = "id" column="t_id"></id>
            <result property = "name" column = "t_name"/>
            <result property = "age" column = "t_age"/>
            <association property="course" javaType = "Course">
               <result property = "courseName" column = "c_courseName"/>
            </association>
    </resultMap>
    
    <delete id="deleteTeacher" parameterType="int">
        delete from teacher where id = #{id}
    </delete>
</mapper>
```

## 4.代码编写

简单说完架构和相关配置文件的信息，现在讲项目中具体的代码，代码按照我创建项目时先后顺序给大家讲解：

### 1. 创建实体类 Teacher，Course

实体类中参数和数据库表的参数是相同的，映射文件中<resultMap>中property取的是实体类中变量名。

```
//Teacher
public class Teacher {

    public int id;
    public String name;
    public int age;
    public String courseName;
    public Course course;//一个老师对应一个课程 一对一关系
    ....//get,set方法
}

public class Course {

    public int id;
    public String courseName;
    public List<Teacher> teacherList;//一个课程对应多个老师，一对多关系
    ....//get,set方法
}
```

### 2. 创建映射接口

映射接口的作用是和映射文件对接，映射接口中的接口方法与映射文件中select的id相对应。后续项目通过调这个接口的接口方法进行数据库查询。

```
public interface TeacherMapper {

    public Teacher getTeacher(int id);

    public Teacher getTeacher(String name);

    public int deleteTeacher(int id);
}
```

### 3. 创建MybatisUtil类

项目中需要初始化mybatis框架，然后调映射接口进行查询。
为了避免每次查询的时候都需要重复写mybatis加载的代码，我创建了一个工具类，在dao中每次需要查询时调工具类处理mybatis加载的工作。
mybatis加载主要有四步：
1:扫描配置文件mybatisConfig.xml，将配置文件生成输入流InputStream
Util.class.getResourceAsStream("mybatisConfig.xml")

2：创建sqlSessionFactory
SqlSessionFactory sqlSessionFactory=SqlSessionFactoryBuilder().build(inputStream)
3: 创建SqlSession
SqlSession sqlSession = SqlSessionFactory.openSession()
4: 创建映射对象
TeacherMapper tm = sqlSession.getMapper(TeacherMapper.class);
通过映射对象，可以调映射接口中的方法，实现数据库操作。

```
public class MybatisUtil {

    private static SqlSessionFactory factory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (factory == null) {
            InputStream inputStream = MybatisUtil.class.getResourceAsStream("mybatisConfig.xml");//扫描MybatisUtil类所在目录下的mybatisConfig.xml
            return new SqlSessionFactoryBuilder().build(inputStream);
        }
        return factory;
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}
```

### 4. 创建dao类

MybatisUtil类封装了前三个步骤，在dao中调MybatisUtil方法，再根据需要创建不同的映射对象，通过映射对象的方法实现sql操作。

```
@Repository
public class TeacherDaoImpl implements ITeacherDao {
    @Override
    public Teacher getTeacherById(int id) {
        System.out.println("TeacherDaoImpl:getTeacherById");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper tm = sqlSession.getMapper(TeacherMapper.class);
        Teacher t = tm.getTeacher(id);
        return t;
    }
}

```
### 5. 创建service类

Service类比较简单，在我们这个项目中基本上没有什么操作
在项目中作用就是调dao类，然后将结果返回到Controller

```
@Service(value = "teacherService")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    ITeacherDao teacherDaoImpl;

    @Override
    public Teacher getTeacher(int id) {

        return teacherDaoImpl.getTeacherById(id);
    }
}
```

### 6. 创建Controller类

因为不涉及web前端信息交互，所以Controller层也比较简单，和Service层相似。

```
@Controller
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    //通过id查老师信息
    public Teacher getTeacher(int id) {
        Teacher teacher = teacherService.getTeacher(id);
        return teacher;
    }
}

```
### 7. 创建测试类
在web项目中，spring容器的初始化是由tomcat等容器启动的，但是在非web项目中，需要自己加载spring配置文件，对spring进行初始化，spring初始化之后spring注解等功能才会生效。测试类Main主要作用就是加载spring配置文件，初始化spring容器。
```
public class Main {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        TeacherController tc = ac.getBean(TeacherController.class);

        tc.deleteTeacher(2);
    }
}
```

其中最重要的两个步骤是：
1：加载applicationContext.xml文件,生成上下文对象ac
ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
2：获取Controller对象，只有通过上下文对象获取到的bean，这个Controller才能够获取到service对象。
如果通过new 生成的对象，因为没有进行依赖注入，这个对象时没办法调用对象中的Service对象（因为Service对象时通过注解注入的，并不是通过new生成的）


demo地址：https://github.com/hzaucheng/StudyNote/tree/master/6.spring%2Bmybatis%E6%95%B4%E5%90%88/SpringTest_1

[1]: http://static.zybuluo.com/HzauCheck/fdaxcqsps7u9dfnf3srme339/demo%E6%9E%B6%E6%9E%84%E5%9B%BE.png
