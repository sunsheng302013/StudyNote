# springTest_2

标签 ：mybatis

---

## 1项目介绍

在spring项目1中，spring并没有整合mybatis，mybatis容器需要在MybatisUtil类中进行加载。
项目2和项目1最大的区别在于mybatis的加载交给spring来进行。
项目中改变的地方主要是：

1. applicationContext.xml中增加了mybatis的数据源配置。
2. mybatisConfig.xml中去除了数据源配置。
3. 删除了类MybatisUtil
4. 删除映射接口TeacherMapper,在映射文件中将映射的接口改为TeacherDao

项目整体架构图：
![\[图片\]][1]

## 2 applicationContext.xml更新说明

xml中新增内容
1，2两步骤基本上就是将mybatisConfig.xml中的内容复制过来。

3步骤是由spring生成SqlSessionFactoryBean，这步骤会读取mybatisConfig.xml文件。
4步骤则是扫描指定的映射类的接口，然后将生成的SqlSessionFactory与接口关联

```xml
<!--1 指定spring读取db.properties配置 -->
    <context:property-placeholder location="classpath:database.properties"  />

    <!--2 配置数据源 -->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <!--驱动类名 -->
        <property name="driverClassName" value="${jdbc.driver}" />
        <!-- url -->
        <property name="url" value="${jdbc.url}" />
        <!-- 用户名 -->
        <property name="username" value="${jdbc.username}" />
        <!-- 密码 -->
        <property name="password" value="${jdbc.password}" />
    </bean>

    <!--3 会话工厂bean sqlSessionFactoryBean -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 数据源 -->
        <property name="dataSource" ref="datasource"></property>
        <property name="configLocation" value="classpath:mybatisConfig.xml"/>  
    </bean>

    <!--4 自动扫描对象关系映射 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定会话工厂，如果当前上下文中只定义了一个则该属性可省去 -->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
        <!-- 指定要自动扫描接口的基础包，实现接口 -->
        <property name="basePackage" value="com.mybatis.dao"></property>
    </bean>

    <!--5 声明式事务管理 -->
    <!--定义事物管理器，由spring管理事务 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="datasource"></property>
    </bean>

```

## 3 MybatisConfig.xml配置变更

MybatisConfig.xml中将配置源删除
只保留 mybatis别名，和管理的映射文件

## 4 映射文件和dao层变更

项目1中因为没有使用spring管理mybatis,需要创建一个dao层，专门去加载mybatis

项目2中就不再需要通过代码加载mybatis框架了。
因此取消了映射文件关联的映射接口mapper,同时也取消了dao的实现类。将映射文件和dao接口关联。

映射文件中

```xml
<mapper namespace="com.mybatis.mapper.TeacherMapper">
改为：
<mapper namespace="com.mybatis.dao.TeacherDao">
```

## 5 Service层和Controller层变更

Controller层和Service层不用变更任何

Service层通过@Autowired直接引入dao接口。

需要了解的一点是：
一般情况下dao需要有实现类，并且实现类通过注解标示@Component或者@Repository，只有这样Service层通过@Autowired才可以注入dao对象。

但是本项目中dao接口并没有标注注解，而是通过在applicationContext.xml中指明dao的扫描方式

```xml
 <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定会话工厂，如果当前上下文中只定义了一个则该属性可省去 -->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
        <!-- 指定要自动扫描接口的基础包，实现接口 -->
        <property name="basePackage" value="com.mybatis.dao"></property>
    </bean>
```

[项目地址：springTest_2](https://github.com/hzaucheng/StudyNote/tree/master/6.spring%2Bmybatis%E6%95%B4%E5%90%88/SpringTest_2)

  [1]: http://static.zybuluo.com/HzauCheck/nszf2we96s3f2mjvhjcajuy6/K%5D%7B%28H2P1CL9%28%60JD%7DH%29RG7RN.png