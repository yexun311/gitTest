package com.ye.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author yx
 * @since 2022-11-25
 */
public class HelloServlet extends HttpServlet {

    //由于get或者post只是请求实现的不同的方式，可以相互调用，业务逻辑都一样；
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // web容器启动时会为每个web程序创建一个对应的 ServletContext 对象

        //this.getInitParameter(); 初始化参数
        //this.getServletConfig(); Servlet 配置
        //this.getServletContext(); Servlet 上下文
        ServletContext context = this.getServletContext();

        // 在 Servlet 中保存的数据可以在另一个 Servlet 中拿到
        String userName = "yx";
        context.setAttribute("userName", userName);

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //OutputStream outputStream = resp.getOutputStream();
        PrintWriter writer = resp.getWriter();
        writer.print("Hello Servlet!");

    }
}
