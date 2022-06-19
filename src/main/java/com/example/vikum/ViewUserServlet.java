package com.example.vikum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<a href='index.html'>Add New Student</a>");
        printWriter.println("<h1>Student List</h1>");

        List<Users> list=UsersDao.getAllGeekUses();

        printWriter.print("<table border='2' bordercolor='#009879' width='60%'");
        printWriter.print("<tr>" +
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>IM NO (IM/2017/___)</th>" +
                "<th>DOB</th>" +
                "<th>Path</th>" +
                "<th>Intern Company Name </th>" +
                "<th>Edit</th>" +
                "<th>Delete</th>" +
                "</tr>");
        for(Users e:list){
            printWriter.print("<tr>" +
                    "<td >"+e.getId()+"</td>" +
                    "<td>"+e.getName()+"</td>" +
                    "<td>"+e.getIm()+"</td>" +
                    "<td>"+e.getDob()+"</td>" +
                    "<td>"+e.getPath()+"</td>" +
                    "<td>"+e.getCompany()+"</td>" +
                    "<td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td>" +
                    "<td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td>" +
                    "</tr>");
        }
        printWriter.print("</table>");

        printWriter.close();
    }
}
