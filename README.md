## APK后台管理(spring boot)
*  spring.jpa.properties.hibernate.hbm2ddl.auto 属性
> create： 每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
  create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
  update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。
  validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。 5、 none : 什么都不做。

  * war包 命令 mvn clean package  -Dmaven.test.skip=true
  
  
### LOG
#### 10/23
  * 完善上传功能

#### 11/21
* 添加app密码申请api

#### 11/22
* 分离dev,prod 环境配置

#### 11/23
* 调试shiro注解使用

#### 12/1
* 添加app,appapply的删改

### Question
* 用户角色关系 (已处理 11/6)