# SpringTest_3：Spring前后端结合

标签： mybatis

---

## 1.项目介绍

项目2中使用spring整合mybatis,项目3在项目2的基础之上，增加了前后端交互的功能。
项目整体架构如下：
![1.png-30.6kB][1]

项目3相比项目2，改变之处主要在增加了配置文件web.xml，并且将applicationContext.xml分成了applicationContext.xml和spring-mvc-servlet.xml这两个文件。mybatisConfig.xml没有修改。
代码中的改变部分：控制层Controller中增加了注解，用于和前端进行交互。
WebContent中增加了前端部分的代码：jsp,css和js代码，这些代码不做具体介绍。

前后端结合最核心的部分在于配置文件的各项配置，尤其是web.xml和applicationContext.xml的配置。
web项目很容易出现问题，这些问题可能是xml配置出了问题，也可能是前后端交互时传递的信息有误，甚至有可能是下载的jar包不合适。

本文主要讲解
1. 核心配置文件的配置项
2. 前端界面和Controller界面的交互过程。

##2. 核心配置文件web.xml

spring项目是在tomcat容器中运行的，如果说applicationContext.xml是spring容器的核心配置文件，那么web.xml就是tomcat容器的核心配置文件。
当启动web项目时，首先tomcat会读取web.xml文件，根据配置文件中的配置项，读取applicationContext.xml和spring-mvc-servlet.xml,进而启动spring容器。

web.xml中核心的配置项
```
<!-- 部署applicationContext的xml文件-->
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/applicationContext.xml</param-value>
</context-param>

<!--ContextLoaderListener的作用就是启动Web容器时，自动装配ApplicationContext的配置信息。因为它实现了ServletContextListener这个接口，在web.xml配置这个监听器，启动容器时，就会默认执行它实现的方法。在ContextLoaderListener中关联了ContextLoader这个类，所以整个加载配置过程由ContextLoader来完成-->

<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

<!-- 定义Spring MVC的前端控制器 DispatcheServlet将会拦截所有url,这些url将会在spring-mvc-servlet.xml中进一步处理-->
<servlet>
	<servlet-name>spring-mvc</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
        <param-name>contextConfigLocation</param-name>
	    <param-value>/WEB-INF/spring-mvc-servlet.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
	<servlet-name>spring-mvc</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```
这是web.xml中最核心的配置项，缺少这些配置项，整个项目都没有办法正常启动。除此之外也会有一些需要用到的功能：web.xml中过滤器配置
配置了过滤器之后，所有的前后端跳转都会经过过滤器，过滤器的主要作用是统一编码格式，避免前后端编码不同导致的中文乱码。
```
<!-- 编码过滤器 -->
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

##3.ApplicationContext.xml
applicationContext.xml基本上和项目2相同，不做任何改变就可以使用，但是为了让每个xml功能明确，在applicationContext.xml中不扫描Controller层的注解，Controller层的注解交给spring-mvc-servlet.xml去扫描。

```
<context:annotation-config/>

<!--6 容器自动扫描IOC组件  -->
<context:component-scan base-package="com.mybatis.*"></context:component-scan>
改为：
<!--6 扫描Service层注解，将Controller的注解排除掉，在spring-mvc-servlet.xml单独扫描Controller注解 -->
<context:component-scan base-package="com.mybatis">
    <context:exclude-filter expression="org.springframework.stereotype.Controller" type="annotation" />
</context:component-scan>
```

##4.spring-mvc-servlet.xml

配置文件名字可以随便取，不过为了和功能相近，建议带有servlet。
xml配置文件的作用是配置前置控制器，当前端url被web.xml中servlet拦截之后，会读取spring-mvc-servlet.xml,扫描Controller层，生成相应的Controller的bean。
```
<!-- 自动扫描该包，SpringMVC会将包下用了@controller注解的类注册为Spring的controller -->
<context:component-scan base-package="com.mybatis" use-default-filters="false">
    <context:include-filter expression="org.springframework.stereotype.Controller" type="annotation" />
    <!-- 在springMVC配置文件中将Service注解给去掉,而由applicationContext.xml父容器进行初始化以保证service的事务的增强处理 -->
    <context:exclude-filter expression="org.springframework.stereotype.Service" type="annotation" />
</context:component-scan>
    
<!-- 设置默认配置方案 -->
<mvc:annotation-driven />

<!-- 此配置告诉DispatcherServlet，对于找不到Controller的请求，就把它交给tomcat的默认处理器自行处理，而tomcat的默认处理器会把请求的资源返回给客户端。 -->
<mvc:default-servlet-handler />
    
<!-- 视图配置器 -->
<bean id="viewResolver"
	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix"><!-- 前缀信息 -->
		<value>/pages/</value>
	</property>
	<property name="suffix"><!-- 后缀信息 -->
		<value>.jsp</value>
	</property>
</bean>
```

##5.Controller层配置
Controller层主要负责前后端交互，需要接收前端传回的信息，也需要将处理好的结果返回给前端。


注解：@RequestMapping("url")
这个注解可以标注在类或者方法之上，根据前端传过来的url判断执行那个方法。像这个URL就是*****/teacher/teacherList，当前端传这个URL过来时就会执行searchAll方法

方法的返回对象是ModelAndView,这个对象将会被视图解析器解析，并将结果返回给前端页面。
其中ModelAndView创建时的字符串将会被视图解析器重新组装成url返回给相应的页面，如 
ModelAndView mav = new ModelAndView("teacherList");这个时候会根据spring-mvc-servlet.xml中的视图配置器组装成：/pages/teacherList.jsp。然后视图解析器加上classpath就构成了一个url，通过url将结果返回给相应的界面。
```
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    @Qualifier("teacherService")
    ITeacherService teacherService;

    @RequestMapping("/teacherList")
    public ModelAndView searchAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("teacherList---->Start");
        List<Teacher> tl = teacherService.getTeacherList();
        System.out.println("查询成功");
        ModelAndView mav = new ModelAndView("teacherList");
        mav.addObject("teacherList", tl);
        return mav;
    }
}
```
  [1]: http://static.zybuluo.com/HzauCheck/27ciyo0lxdzkyel3rgn8zv5r/1.png