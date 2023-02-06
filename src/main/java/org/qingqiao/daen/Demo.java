package org.qingqiao.daen;

import lombok.Data;

@Data
public class Demo {
    //编号
    private Integer id;
    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //爱好
    private String hobby;
    //种类
    private Type type;

    public Demo() {
    }

    public Demo(Integer id, String name, String sex, Integer age, String hobby, Type type) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hobby = hobby;
        this.type = type;
    }
}
