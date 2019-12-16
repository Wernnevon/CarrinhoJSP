package br.com.edu.ifpb.pweb1.dao;


import br.com.edu.ifpb.pweb1.entidades.Pedido;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoPedidosDAO {
    private MongoClientSettings settings;
    private CodecRegistry pojoCodecRegistry;

    public MongoPedidosDAO(){
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        settings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).build();
    }

    public void salvarPedido(Pedido pedido) throws ClassNotFoundException {
        try(MongoClient client = MongoClients.create(settings)){
            MongoDatabase database = client.getDatabase("exer");
            MongoCollection<Pedido> collection = database.getCollection("pedido",Pedido.class);
            collection.insertOne(pedido);
        }
    }




}
