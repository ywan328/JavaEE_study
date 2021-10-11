package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //局部初始化参数
        System.out.println("UsersServlet-init->myparam"+config.getInitParameter("myparam"));
        //全局初始化参数
        System.out.println("UsersServlet-init->allparam"+config.getServletContext().getInitParameter("encoding"));

    }

    @Override   //接收get请求:  超链接
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户传递过来的参数
        String uage = req.getParameter("uage");
        String upass = req.getParameter("upass");
        System.out.println(uage+","+upass);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session
        HttpSession session = req.getSession();
        session.setAttribute("k1","aaa");
        session.getAttribute("k1");
        session.removeAttribute("k1");
        String id = session.getId();
        System.out.println(id);


        //处理post请求的乱码
        req.setCharacterEncoding("utf-8");
        //无论前台传递什么格式的数据，后台都是使用的String接收的
        String username = req.getParameter("username");
        //接收一组数据
        String[] aihaos = req.getParameterValues("aihao");
        for (String aihao : aihaos) {
            System.out.println(aihao);
        }
        System.out.println("post->"+username);
        //前台给后台数据: req.getParameter();
        //后台给前台数据: req.setAttribute("key",value);
        //request存值是单次请求有效
        req.setAttribute("uname",username);
        req.setAttribute("aihao",aihaos);
        Object uname = req.getAttribute("uname");
        //跳转页面
        //转发
        req.getRequestDispatcher("/success.html").forward(req,resp);
        //重定向
        //   resp.sendRedirect("/success.html");
        //响应:服务器端给客户端信息
        // resp.setContentType("text/html");//设置响应的内容
        //resp.addCookie();//设置cookie值存储
        PrintWriter writer = resp.getWriter();//得到一个可以给前端输出信息的输出流对象

    }
}

