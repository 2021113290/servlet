import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//使用jackson，掌握一个类两个方法
class Student{
//    1.该类属性必须为public或者有public的getter/setter
//    2.该类必须有无参版本的构造方法，如果不写任何构造方法，编译器能自动生成无参构造方法

    public int studentId;
    public String studentName;

    public Student() {
    }
}
@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        假设请求body格式为{studentId:1,studentName:"张三"}
//        jackson提供的核心的雷，readValue方法：把json格式数据转成java对象
//        writeValueAsString把java对象转成json格式字符串
        ObjectMapper objectMapper=new ObjectMapper();
//        第一个参数：字符串/输入流；第二个参数：类对象-》要解析出来的结果的对象的类
//        要求json键值对中的键的名字务必和类的属性名一一对应
        Student s =objectMapper.readValue(req.getInputStream(),Student.class);//1.读取输入流，获取要解析的字符串2.把字符串按照json格式解析，得到一组键值对3.根据类对象，创建一个实例4.遍历类对象中的属性的名字，拿着名字去上述键值对中查询，查到的value赋值到对应的对象的属性中5.返回这个构造完成的对象
//        Student s =objectMapper.writeValueAsString()
        System.out.println(s.studentId);
        System.out.println(s.studentName);
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(s));
//        resp.setContentType("text/html;charset=utf8");
//        resp.getWriter().write(s.studentId+","+s.studentName);
    }
}
