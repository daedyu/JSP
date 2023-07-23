package com.example.studyplan;

import java.io.*;

import JDBC.Jdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AddUser", value = "/AddUser-servlet")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello world</h1>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Jdbc jdbc = new Jdbc();

        String id = request.getParameter("id");
        String passwordValue = request.getParameter("password");
        String emailValue = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/studyPlan";
        String username = "root";
        String password = "root";

        PrintWriter pw = response.getWriter();



        if (jdbc.insert(url, username, password, id, passwordValue, emailValue))
        {
            pw.println(id);
            pw.println(passwordValue);
            pw.println(emailValue);
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("met charset=\"UTF-8\" ");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>성공</h1>");
        }
        else
        {
            pw.println(id);
            pw.println(passwordValue);
            pw.println(emailValue);
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("meta charset=\"UTF-8\" ");
            pw.println("</head>");

            pw.println("<body>");
            pw.println("<h1>false</h1>");
        }
            pw.println("</body>");
            pw.println("</html>");


    }
}