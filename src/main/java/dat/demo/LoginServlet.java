package dat.demo;

import dat.demo.entities.User;
import dat.demo.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void init() {
        UserMapper.populateUserMap();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Først modtager vi requestværdier fra en input form
        String name = request.getParameter("login");
        String password = request.getParameter("password");

        // TODO: Tjek at login + password findes i systemet (DB)
        if (UserMapper.isLoginValid(name, password)) {
            request.setAttribute("message", "Login: " + name + " is valid");
            User user = UserMapper.getUserByLogin(name);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            request.setAttribute("message", "Login: " + name + " is not valid");
        }


        //Forward til index.jsp siden
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
