package br.com.edu.ifpb.pweb1.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.edu.ifpb.pweb1.entidades.Produto;

public class ProdutosDAO {
	
	public List<Produto> listarProdutos() throws Exception {
		ProdutoDAOBD produtoDAOBD = new ProdutoDAOBD();
		return produtoDAOBD.listarProdutos();
	}
	
	public Optional<Produto> recuperaPorId(Long id) throws Exception {
		return listarProdutos().stream().filter( produto -> produto.getId().equals(id)).findFirst();
	}

}
