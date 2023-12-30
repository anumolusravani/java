package com.sathya.form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the requested data 
		String UserId = request.getParameter("userId");
		
		UserDao dao = new UserDao();
		int user = dao.deleteById(UserId);
		
		//To give the data to JSp put in Request 
		request.setAttribute("user", user);
		
		//forward the request to JSP file 
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletion.jsp");
		dispatcher.forward(request, response);
	}

}
