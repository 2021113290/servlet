import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//浏览器query string传个参数
//        如果type=1，返回200，type为2，返回404，type为3，返回500
        String type=req.getParameter("type");
        if (type.equals("1")){
            resp.setStatus(200);
        }else if (type.equals("2")){
            resp.setStatus(404);
            resp.sendError(404);
        }else if (type.equals("3")){
            resp.setStatus(500);
        }else {
            resp.setStatus(504);
        }
    }
}
