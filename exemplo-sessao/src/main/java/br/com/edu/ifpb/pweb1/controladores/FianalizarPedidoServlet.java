package br.com.edu.ifpb.pweb1.controladores;

import br.com.edu.ifpb.pweb1.dao.CarrinhoRedis;
import br.com.edu.ifpb.pweb1.dao.MongoPedidosDAO;
import br.com.edu.ifpb.pweb1.dao.ProdutosDAO;
import br.com.edu.ifpb.pweb1.entidades.Pedido;
import br.com.edu.ifpb.pweb1.entidades.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pedido")
public class FianalizarPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pedido pedido = new Pedido();
        CarrinhoRedis carrinhoRedis = new CarrinhoRedis();
        MongoPedidosDAO mongoPedidosDAO = new MongoPedidosDAO();
        try {
            pedido.setPedido(carrinhoRedis.buscar(req.getSession().getId()));
            pedido.setIdPedido(req.getSession().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mongoPedidosDAO.salvarPedido(pedido);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Produto> produtosCarrinho = carrinhoRedis.limpar(req.getSession().getId());
            carrinhoRedis.salvar(produtosCarrinho, req.getSession().getId());
            req.getSession().setAttribute("produtosCarrinho", produtosCarrinho);
            resp.sendRedirect("produtos");
    }

}
