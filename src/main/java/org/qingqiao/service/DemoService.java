package org.qingqiao.service;

import org.qingqiao.daen.City;
import org.qingqiao.daen.Demo;
import org.qingqiao.daen.Type;

import java.awt.*;
import java.util.ArrayList;

public interface DemoService {
    ArrayList<Demo> queryAll();

    ArrayList<Type> queryType();

    int add(Demo demo);

    Demo queryById(String id);

    int update(Demo demo);

    int delete(String id);

    ArrayList<City> getCityByPid(String pid);
}
