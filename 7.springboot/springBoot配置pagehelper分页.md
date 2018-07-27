# SpringBoot中mybatis分页

## 1. mybatis自带分页

mybatis自带的分页比较简单，主要是通过sql中limit实现分页。

在mapper中sql语句为：

```xml
<select id = "selectAllUser" resultMap = "resultMap">
    select * from tale where 1 = 1
    <if test = "page != null">
        limit #{offset}, #{pageSize}
     </if>
</select>

<select id = "selectCountAllUser" resultMap = "resultMap">
    select count(1) from tale where 1 = 1
</select>

```

其中offset是偏移量，pagesize是查询条数。

这种方式也被称为后端分页，前端指定查询的偏移位置，和分页大小pageSize,后端根据limit查询出当页的数据返回。

基于内存的分页，查出所有记录按照偏移量和limit返回结果。另外mapper中需要判断是否需要分页，另外分页还需要获取总记录数，为此需要再执行一个获取记录总数的查询。因此这种方式需要执行两个查询。

## 2. 使用pageHelper分页插件查询

pageHelper的优点在于，查询的结果会保存在PageInfo对象中，PageInfo对象中保存有记录总数，分页查询的结果。只需要在mapper中写一个查询语句，就可以了。

```xml
<select id = "selectAll" resultMap = "resultMap">
    select * from tale
</select>
```

mapper中写的查询比较简单

```java
public PageInfo<User> getAllUser(int pageNo, int pageSize) {
    PageHelper.start(pageNo, pagesize);
    List<User> userList = userDao.selectAll(pageNo, pageSize);
    PageInfo pageInfo = new PageInfo<User>(userList);
}
```

PageHelper还需要在springBoot中进行配置：
SpringBoot有yml和properties两种配置方式，对于配置pageHelper略微有些不同。

yml方式：

在yml中不需要配置pageHelper,但是需要在项目中添加一个初始化pageHelper的配置类：

```java
@Configuration
public class MybatisConfig {
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
```

properties方式：在application.properties中添加

```properties
#pagehelper
pagehelper.helperDialect=mysql
pagehelper.reasonable=true
pagehelper.support-methods-arguments=true
pagehelper.params=count=countSql
```

## 总结

pageHelper和mybatis自带分页并没有绝对的好坏之分，mybatis自带分页虽然编写的代码量要大一些，复杂一些，但是不容易产生异常。pageHelper虽然能够简化代码量，但是作为一个插件，在使用的时候可能因为自身代码的问题造成分页出错