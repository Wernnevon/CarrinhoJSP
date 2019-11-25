package br.com.edu.ifpb.pweb1.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.edu.ifpb.pweb1.dao.ProdutosDAO;
import br.com.edu.ifpb.pweb1.entidades.Produto;

@WebServlet("/produtos")
public class ProdutosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdutosDAO produtosDAO = new ProdutosDAO();
		List<Produto> produtos = null;
		try {
			produtos = produtosDAO.listarProdutos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("produtos", produtos);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
