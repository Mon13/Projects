

import java.io.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.lang.*;

public class MongoDbDataStoreUtilities
{

public static void insertReview(String productName,String productCategory, int productPrice ,String retailerName,String retailerZip,String retailerCity, String retailerState, String productSale,String manufactureName,String manufactureRebate,String userName,int userAge, String userGender, String userOccu, int reviewRating,String reviewDate,String reviewText)
{


	MongoClient mongo;
	
	
     	
mongo = new MongoClient("localhost", 27017);
		
	

DB db = mongo.getDB("CustomerReviews");
			
			DBCollection myReviews = db.getCollection("myReviews");

			BasicDBObject doc = new BasicDBObject("title", "MongoDB")
					.append("ProductModelName", productName)
					.append("ProductCategory",productCategory)
					.append("productPrice", productPrice)
					.append("RetailerName", retailerName)
					.append("RetailerZip", retailerZip)
					.append("RetailerCity", retailerCity)
					.append("RetailerState", retailerState)
					.append("ProductOnSale", productSale)
					.append("ManufactureName",manufactureName)
					.append("ManufactureRebate",manufactureRebate)
					.append("UserID", userName)
					.append("UserAge",userAge)
					.append("UserGender", userGender) 
					.append("UserOccupation", userOccu)
					.append("ReviewRating", reviewRating)
					.append("ReviewDate", reviewDate)
					.append("ReviewText", reviewText);

			myReviews.insert(doc);
             return;
}

public static String viewReview(String pName)
{
	MongoClient mongo;
     	
mongo = new MongoClient("localhost", 27017);

DB database = mongo.getDB("CustomerReviews");
			
			DBCollection myReviews = database.getCollection("myReviews");
			
			String value = "ProductModelName";
			BasicDBObject query = new BasicDBObject();
			query.put(value, pName);

			DBCursor cursor = myReviews.find(query);


String htmlPage="<html><head> </head><body><div style='background-color:#DE2D3A;height:100px'></div><hr><h1> Reviews For:"+ pName+ "</h1><br><br><hr>";
			

			if(cursor.count() == 0){
				htmlPage+=("No reviews for this product");
			}else{
			
				htmlPage+="<table>";
				
				String productName = "";
				String productCategory = "";
				String productPrice = "";
				String rName = "";
				String rZip = "";
				String rCity = "";
				String rState = "";
				String pSale = "";
				String mName =  "";
				String mRebate = "";
				String userName = "";
				String uAge = "";
				String uGender = "";
				String uOccu = "";
				String reviewRating = "";
				String reviewDate = "";
				String reviewText = "";
				
				while (cursor.hasNext()) {
					
					BasicDBObject inst = (BasicDBObject) cursor.next();				
					
					htmlPage+="<tr>";
					htmlPage+="<td> Product Name: </td>";
					productName = inst.getString("ProductModelName");
					htmlPage+="<td>" +productName+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Product Category: </td>";
					productCategory = inst.getString("ProductCategory");
					htmlPage+="<td>" +productCategory+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Product Price: </td>";
					productPrice = inst.getString("productPrice");
					htmlPage+="<td>" +productPrice+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Retailer Name: </td>";
					rName = inst.getString("RetailerName");
					htmlPage+="<td>" +rName+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Retailer Zip: </td>";
					rZip = inst.getString("RetailerZip");
					htmlPage+="<td>" +rZip+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Retailer City: </td>";
					rCity = inst.getString("RetailerCity");
					htmlPage+="<td>" +rCity+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Retailer State: </td>";
					rState = inst.getString("RetailerState");
					htmlPage+="<td>" +rState+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Product on Sale: </td>";
					pSale = inst.getString("ProductOnSale");
					htmlPage+="<td>" +pSale+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Manufacture Name: </td>";
					mName = inst.getString("ManufactureName");
					htmlPage+="<td>" +mName+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Manufacture Rebate: </td>";
					mRebate = inst.getString("ManufactureRebate");
					htmlPage+="<td>" +mRebate+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> User Name: </td>";
					userName = inst.getString("UserID");
					htmlPage+="<td>" +userName+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> User Age: </td>";
					uAge = inst.getString("UserAge");
					htmlPage+="<td>" +uAge+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> User Gender: </td>";
					uGender = inst.getString("UserGender");
					htmlPage+="<td>" +uGender+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> User Occupation: </td>";
					uOccu = inst.getString("UserOccupation");
					htmlPage+="<td>" +uOccu+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Review Rating: </td>";
					reviewRating = inst.getString("ReviewRating").toString();
					htmlPage+="<td>" +reviewRating+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Review Date: </td>";
					reviewDate = inst.getString("ReviewDate");
					htmlPage+="<td>" +reviewDate+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Review Text: </td>";
					reviewText = inst.getString("ReviewText");
					htmlPage+="<td>" +reviewText+ "</td>";
					htmlPage+="</tr>";
					htmlPage+="<td></td>";
					

					
				}
			}	
				htmlPage+="</table>";
				htmlPage+="</body>";
				htmlPage+="</html>";

				return htmlPage;

}

public static String maxRating()
{

	MongoClient mongo;
	mongo = new MongoClient("localhost", 27017);
	DB db = mongo.getDB("CustomerReviews");
	DBCollection myReviews = db.getCollection("myReviews");

	int returnLimit= 5;
	String tableData = " ";
	BasicDBObject q1 = new BasicDBObject();
	BasicDBObject q2 = new BasicDBObject();
	q2.put("ReviewRating",-1);

String htmlPage="";
	DBCursor dbCursor= myReviews.find(q1).limit(returnLimit).sort(q2);
	htmlPage+="<H2> TOP FIVE LIKED PRODUCTS BASED ON THE REVIEWS </H2>";
	htmlPage+="<table><TH>PRODUCT NAME </TH><TH>RATING </TH>";
	
	while (dbCursor.hasNext())
	 {
                BasicDBObject dbobj = (BasicDBObject) dbCursor.next();
	htmlPage+="<tr><td>"+dbobj.getString("ProductModelName")+"</td>";
	htmlPage+="<td>"+dbobj.getString("ReviewRating")+"</td></tr>";

	}
htmlPage+="</table>";

return htmlPage;
}





}