package com.inter.baimss.other;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inter.baimss.dao.EntityUserDao;
import com.inter.baimss.entities.EntityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityUniServiceImplBak implements EntityUniService {

    @Autowired
    EntityUserDao entityUserDao;

    @Override
    public Boolean save(EntityUser entityUser) {
//        means function return with data and then change it
        return entityUserDao.insert(entityUser) > 0;
    }

    @Override
    public Boolean update(EntityUser entityUser) {
        return entityUserDao.updateById(entityUser) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return entityUserDao.deleteById(id) > 0;
    }

    @Override
    public EntityUser getById(Integer id) {
        return entityUserDao.selectById(id);
    }

    @Override
    public List<EntityUser> getAll() {
        return entityUserDao.selectList(null);
    }

    @Override
    public IPage<EntityUser> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        entityUserDao.selectPage(page, null);
        return page;
    }
}
