package com.example.vikum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditUserServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        int im=Integer.parseInt(request.getParameter("im"));
        String dob=request.getParameter("dob");
        String path=request.getParameter("path");
        String company=request.getParameter("company");

        Users geekUser=new Users();
        geekUser.setId(id);
        geekUser.setName(name);
        geekUser.setIm(im);
        geekUser.setDob(dob);
        geekUser.setPath(path);
        geekUser.setCompany(company);

        // UsersDao.update method is called
        // along with the modified values for Student
        int status=UsersDao.update(geekUser);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update New Student");
        }

        out.close();
    }

}
