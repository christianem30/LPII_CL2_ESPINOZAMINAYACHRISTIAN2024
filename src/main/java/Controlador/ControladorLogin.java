package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControladorLogin
 */
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClassUsuarioImp userDAO;

    public void init() {
        userDAO = new ClassUsuarioImp();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        TblUsuariocl2 usuario = new TblUsuariocl2(username, password);

        if (userDAO.ValidarUsuario(usuario)) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("/MenuPrincipal.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
	}

}
