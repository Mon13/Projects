import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AjaxUtility
{

static Connection conn;
	
public static void getConnection()
{

try
{
 Class.forName("com.mysql.jdbc.Driver").newInstance(); 
 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string"); 
}
catch(Exception e)
{}
}


public static ArrayList selectProduct(){
ArrayList<Product> prodlist =new ArrayList<Product>(); 
try
{
getConnection(); 
Statement stmt=conn.createStatement();
String selectCustomerQuery="select * from Products"; 
ResultSet rs = stmt.executeQuery(selectCustomerQuery); 

while(rs.next()){ 
Product p = new Product(); 
p.setId(rs.getString("productid"));
p.setName(rs.getString("productname"));
prodlist.add(p); 
} 
} 


catch(Exception e)
{}
return prodlist;
}

public static void loadTable(String productid,String retailers,String producttype,String productimage,String productname,String productcondition,String productprice)
	{	
	try
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

	  
		String insertIntoCustomerOrderQuery = "INSERT INTO Products (productid, retailers, producttype,productimage, productname, productcondition,productprice )" + "VALUES (?,?,?,?,?,?,?);"; 
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		 
		int price = Integer.parseInt(productprice);
		pst.setString(1,productid); 
		pst.setString(2,retailers); 
		pst.setString(3,producttype); 
		pst.setString(4,productimage); 
        pst.setString(5,productname); 
		pst.setString(6,productcondition); 
		pst.setInt(7,price); 

		pst.execute();
	}

		catch(Exception e)
		{}
	}

	public static void delete() 
{
try{ 
		getConnection();

 PreparedStatement psmt = conn.prepareStatement("delete from Products where productname = ?");
	    		
	    	    psmt.execute();

}
catch(Exception e)
	{} 

}

} 