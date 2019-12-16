package br.com.edu.ifpb.pweb1.dao;

import br.com.edu.ifpb.pweb1.entidades.Produto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoRedis {
    private Jedis jedis = new Jedis();
    private Gson json = new Gson();

    public boolean salvar(List<Produto> cart, String id){
        return jedis.set(""+ id ,json.toJson(cart),
                SetParams.setParams().ex(7200)) != null;
    }
    public List<Produto> buscar(String id){
        String json = jedis.get(""+id);
        Type collectionType = new TypeToken<List<Produto>>() {}.getType();
        List<Produto> lista = this.json.fromJson(json, collectionType);
        return lista;
    }
    public boolean remover ( String id){
        CarrinhoRedis cart = new CarrinhoRedis();
        cart.salvar(cart.buscar(id), id);
        return true;
    }
    public List<Produto> limpar (String id){
        List<Produto> produtoList = buscar(id);
        produtoList.clear();
//        for (int i = 0; i<=produtoList.size(); i++){
//            produtoList.remove(i);
//        }
        return produtoList;
    }
}
