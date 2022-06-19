package com.example.vikum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Getting all the request parameters from
        // index.html
        String name = request.getParameter("name");
        int im = Integer.parseInt(
                request.getParameter("im"));
        String dob
                = request.getParameter("dob");
        String path
                = request.getParameter("path");
        String company
                = request.getParameter("company");

        // GeekUsers object is created
        Users geekUser = new Users();


        geekUser.setName(name);
        geekUser.setIm(im);
        geekUser.setDob(dob);
        geekUser.setPath(path);
        geekUser.setCompany(company);


        // Calling save method in GeekUsersDao by passing
        // geekUser
        int status = UsersDao.save(geekUser);

        // This is possible when the record is saved
        // successfully
        if (status > 0) {
            out.print(" <p>Record saved successfully!</p> ");
            request.getRequestDispatcher("index.html")
                    .include(request, response);
        }
        else {
            // If there is an issue in saving the record, we
            // need to show this message
            out.println("Sorry! unable to save record");
        }

        out.close();
    }
}
