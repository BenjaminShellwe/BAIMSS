package com.inter.baimss.controller;

import com.inter.baimss.controller.utils.R;
import com.inter.baimss.entities.EntityUser;
import com.inter.baimss.service.IEntityUniService;
import com.inter.baimss.service.OrderMessageQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/kafkas")
public class OrderMessageQueueController {

    @Autowired
    private OrderMessageQueueService orderMessageQueueService;

    @Autowired
    private IEntityUniService iEntityUniService;

    @PostMapping("/{singleMsg}")
    public void order(@PathVariable String singleMsg) {
        orderMessageQueueService.order(singleMsg);
    }

    @GetMapping("/multiMsg")
    private R setMultiMsg() {
        try{
            orderMessageQueueService.order(iEntityUniService.list());
            log.info("Message to topic: {} Content: {}", "kafkaTopic", iEntityUniService.list());
            return new R(true, "Message has entered the Topic queue.");
        } catch (Exception e) {
            return new R(false, e);
        }
    }
}
