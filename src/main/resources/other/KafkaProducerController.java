package com.inter.baimss.other;

import com.inter.baimss.controller.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/kafkas")
public class KafkaProducerController {

//    真的太晚了，有点累了思路简化，由于对kafka的了解不够，那就借助一般controller的模式向kafka写入生产者数据，再转给消费者
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/Msg")
    @ResponseBody
    public R sendMsg(@RequestParam String msg) {
        try {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("kafkaTopic001", msg);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    System.err.println("kafkaTopic001 - Producer failed to send message: " + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                    System.out.println("kafkaTopic001 - Producer successfully sent the message: " + stringObjectSendResult.toString());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new R(true);
    }

    @GetMapping("test")
    @ResponseBody
    public String test(){
        System.out.println("you are testing an kafka API!");
        return "you are testing an kafka API!";
    }
}
