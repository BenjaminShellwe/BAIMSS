package com.inter.baimss.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inter.baimss.entities.EntityUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityUserServiceTest2 {

    @Autowired
    private IEntityUniService entityUniService;

    @Test
    void testGetById() {
        System.out.println(entityUniService.getById(3));
    }


    @Test
    void testSave() {
       EntityUser entityUser = new EntityUser();
       entityUser.setId(22);
       entityUser.setEutype("testType");
       entityUser.setEudesc("testDesc");
       entityUniService.save(entityUser);
    }

    @Test
    void testUpdate() {
        EntityUser entityUser = new EntityUser();
        entityUser.setId(22);
        entityUser.setEutype("testType123");
        entityUser.setEuname("testName");
        entityUser.setEudesc("testDesc");
        entityUniService.updateById(entityUser);
    }

    @Test
    void testDelete() {
        entityUniService.removeById(22);
    }

    @Test
    void testGetAll() {
        entityUniService.list();
    }

    @Test
    void testGetPage() {
        IPage<EntityUser> page = new Page<>(2, 5);
        entityUniService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
    }


}
