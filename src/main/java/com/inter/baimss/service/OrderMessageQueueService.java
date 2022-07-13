package com.inter.baimss.service;

import com.inter.baimss.entities.EntityUser;

import java.util.List;

public interface OrderMessageQueueService {
    void order(String singleMsg);

    void order(List<EntityUser> list);
}
