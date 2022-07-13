package com.inter.baimss.other;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inter.baimss.entities.EntityUser;

import java.util.List;

public interface EntityUniService {
    Boolean save(EntityUser entityUser);
    Boolean update(EntityUser entityUser);
    Boolean delete(Integer id);
    EntityUser getById(Integer id);
    List<EntityUser> getAll();
    IPage<EntityUser> getPage(int currentPage, int pageSize);

}
