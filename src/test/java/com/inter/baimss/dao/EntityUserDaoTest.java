package com.inter.baimss.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inter.baimss.entities.EntityUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityUserDaoTest {

    @Autowired
    private EntityUserDao entityUserDao;

    @Test
    void testGetById() {
        System.out.println(entityUserDao.selectById(1));
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        entityUserDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }

    @Test
    void testGetBy() {
        QueryWrapper<EntityUser> qw = new QueryWrapper<>();
        qw.like("euname", "宁");
        entityUserDao.selectList(qw);
    }

    @Test
    void testGetByLambda() {
        String euname = "宁";
        LambdaQueryWrapper<EntityUser> lqw = new LambdaQueryWrapper<EntityUser>();
//        need to determine whether it is null
        lqw.like(euname != null, EntityUser::getEuname, euname);
        entityUserDao.selectList(lqw);
    }
}
