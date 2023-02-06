package org.qingqiao.daen;

import lombok.Data;

@Data
public class Type {
    //编号
    private Integer sid;
    //姓名
    private String name;

    public Type(Integer sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public Type() {
    }
}
