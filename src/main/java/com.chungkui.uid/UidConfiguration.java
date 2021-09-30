package com.chungkui.uid;

import com.baidu.fsg.uid.dao.mapper.WorkerNodeDao;
import com.baidu.fsg.uid.service.UidGenerator;
import com.baidu.fsg.uid.service.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerIdAssigner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//启动配置属性
@EnableConfigurationProperties(UidProperties.class)
//保证DemoService接口在
@ConditionalOnBean(WorkerNodeDao.class)
@ConditionalOnProperty(prefix = "uid", value = "enable", matchIfMissing = true)
public class UidConfiguration {

    @ConditionalOnProperty(prefix = "uid", name = "enableCache", havingValue = "true")
    @Bean
    public UidGenerator cacheUidGenerator() {
        return new DefaultUidGenerator();
    }

    @ConditionalOnProperty(matchIfMissing = true, prefix = "uid", name = "enableCache", havingValue = "false")
    @Bean
    public UidGenerator uidGenerator() {
        return new DefaultUidGenerator();
    }
    @Bean
    public WorkerIdAssigner workerIdAssigner(){
        return new DisposableWorkerIdAssigner();
    }
}
