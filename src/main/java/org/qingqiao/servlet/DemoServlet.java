package org.qingqiao.servlet;

import com.alibaba.fastjson.JSON;
import org.qingqiao.daen.City;
import org.qingqiao.daen.Demo;
import org.qingqiao.daen.Type;
import org.qingqiao.service.DemoService;
import org.qingqiao.service.DemoServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    //实例化 service
    private DemoService demoService = new DemoServletImpl();

    //重写service 方法
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收参数
        String m = request.getParameter("m");
        //判断要执行的方法
        if ("query".equals(m)){
            query(request,response);
        }else if ("getType".equals(m)){
            getType(request,response);
        }else if ("add".equals(m)){
            add(request,response);
        }else if ("queryById".equals(m)){
            queryById(request,response);
        }else if ("update".equals(m)){
            update(request,response);
        }else if ("delete".equals(m)){
            delete(request,response);
        }else  if ("getCityByPid".equals(m)){
            getCityByPid(request,response);
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用 demoService里的queryAll方法  返回的值是一个集合  ArrayList<Demo> list
        ArrayList<Demo> list = demoService.queryAll();
        //给list设置一个属性'别名'  u
        request.setAttribute("u", list);
        //将请 求和 响应 转发到demo/list.jsp
        request.getRequestDispatcher("demo/list.jsp").forward(request, response);
    }

    private void queryById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //按id查找
        String id = request.getParameter("id");
        Demo demo = demoService.queryById(id);
        String s = JSON.toJSONString(demo);
        response.getWriter().print(s);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //删除
        String id = request.getParameter("id");
        int i = demoService.delete(id);
        response.getWriter().println(i > 0);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //修改
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String hobby = request.getParameter("hobby");
        String sid = request.getParameter("sid");
        Demo demo = new Demo(Integer.parseInt(id), name, sex, Integer.parseInt(age), hobby, new Type(Integer.parseInt(sid), ""));
        int i = demoService.update(demo);
        response.getWriter().println(i > 0);
    }


    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //添加
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String hobby = request.getParameter("hobby");
        String sid = request.getParameter("sid");
        Demo demo = new Demo(null, name, sex, Integer.parseInt(age), hobby, new Type(Integer.parseInt(sid), ""));
        int i = demoService.add(demo);
        response.getWriter().println(i > 0);
    }

    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询
        ArrayList<Type> list = demoService.queryType();
        //list 转换 json
        String s = JSON.toJSONString(list);
        response.getWriter().println(s);
    }



    private void getCityByPid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        ArrayList<City> list = demoService.getCityByPid(pid);
        String s = JSON.toJSONString(list);
        response.getWriter().println(s);
    }
}
