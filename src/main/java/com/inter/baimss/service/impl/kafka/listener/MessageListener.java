package com.inter.baimss.service.impl.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @KafkaListener(topics = "kafkaTopic001")
    public void listener(ConsumerRecord<String,String> record){
        log.info("topic is: {}, offset is: {}, value is: {}", record.topic(), record.offset(), record.value());
        System.out.println("The data to be sent has been included in the Kafka processing queue, message content is：" + record.value());
    }

}
