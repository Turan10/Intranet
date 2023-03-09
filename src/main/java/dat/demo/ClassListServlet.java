package dat.demo;

import dat.demo.entities.Student;
import dat.demo.entities.User;
import dat.demo.persistence.StudentMapper;
import dat.demo.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClassListServlet", value = "/classlist")
public class ClassListServlet extends HttpServlet {

    public void init() {
        StudentMapper.populateStudents();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            List<Student> studentList = StudentMapper.getAllStudents();
            request.setAttribute("studentList", studentList);

            request.getRequestDispatcher("WEB-INF/classlist.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
