package com.inter.baimss.service.impl;

import com.inter.baimss.entities.EntityUser;
import com.inter.baimss.service.MessageService;
import com.inter.baimss.service.OrderMessageQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderMessageQueueServiceImpl implements OrderMessageQueueService {

    @Autowired
    private MessageService messageService;

    @Override
    public void order(String singleMsg) {
        log.info("Ordering singleMsg starts");
        messageService.sendMessage(singleMsg);
        log.info("Ordering singleMsg end");
    }

    @Override
    public void order(List<EntityUser> list) {
        log.info("Ordering singleMsg starts");
        messageService.sendMessage(list);
        log.info("Ordering singleMsg end");
    }
}
