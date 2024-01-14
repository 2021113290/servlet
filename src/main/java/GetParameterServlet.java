import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        获取querystring中的键值对
        String studentId=req.getParameter("studentId");
        String studentName=req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write(studentId+","+studentName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        通过body获取，发个post请求
        req.setCharacterEncoding("utf8");
        String studentId=req.getParameter("studentId");
        String studentName=req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write(studentId+","+studentName);
    }
}
