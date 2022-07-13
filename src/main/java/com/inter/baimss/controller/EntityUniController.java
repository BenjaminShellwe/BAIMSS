package com.inter.baimss.controller;

import com.inter.baimss.controller.utils.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inter.baimss.entities.EntityUser;
import com.inter.baimss.service.IEntityUniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/entity-unis")
public class EntityUniController {

    @Autowired
    private IEntityUniService iEntityUniService;

    @GetMapping
    public R getAll() {
        log.debug("de");
        log.info("in");
        log.warn("wa");
        log.error("er");
        return new R(true, iEntityUniService.list());
    }

    @PostMapping
    public R save(@RequestBody EntityUser entityUser) {
        return new R(iEntityUniService.save(entityUser));
    }

    @PutMapping
    public R update(@RequestBody EntityUser entityUser) {
        return new R(iEntityUniService.rewrite(entityUser));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(iEntityUniService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, iEntityUniService.getById(id));
    }

    @GetMapping("/{currentPge}/{pageSize}")
    public R getPage(@PathVariable int currentPge, @PathVariable int pageSize, EntityUser entityUser) {
        IPage<EntityUser> page = iEntityUniService.getPage(currentPge, pageSize, entityUser);
        if ( currentPge > page.getPages()) {
            page = iEntityUniService.getPage((int)page.getPages(), pageSize, entityUser);
        }
        return new R(true, page);
    }
}
