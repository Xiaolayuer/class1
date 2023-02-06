package org.qingqiao.dao;

import org.qingqiao.daen.City;
import org.qingqiao.daen.Demo;
import org.qingqiao.daen.Type;
import org.qingqiao.uitls.JDBCUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemoDao {
    //实例化 JDBCUtil  连接数据库
    Connection conn = JDBCUtil.getConn();

    public ArrayList<Demo> queryAll() {
        ArrayList<Demo> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select d.*,t.name tname from demo d join type t on d.sid = t.sid");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Type type = new Type(rs.getInt(6), rs.getString(7));
                Demo demo = new Demo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),type);
                list.add(demo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Type> queryType() {
        ArrayList<Type> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from type");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Type type = new Type(rs.getInt(1), rs.getString(2));
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int add(Demo demo) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("insert into demo values (null,?,?,?,?,?)");
            ps.setString(1,demo.getName());
            ps.setString(2,demo.getSex());
            ps.setInt(3,demo.getAge());
            ps.setString(4,demo.getHobby());
            ps.setInt(5,demo.getType().getSid());
            i = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public Demo queryById(String id) {
        Demo demo = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select d.*,t.name tname from demo d join type t on d.sid = t.sid where d.id=?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Type type = new Type(rs.getInt(6), rs.getString(7));
                demo = new Demo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return demo;
    }

    public int update(Demo demo) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update demo set name=?,sex=?,age=?,hobby=?,sid=? where id=?");
            ps.setString(1,demo.getName());
            ps.setString(2,demo.getSex());
            ps.setInt(3,demo.getAge());
            ps.setString(4,demo.getHobby());
            ps.setInt(5,demo.getType().getSid());
            ps.setInt(6,demo.getId());
            i = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public int delete(String id) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("delete from demo where id=?");
            ps.setString(1,id);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public ArrayList<City> getCityByPid(String pid) {
        ArrayList<City> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select id,name,pid from city where pid= ?");
            ps.setString(1,pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new City(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
