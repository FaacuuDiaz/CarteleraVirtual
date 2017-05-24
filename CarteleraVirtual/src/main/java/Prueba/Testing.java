package Prueba;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import implementacionesDAO.FactoryDAO;
import interfacesDAO.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class Testing
 */
@WebServlet("/Testing")
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro en el servlet");
		FactoryDAO f = new FactoryDAO();
		System.out.println("crea el factory dao");
		UsuarioDAO usuario = f.getUsuarioDAO();
		
		 //Creo 2 usuarios 
		 UsuarioDAO user = f.getUsuarioDAO();
		 System.out.println("crea el dao del usuario");
		 Usuario u = new Usuario("Nachengue","1234"); 
		 System.out.println("crea el objeto del usuario");
		 user.agregar(u); 
		 System.out.println("hace el persistir del usuario");
		 Usuario u2 =new Usuario("Emilianas","1234");
		 user.agregar(u2);
		 System.out.println("hace el persistir del otro usuario");
		 
		 
		
		/*ResponseEntity<List<Usuario>> usuarios = (ResponseEntity<List<Usuario>>) usuario.recuperarTodos();
		for (Usuario uu : usuarios.getBody()) {
			uu.getUsuario();
		}	*/
	}

}
