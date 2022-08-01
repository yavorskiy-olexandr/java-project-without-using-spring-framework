package ua.lviv.lgs.servlet;
/*
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserService.getUserService();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		userService.safeUser(new User(firstName, lastName, email, password));
		HttpSession session = request.getSession(true);
		
		session.setAttribute("userEmail", email);
		session.setAttribute("userFirstName", email);
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		
		userService.saveUser(new User(firstName, lastName, email, password));
		request.setAttribute("userEmail", email);		
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}*/

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.ProductServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	ProductService productService = ProductServiceImpl.getProductService();
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();
	private double getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		
		if(!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
			userService.create(new User(email, firstName, lastName, UserRole.USER.toString(), password));
		}
		request.setAttribute("userEmail", email);
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}