package com.chungkui.uid;

import com.baidu.fsg.uid.UidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerIdAssigner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UidProperties.class)
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
