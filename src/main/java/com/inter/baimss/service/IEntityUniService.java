package com.inter.baimss.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inter.baimss.entities.EntityUser;

public interface IEntityUniService extends IService<EntityUser> {

    Boolean rewrite(EntityUser entityUser);

    IPage<EntityUser> getPage(int currentPage, int pageSize);

    IPage<EntityUser> getPage(int currentPage, int pageSize, EntityUser entityUser);
}
