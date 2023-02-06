package org.qingqiao.service;

import org.qingqiao.daen.City;
import org.qingqiao.daen.Demo;
import org.qingqiao.daen.Type;
import org.qingqiao.dao.DemoDao;


import java.awt.*;
import java.util.ArrayList;

public class DemoServletImpl implements DemoService {
    //实例化DemoDao
    private DemoDao demoDao = new DemoDao();

    @Override
    public ArrayList<Demo> queryAll() {
        //调用 DemoDao里的queryAll 方法    return返回执行完方法的结果——>DemoServlet
        return demoDao.queryAll();
    }

    @Override
    public ArrayList<Type> queryType() {
        return demoDao.queryType();
    }

    @Override
    public int add(Demo demo) {
        return demoDao.add(demo);
    }

    @Override
    public Demo queryById(String id) {
        return demoDao.queryById(id);
    }

    @Override
    public int update(Demo demo) {
        return demoDao.update(demo);
    }

    @Override
    public int delete(String id) {
        return demoDao.delete(id);
    }

    @Override
    public ArrayList<City> getCityByPid(String pid) {
        return demoDao.getCityByPid(pid);
    }
}
