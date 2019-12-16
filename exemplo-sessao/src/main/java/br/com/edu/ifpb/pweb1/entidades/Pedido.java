package br.com.edu.ifpb.pweb1.entidades;

import java.util.List;

public class Pedido {
    private String idPedido;
    private List<Produto> pedido;

    public Pedido() {
    }

    public Pedido(String id, List<Produto> pedido) {
        this.idPedido = id;
        this.pedido = pedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public List<Produto> getPedido() {
        return pedido;
    }

    public void setPedido(List<Produto> pedido) {
        this.pedido = pedido;
    }
}
