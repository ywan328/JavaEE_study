package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet  extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //局部初始化参数
        System.out.println("TestServlet-init->myparam"+config.getInitParameter("myparam"));
        //全局初始化参数
        System.out.println("TestServlet-init->allparam"+config.getServletContext().getInitParameter("encoding"));

    }


    public TestServlet() {
        System.out.println("TestServlet");
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁");
    }

/*    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }*/

    @Override
    public void init() throws ServletException {
        System.out.println("servlet初始化");
    }

    @Override   //处理get请求的  HttpServletRequest 请求对象  HttpServletResponse 响应对象
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get------");
        ServletContext servletContext = req.getServletContext(); //全局对象
    }

    @Override  //处理post请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post-------");
    }
}
