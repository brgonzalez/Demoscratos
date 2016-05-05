package com.itcr.demoscratos.mongodb;

import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class ConnectionMongo {
	
	/*
	 * Este método actualiza el id del forum de un tema, esto para que cualquier usuario
	 * pueda crear una tema en cualquier democracia.
	 * idTopic : id del topic
	 * newIdForum : este debe ser el id del forum a cual se quiere que pertenezca el tema
	 */
	
	public void updateTopic(String idTopic, String newIdForum){		 
        MongoClient mongo = new MongoClient("localhost", 27017);
        @SuppressWarnings("deprecation")
		DB db = mongo.getDB("DemocracyOS-dev");   
        DBCollection collection = db.getCollection("topics");
        DBObject query = new BasicDBObject("_id", new ObjectId(idTopic));
        DBObject update = new BasicDBObject();
        update.put("$set", new BasicDBObject("forum",new ObjectId(newIdForum)));
        collection.update(query, update);
        mongo.close();	
	}
}
