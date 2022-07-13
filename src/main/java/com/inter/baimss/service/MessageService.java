package com.inter.baimss.service;

import com.inter.baimss.entities.EntityUser;

import java.util.List;

public interface MessageService {
    void sendMessage(String id);
    String doMessage();
    void sendMessage(List<EntityUser> list);
}
