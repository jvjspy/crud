package chung.crud.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chung.crud.dao.UserDAO;
import chung.crud.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user-management/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void showUserList(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		UserDAO ud = UserDAO.getInstance();
		List<User> users = ud.getAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/view/user-management/user-list.jsp").forward(request, response);
		;
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		UserDAO ud = UserDAO.getInstance();
		User u = ud.getUser(email);
		//
		ud.deleteUser(u);
		response.sendRedirect(getServletContext().getContextPath());
	}

	private void showForm(ServletRequest request, ServletResponse response, String action)
			throws ServletException, IOException {
		if (action == null || (!action.equals("edit") && !action.equals("new")))
			return;
		UserDAO ud = UserDAO.getInstance();
		if (action.equals("edit")) {
			String email = request.getParameter("email");
			User u = ud.getUser(email);
			request.setAttribute("user", u);
			//
		}
		request.getRequestDispatcher("/WEB-INF/view/user-management/user-form.jsp").forward(request, response);
	}

	private void addOrEditUser(HttpServletRequest request, HttpServletResponse response, boolean add)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String intro = request.getParameter("intro");
		User u = new User(email, name, pass, intro);
		UserDAO ud = UserDAO.getInstance();
		if (add) {
			ud.addUser(u);
		} else {
			ud.updateUser(u);
		}
		response.sendRedirect(getServletContext().getContextPath());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = Paths.get(uri).getFileName().toString();
		switch (action) {
		case "delete":
			deleteUser(request, response);
			break;
		case "edit":
		case "new":
			showForm(request, response, action);
			break;
		case "update":
			addOrEditUser(request, response, false);
			break;
		case "add":
			addOrEditUser(request, response, true);
			break;
		default:
			showUserList(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
