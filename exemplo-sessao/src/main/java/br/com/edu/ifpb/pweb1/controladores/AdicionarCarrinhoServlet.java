package br.com.edu.ifpb.pweb1.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.edu.ifpb.pweb1.dao.CarrinhoRedis;
import br.com.edu.ifpb.pweb1.dao.ProdutosDAO;
import br.com.edu.ifpb.pweb1.entidades.Produto;

@WebServlet("/adicionarCarrinho")
public class AdicionarCarrinhoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		ProdutosDAO produtosDAO = new ProdutosDAO();
		Produto produto = null;
		try {
			produto = produtosDAO.recuperaPorId(id).orElseThrow(() -> new ServletException());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Produto> produtosCarrinho = (List<Produto>) req.getSession().getAttribute("produtosCarrinho");
		if (produtosCarrinho == null) {
			produtosCarrinho = new ArrayList();
		}
		produtosCarrinho.add(produto);
		CarrinhoRedis cart = new CarrinhoRedis();
		cart.salvar(produtosCarrinho, req.getSession().getId());
		req.getSession().setAttribute("produtosCarrinho", cart.buscar(req.getSession().getId()));
		resp.sendRedirect("produtos");
	}
	public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("carrinho.jsp");
	}
}
