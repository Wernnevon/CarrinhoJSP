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

@WebServlet("/removerCarrinho")
public class RemoverCarrinhoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		ProdutosDAO produtosDAO = new ProdutosDAO();
		CarrinhoRedis carrinhoRedis = new CarrinhoRedis();
		Produto produto = null;
		try {
			produto = produtosDAO.recuperaPorId(id).orElseThrow(() -> new ServletException());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Produto> produtosCarrinho = carrinhoRedis.buscar(req.getSession().getId());
		if (produtosCarrinho != null && produtosCarrinho.size() > 0) {
			produtosCarrinho.remove(produto);
			carrinhoRedis.salvar(produtosCarrinho, req.getSession().getId());
			req.getSession().setAttribute("produtosCarrinho", carrinhoRedis.buscar(req.getSession().getId()));
			resp.sendRedirect("produtos");
		}
	}
	
}
