package com.inter.baimss.other;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inter.baimss.entities.EntityUser;
import com.inter.baimss.service.IEntityUniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping(value = "/entity-unis")
public class EntityUniController2 {

    @Autowired
    private IEntityUniService iEntityUniService;

    @GetMapping
    public List<EntityUser> getAll() {
        return iEntityUniService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody EntityUser entityUser) {
        return iEntityUniService.save(entityUser);
    }

    @PutMapping
    public Boolean update(@RequestBody EntityUser entityUser) {
        return iEntityUniService.rewrite(entityUser);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return iEntityUniService.removeById(id);
    }

    @GetMapping("/{id}")
    public EntityUser getById(@PathVariable Integer id){
        return iEntityUniService.getById(id);
    }

    @GetMapping("/{currentPge}/{pageSize}")
    public IPage<EntityUser> getPage(@PathVariable int currentPge, @PathVariable int pageSize) {
        return iEntityUniService.getPage(currentPge, pageSize);
    }
}
