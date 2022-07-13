package com.inter.baimss.service.impl.kafka;

import com.inter.baimss.entities.EntityUser;
import com.inter.baimss.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceKafkaImpl implements MessageService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void sendMessage(String sengMsg) {
        System.out.println("The data to be sent has been included in the Kafka processing queue, Msg：" + sengMsg);
        kafkaTemplate.send("kafkaTopic001", sengMsg);
    }

    @Override
    public String doMessage() {
        return null;
    }

    @Override
    public void sendMessage(List<EntityUser> list) {
        System.out.println("The data to be sent has been included in the Kafka processing queue, is a list：" + list);
        kafkaTemplate.send("kafkaTopic001", list.toString());
    }
}
