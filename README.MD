# 一本糊涂账复刻版

本仓库为一本糊涂账的修改升级，配合原项目使用更配嗷（就是懒得自己再写份说明了，等加上mybatis后可能会补上？

### 原地址

项目原地址	[一本糊涂账][hutubill]

### 改进

- 规范代码写法，通过阿里规范插件检查
- 加入Spring框架支持

### 后期计划

学习mybatis后将DAO层全部替换

### 学习方法

按照原地址的顺序及说明，参考本仓库代码

### 启动方法

MySQL中新建数据库hutubill

并新建表

可通过运行`SQL`目录下的三个sql文件快速创建三个表

在`src/main/resources`目录下添加文件`MySQL-config.properties`

```properties
url=jdbc:mysql://localhost:3306/hutubill
loginName=用户名
password=密码
```



[hutubill]:https://how2j.cn/k/hutubill/hutubill-tutorials/710.html?p=152524