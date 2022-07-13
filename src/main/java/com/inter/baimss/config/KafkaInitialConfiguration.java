package com.inter.baimss.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {

    @Bean
    public NewTopic initialTopic() {
        System.out.println("Topic begin........................");
        return new NewTopic("kafkaTopic001",8, (short) 2 );
    }

    @Bean
    public NewTopic updateTopic() {
        System.out.println("Topic update........................");
        return new NewTopic("kafkaTopic001",10, (short) 2 );
    }
}
