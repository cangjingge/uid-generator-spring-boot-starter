引入jar包
       <dependency>
            <groupId>com.chungkui</groupId>
            <artifactId>uid-generator-spring-boot-starter</artifactId>
            <version>1.0-bate</version>
        </dependency>
        
启用配置
    uid.enable=true    
实现接口     
   WorkerNodeDao
开始使用

       @Autowired
       UidGenerator uidGenerator;
       
       uidGenerator.getUID()