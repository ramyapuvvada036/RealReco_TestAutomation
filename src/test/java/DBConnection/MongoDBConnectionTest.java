package DBConnection;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDBConnectionTest {

	public static void main(String[] args) {

		String auth_pwd = "rvuser@2021", encoded_pwd = "";

		try {
			encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}

		String uri = "mongodb://rvuser:" + encoded_pwd + "@13.235.249.33:27030/?maxPoolSize=20&w=majority";

		MongoClientURI mongoClientURI = new MongoClientURI(uri);
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		MongoDatabase mongoDB = mongoClient.getDatabase("rw_uat_rr_dlr_1_test"); // rw_uat_rr_dlr_1_test Database name
		MongoIterable<String> list = mongoDB.listCollectionNames();
		MongoCursor<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			// String string = (String) iterator.next();
			System.out.println(iterator.next());
		}
		mongoClient.close();
	}
}