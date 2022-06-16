package DBConnection;

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DBClass {

	public static void main(String[] args) {

		String textUri = "mongodb://rvtestuser:rvtestuser2021@13.235.249.33:27030/rw_uat_rr_dlr_1";
		MongoClientURI uri = new MongoClientURI(textUri);
		MongoClient m = new MongoClient(uri);
		DB db = m.getDB("rw_uat_rr_dlr_1");
		System.out.println("Success: "+ db);
		
		DBCollection str = db.getCollection("PARTY_MASTER");
		System.out.println(str);
		
		Set<String> AllCollections = db.getCollectionNames();
		System.out.println(AllCollections.size());
		
		
		
	}
}