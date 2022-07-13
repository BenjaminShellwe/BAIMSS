package com.inter.baimss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inter.baimss.dao.EntityUserDao;
import com.inter.baimss.entities.EntityUser;
import com.inter.baimss.service.IEntityUniService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityUniServiceImpl extends ServiceImpl<EntityUserDao, EntityUser> implements IEntityUniService {

    @Autowired
    private EntityUserDao entityUserDao;

    @Override
    public Boolean rewrite(EntityUser entityUser) {
        return entityUserDao.updateById(entityUser) > 0;
    }

    @Override
    public IPage<EntityUser> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        entityUserDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<EntityUser> getPage(int currentPage, int pageSize , EntityUser entityUser) {
        LambdaQueryWrapper<EntityUser> lqw = new LambdaQueryWrapper<EntityUser>();
        lqw.like(Strings.isNotEmpty(entityUser.getEutype()), EntityUser::getEutype, entityUser.getEutype());
        lqw.like(Strings.isNotEmpty(entityUser.getEuname()), EntityUser::getEuname, entityUser.getEuname());
        lqw.like(Strings.isNotEmpty(entityUser.getEudesc()), EntityUser::getEudesc, entityUser.getEudesc());
        IPage page = new Page(currentPage, pageSize);
        entityUserDao.selectPage(page, lqw);
        return page;
    }
}
