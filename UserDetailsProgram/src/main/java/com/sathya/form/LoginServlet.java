package com.sathya.form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // get the requested data
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");

        UserDao dao = new UserDao();
        User user = dao.login(userName, userEmail);

        // To give the data to JSP, put it in Request
        request.setAttribute("user", user);

        // forward the request to the JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}