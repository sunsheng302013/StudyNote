# UserManager

## 功能介绍

人员管理系统，整合了springboot+mongodb+quartz+mybatis 多数据源切库

## 数据源配置

总共有三个数据源 master,slave,quartz
master:业务主库，存放业务相关数据表，现在主要是人员档案相关的表
slave:子库，暂时无用，项目默认的数据源，如果未在service层添加切库注解，默认是走slave库
quartz:任务管理库，存放任务管理相关的表。