package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

import java.io.IOException;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main")) {
			contatos(request, response);
		} else if(action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
	}
	
	//list contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}
	
	//novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//teste de recebimento dos dados do formulário
		// System.out.println(request.getParameter("nome"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.inserirContato(contato);
		
		//redirecionamento - agenda.jsp
		response.sendRedirect("main");

		
	}

}
