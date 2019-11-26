package br.com.edu.ifpb.pweb1.dao;

import br.com.edu.ifpb.pweb1.entidades.Produto;


import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOBD {
    public Connection getConnectinon() throws ClassNotFoundException {
        Class.forName ("org.postgresql.Driver");
        try {

            return DriverManager.getConnection( "jdbc:postgresql://localhost:5432/ExercicoRedis", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void escrevendo (Produto produto) throws SQLException, ClassNotFoundException {
        Connection conexao = new ProdutoDAOBD().getConnectinon();
        String query = "INSERT INTO produto (id, nome, preco) VALUES (?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(query);
        statement.setLong(1, produto.getId());
        statement.setString(2, produto.getNome());
        statement.setFloat(3, produto.getPreco());
        statement.executeUpdate();
        statement.close();

        System.out.println("Gravado!");

        conexao.close();
    }
    public Produto buscarProduto (Long id) throws SQLException, ParseException, ClassNotFoundException {
        Connection conexao = new ProdutoDAOBD().getConnectinon();
        Produto produto = new Produto();
        String sql = "SELECT * FROM produto WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
           produto.setId(rs.getLong("id"));
           produto.setPreco(rs.getFloat("preco"));
           produto.setNome(rs.getString("nome"));
        }
        stmt.close();
        conexao.close();
        return produto;
    }

    public List<Produto> listarProdutos() throws Exception {
        Connection conexao = new ProdutoDAOBD().getConnectinon();
        String sql = "SELECT * FROM produto ";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Produto> produtos= new ArrayList<>();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getLong("id"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setNome(rs.getString("nome"));
            produtos.add(produto);
        }
        stmt.close();
        conexao.close();
        return produtos;
    }
}
