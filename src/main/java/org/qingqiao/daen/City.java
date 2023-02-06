package org.qingqiao.daen;

import lombok.Data;

@Data
public class City {
    private Integer id;
    private String name;
    private Integer pid;


    public City(Integer id, String name, Integer pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;

    }

    public City() {
    }
}
