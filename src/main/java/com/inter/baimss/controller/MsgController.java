package com.inter.baimss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MsgController {
    @RequestMapping(value = "/Msgs", method = RequestMethod.GET)
    @ResponseBody
    public String select() {

        return null;
    }

    @RequestMapping(value = "/Msgs", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody String msgs) {
        System.out.println("msgs is " + msgs);
        return msgs;
    }

    @RequestMapping(value = "/Msgs/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(@PathVariable int id) {
        System.out.println("id is " + id);
        return id;
    }

    @RequestMapping(value = "/Msgs", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody String msgs) {
        System.out.println("msgs is " + msgs);
        return msgs;
    }
}
