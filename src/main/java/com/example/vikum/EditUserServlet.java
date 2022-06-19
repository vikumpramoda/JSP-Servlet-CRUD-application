package com.example.vikum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Student</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        Users e=UsersDao.getUsersById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        out.print("<tr><td>IM/2017:</td><td><input type='text' name='im' value='"+e.getIm()+"'/></td></tr>");
        out.print("<tr><td>DOB:</td><td><input type='date' name='dob' value='"+e.getDob()+"'/></td></tr>");
        out.print("<tr><td>Path :</td>" +
                "<td><input type='text' name='path' value='"+e.getPath()+"'/></td>" +
                "</tr>");
        out.print("<tr><td>Intern Company : </td>" +
                "<td>" +
                "<input type='text' name='company' value='"+e.getCompany()+"'/>" +
                "</td>" +
                "</tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
