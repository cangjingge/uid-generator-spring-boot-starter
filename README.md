### 1.引入jar包

      
```
 <dependency>
            <groupId>com.chungkui</groupId>
            <artifactId>uid-generator-spring-boot-starter</artifactId>
            <version>1.0-bate</version>
        </dependency>
```

        
### 2.spring配置文件,启用配置

  `uid.enable=true  `  

### 3.实现接口     

   `com.baidu.fsg.uid.dao.mapper.WorkerNodeDao`
里面只有一个save方法，保存一个数据，然后返回保存的id即可；
这里就和你使用的数据库框架解耦了；也就是对下面这张表的维护，交给你的项目中自带的技术来实现即可；jar包中不在干扰各自的技术实现


```
DROP DATABASE IF EXISTS `xxxx`;
CREATE DATABASE `xxxx` ;
use `xxxx`;
DROP TABLE IF EXISTS WORKER_NODE;
CREATE TABLE WORKER_NODE
(
ID BIGINT NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
HOST_NAME VARCHAR(64) NOT NULL COMMENT 'host name',
PORT VARCHAR(64) NOT NULL COMMENT 'port',
TYPE INT NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
LAUNCH_DATE DATE NOT NULL COMMENT 'launch date',
MODIFIED TIMESTAMP NOT NULL COMMENT 'modified time',
CREATED TIMESTAMP NOT NULL COMMENT 'created time',
PRIMARY KEY(ID)
)
 COMMENT='DB WorkerID Assigner for UID Generator',ENGINE = INNODB;
```


### 4.开始使用


     
```
  @Autowired
       UidGenerator uidGenerator;
       
       uidGenerator.getUID()
```
