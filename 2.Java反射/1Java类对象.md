标签：Java反射

#Java反射-Java类对象#
---

[TOC]

##反射概述

Java反射技术是Java核心技术之一，在Java项目尤其是Java框架设计中广泛应用。

Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象的功能称为Java反射机制。
动态调用：Java中对于静态方法可以直接使用类+方法名调用方法，但是对于非静态方法则必须创建类的对象才可以。所谓动态调用就是可以不通过类new一个对象就可以调用类的非静态方法。

Java反射主要提供一下功能：
> * 在运行时判断任意一个对象所属的类
> * 在运行时构建任意一个类的对象
> * 在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用private方法）
> * 在运行时调用任意一个对象的方法

反射jar包中常用到的类：

> * Class类：记录类的信息--java.lang.reflect.Class
> * Package类：记录类所在包的信息--java.lang.reflect.Package
> * Method类：记录类的方法的信息--java.lang.reflect.Method
> * File类：记录类的变量的信息--java.lang.reflect.File
> * Construct类：记录类的构造函数--java.lang.reflect.Construct

---

## Class类 ##

反射中java.lang.reflect.Class类是最重要的一个类，通过这个类可以生成类的类对象，通过类对象获取类的各种信息。

Java反射可以获取的类的内容
> * Class 对象
> * 类名
> * 修饰符
> * 包信息
> * 父类
> * 实现的接口
> * 构造器
> * 方法
> * 变量
> * 注解

---

### 1. 类对象 ###

Java中类可以通过new创建对象，这个对象是类的实例化对象，一个类可以创建许多实例化对象。
同时Java中所有类型（包括基本数据类型）都有一个类对象，这个Class对象是在类加载的过程中JVM创建的，类编译完成之后，在生成的.class文件中就会产生一个Class对象，一个类有且只有一个Class对象。Class对象封装了一个类的类型信息，Java反射本质上就是获取类的Class对象进而对类进行操作。

创建类对象：
1. 知道类名和包名的情况下，使用Class类的forName方法
Class classObject = Class.forName("包名+类名");

2. 只有类的实例化对象时，可以使用对象的getClass方法得到类对象
Class classObject = object.getClass();

3. 知道类名的时候，可以通过类的class方法得到类的类对象 

反射的主要用途就是在引用类的情况下，获取类的信息，所以通常使用第一二种方式，第三种使用比较少。

---

### 2. 类名 ###

获得Class对象之后，可以获取类名,有两种不同方式，获取的结果有不同。

1. 根据getName()方法返回类的全限定类名（包含包名）：
Class classObject = ....//获取Class对象
String className = classObject.getName();

2. 根据getSimpleName()方法返回类的名字（只有类名）
Class ClassObject = ....//获取Class对象
String className = classObject.getSimpleName();

---

### 3. 修饰符 ###

通过Class对象来获取修饰符，即public，static，private等关键词。这些关键词在Class对象中用一个int类型的变量标记。

1. 获取类的修饰符
Class ClassObject = ....//获取Class对象
int modifiers = classObject.getModifiers();

2. 获取方法的修饰符
Class ClassObject = ....//获取Class对象
Method[] method = classObject.getMethods()//获取类中的方法对象
int modifier = method[i].getModifier();//获取修饰符

3. 获取变量的修饰符
Class ClassObject = ....//获取Class对象
File[] file = classObject.getFiles();
int modifier = file[i].getModifier();

4. modifier的值与修饰符的对应关系
    PUBLIC: 1 （二进制 0000 0001） 
    PRIVATE: 2 （二进制 0000 0010） 
    PROTECTED: 4 （二进制 0000 0100） 
    STATIC: 8 （二进制 0000 1000） 
    FINAL: 16 （二进制 0001 0000） 
    SYNCHRONIZED: 32 （二进制 0010 0000） 
    VOLATILE: 64 （二进制 0100 0000） 
    TRANSIENT: 128 （二进制 1000 0000） 
    NATIVE: 256 （二进制 0001 0000 0000） 
    INTERFACE: 512 （二进制 0010 0000 0000）
    ABSTRACT: 1024 （二进制 0100 0000 0000）
    STRICT: 2048 （二进制 1000 0000 0000）

---

### 4. 包信息 ###

获取类所在包,涉及：java.lang.reflect.Package

Class  class = ... //获取Class对象
Package package = classObject.getPackage();

常用方法：

package.getName()//获取包名

---

### 5. 父类 ###

通过Class对象，可以获取类的父类的类对象
Class  classObject = ... //获取Class对象
Class superClass = classObject.getSuperClass();

得到父类的类对象之后，同样可以操作父类的类对象

---

### 6. 实现的接口 ###

通过Class对象，可以获取类实现的接口的类对象
Class  classObject = ... //获取Class对象
Class[] interfaaces = classObject.getInterfaces();
因为类可以实现多个接口，因此getInterfaces()方法返回的是一个Class数组
注意：getInterfaces()方法仅仅只返回当前类所实现的接口。当前类的父类如果实现了接口，这些接口是不会在返回的 Class 集合中的，尽管实际上当前类其实已经实现了父类接口。





