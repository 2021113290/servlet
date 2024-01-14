package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//使用这个类处理登录请求
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.从请求中获取到页面提交的用户名和密码
        String username=req.getParameter("username");
        String password=req.getParameter("password");
//      2.验证用户名密码是否正确
//        硬编码，先不用数据库;
//        假定正确的密码是zhangsan 123
        if ("zhangsan".equals(username)&&"123".equals(password)){
//            登陆成功
//            1.创建一个会话
//            getSession:
//            *创建sessionId和一个HttpSession对象；
//            *把这两个内容以键值对的形式插入到内存的 哈希表 中；
//            *把sessionId通过Set-Cookie写到响应中
            HttpSession session=req.getSession(true);
            session.setAttribute("username","zhangsan");
//            2.让响应重定向到主页
            resp.sendRedirect("index");
        }else {
//            登陆失败
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("登陆失败");
        }
    }
}
