package com.inter.baimss.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean state;
    private Object data;
    private String msg;

    public R(){}

    public  R(Boolean state) {
        this.state = state;
    }

    public R(Boolean state, Object data){
        this.state = state;
        this.data = data;
    }

    public R(Boolean state, String msg){
        this.state = state;
        this.msg = msg;
    }
}
