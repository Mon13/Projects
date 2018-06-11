

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class MySqlDataStoreUtilities 
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

public static void insertUser(String username,String password,String usertype){ 
		try{ 

		String insertIntoCustomerRegisterQuery = "INSERT INTO Registration(username,passwords,usertype) " + "VALUES (?,?,?);";

		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery); 
		pst.setString(1,username); 
		pst.setString(2,password); 
		pst.setString(3,usertype); 
		pst.execute(); 

		}
		  catch(Exception e)
		  {}
		}

		public static void insertProduct(String productname,int price,String username){ 


		try{ 

		String insertQuery = "INSERT INTO Cart(productname,productprice,username) " + "VALUES (?,?,?);";

		PreparedStatement pst = conn.prepareStatement(insertQuery); 
		pst.setString(1,productname); 
		pst.setInt(2,price); 
		pst.setString(3,username); 
		pst.execute(); 

		}
		  catch(Exception e)
		  {}
		}



	public static void insertOrder(int orderId,String userName,String creditcard,String address)
	{	
	try
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

		PreparedStatement psmt = conn.prepareStatement("select * from Cart where username = ?");
	    		psmt.setString(1,userName);
	    	  ResultSet rs = psmt.executeQuery();

	    	  //String orderName=(userName.charAt(0))+(Integer.toString(orderId));
	    	  double orderPrice=0.0;
	    	  String orderName="";

        while (rs.next()) {

        orderName= orderName +" "+rs.getString(1)+" "; 
        orderPrice+= (double)rs.getInt(2);
        }


		String insertIntoCustomerOrderQuery = "INSERT INTO CustomerOrders(OrderId,userName,orderName,orderPrice,userAddress,creditCardNo)" + "VALUES (?,?,?,?,?,?);"; 
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		 
		pst.setInt(1,orderId); 
		pst.setString(2,userName); 
		pst.setString(3,orderName); 
		pst.setDouble(4,orderPrice); 
        pst.setString(5,address); 
		pst.setString(6,creditcard); 

		pst.execute();
	}

		catch(Exception e)
		{}
	}

		
		public static int selectUser(String userName) 
	{
		
		int value=0;

	try{ 
		getConnection();
	String selectUsers ="select * from Registration";
	PreparedStatement pst = conn.prepareStatement(selectUsers); 
	ResultSet rs = pst.executeQuery();


	while(rs.next())
	{
		if(userName.equals(rs.getString(1))) 
		{
			value=1;
		}
	
	
	}
	}

	catch(Exception e)
	{} 

		return value;
	}


public static int selectOrderNumb() 
	{
		
		int value=0;

	try{ 
		getConnection();
	String selectOrder ="select MAX(OrderId) from CustomerOrders";
	PreparedStatement pst = conn.prepareStatement(selectOrder); 
	
	ResultSet rs = pst.executeQuery();


	while(rs.next())
	{
	 	value=rs.getInt(1);
	
	}
	}

	catch(Exception e)
	{} 


		return value;
	}


public static void delete(String productname) 
{
try{ 
		getConnection();

 PreparedStatement psmt = conn.prepareStatement("delete from Cart where productname = ?");
	    		psmt.setString(1,productname);
	    	    psmt.execute();

}
catch(Exception e)
	{} 

}

public static void refresh(String username) 
{
try{ 
		getConnection();

 PreparedStatement psmt = conn.prepareStatement("delete from Cart where username = ?");
	    		psmt.setString(1,username);
	    	    psmt.execute();

}
catch(Exception e)
	{} 

}

public static int sum(String username) 
{
	int result=0;
try{ 
		getConnection();

 PreparedStatement psmt = conn.prepareStatement("Select sum(productprice) from Cart where username =?");
	    		psmt.setString(1,username);
	    	   ResultSet rs = psmt.executeQuery();

	    	   while(rs.next())
	{
	 	result=rs.getInt(1);
	
	}

}
catch(Exception e)
	{} 

	return result;

}


public static String productdisplay(String productType) 
{
	String htmlString = "";

 try
{

    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");




              PreparedStatement psmt = conn.prepareStatement("select * from Products where producttype = ?");
                psmt.setString(1,productType);
              ResultSet rs = psmt.executeQuery();

              while(rs.next())
                
            {
                
            htmlString += "<li><div><ul type='none'><li><center> Product ID : "+rs.getString(1)+"</center></li><li><center> Product Name : "+rs.getString(5)+"</center></li><li><center><img width='200px' height='200px' src='images/"+rs.getString(4)+"' /></center></li><li><center>Retailer:"+rs.getString(2)+"</li></center><li><center>Condition:"+rs.getString(6)+"</li></center><li><center>price:$"+rs.getInt(7)+"</li></center></ul></li>";
                
            htmlString +="<form method='post' action='Cart'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><input type='hidden' name='productprice' value='"+rs.getInt(7)+"' /><center><input type='submit' value='Add to cart' size='06'/></center></form>";  

            htmlString +=  "<form method='post' action='WriteReview'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><input type='hidden' name='productprice' value='"+rs.getInt(7)+"'/><input type='hidden' name='retailers' value='"+rs.getString(2)+"'/><input type='hidden' name='producttype' value='"+rs.getString(3)+"'/><center><input type='submit' value='Write Review' size='06'/></center></form>";

            htmlString +=  "<form method='get' action='ViewReview'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><center><input type='submit' value='View Review' size='06'/></center><br><br></form>"; 

            }

        }
        catch (Exception e) {
                e.printStackTrace();
        }

            htmlString +="</ul></div>";

return htmlString;

}

public static String login(String userName, String password) 
{
	String pwd="";
	boolean z=false;
	String msg = "null";
	String userType="";

	try{
      	
		
		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
 		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string"); 
		PreparedStatement psmt = conn.prepareStatement("select * from Registration");
	    
	    ResultSet rs = psmt.executeQuery();
	    
	    while(rs.next())
		{
		  if((rs.getString(1)).equals(userName))
			{
			  pwd = rs.getString(2);
	          userType = rs.getString(3);
			}	    
		}
	
		if(password.equals(pwd))
			{
				z=true;
				
			}   
			
		else{
				msg = "Login Failure! Username or password is incorrect.";
			}
	
		}
		catch (Exception e)
		{
				e.printStackTrace();
		}
	
		if(z)
		return userType;
		else
		return msg;
}

public static String cartdisplay(String username) 
 {
	String htmlString ="";
	 int sum=0;
	try
	{

			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");


 			PreparedStatement psmt = conn.prepareStatement("select * from Cart where username = ?");
	    		psmt.setString(1,username);
	    	  ResultSet rs = psmt.executeQuery();
	    	 

	    	  htmlString +="<center><table style='width:40%''><tr><th>Product Name</th><th>Product Price</th></tr>";

	    	  while(rs.next())
				
			{
				htmlString +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td><form method='get' action='Delete.jsp'><input type='hidden' name='productname' value='"+rs.getString(1)+"'/><input type='Submit' value='Delete'/></form></td></tr>";
				

			}
			sum= MySqlDataStoreUtilities.sum(username); 

		htmlString +="<tr><th>Total</th><th>"+sum+"</th></table>";	


	}
		catch (Exception e)
		{
				e.printStackTrace();
		}

		return htmlString;
 }

public static String display(String username) 
{
	String htmlString="";
try{

			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");
			

			 PreparedStatement psmt = conn.prepareStatement("select * from Cart where username = ?");
	    		psmt.setString(1,username);
	    	  ResultSet rs = psmt.executeQuery();

	    	  htmlString +="<center><table style='width:40%''><tr><th>Product Name</th><th>Product Price</th></tr>";

	    	  while(rs.next())
				
			{
				htmlString +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>";
			}

			htmlString +="</table>";			
			htmlString += "<a href = 'CheckOut'>Check Out";
			htmlString +="</center>";

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	return htmlString;
}

public static String displayOrdersAll() 
{
	String htmlString="";
try{

			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");
			

			 PreparedStatement psmt = conn.prepareStatement("select * from CustomerOrders");
	    
	    	  ResultSet rs = psmt.executeQuery();

	    	  htmlString +="<center><table style='width:40%''><tr><th>Order Id</th><th>User Name</th><th>Order Name</th><th>Order Amount</th></tr>";

	    	  while(rs.next())
				
			{
				htmlString +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getDouble(4)+"</td></tr>";
			}

			htmlString +="</table>";			
			htmlString += "<a href = 'Salesmen'>BACK</a>";
			htmlString +="</center>";

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	return htmlString;
}

public static String displayOrders(String username) 
{
	String htmlString="";
try{

			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");
			

			 PreparedStatement psmt = conn.prepareStatement("select * from CustomerOrders where username = ?");
	    		psmt.setString(1,username);
	    	  ResultSet rs = psmt.executeQuery();

	    	  htmlString +="<center><table style='width:40%''><tr><th>Order Id</th><th>Order Name</th><th>Order Amount</th></tr>";

	    	  while(rs.next())
				
			{
					htmlString +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getDouble(4)+"</td></tr>";
			}

			htmlString +="</table>";			
			htmlString += "<a href = 'Home'>BACK</a>";
			htmlString +="</center>";

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	return htmlString;
}

public static void deleteProduct(String productname) 
{
try{ 
		getConnection();

 PreparedStatement psmt = conn.prepareStatement("delete from Products where productname = ?");
	    		psmt.setString(1,productname);
	    	    psmt.execute();

}
catch(Exception e)
	{} 

}

public static void deleteOrder(String orderid) 
{
try{ 
		getConnection();

 PreparedStatement psmt = conn.prepareStatement("delete from CustomerOrders where orderId = ?");
	    		psmt.setString(1,orderid);
	    	    psmt.execute();

}
catch(Exception e)
	{} 

}



	public static void addOrder(int orderId,String userName,String orderName,String orderPrice,String creditcard,String address)
	{	
	try
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

		
	    	  double orderamt=Double.parseDouble(orderPrice);
	    	 


		String insertIntoCustomerOrderQuery = "INSERT INTO CustomerOrders(OrderId,userName,orderName,orderPrice,userAddress,creditCardNo)" + "VALUES (?,?,?,?,?,?);"; 
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		 
		pst.setInt(1,orderId); 
		pst.setString(2,userName); 
		pst.setString(3,orderName); 
		pst.setDouble(4,orderamt); 
        pst.setString(5,address); 
		pst.setString(6,creditcard); 

		pst.execute();
	}

		catch(Exception e)
		{}
	}

	public static void updateOrder(String orderId,String orderName,String orderPrice,String creditcard,String address)
	{	
	try
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

		int orderno = Integer.parseInt(orderId);
	   double orderamt=Double.parseDouble(orderPrice);
	  
		String insertIntoCustomerOrderQuery = "Update CustomerOrders set orderName = ?,orderPrice = ?,userAddress=?,creditCardNo=? where orderId = ?"; 
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		 
		
	
		pst.setString(1,orderName); 
		pst.setDouble(2,orderamt); 
        pst.setString(3,address); 
		pst.setString(4,creditcard); 
		pst.setInt(5,orderno); 

		pst.execute();
	}

		catch(Exception e)
		{}
	}

public static void addProduct(String productid,String retailers,String producttype,String productimage,String productname,String productcondition,String productprice)
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

public static void updateProducts(String productid,String productname,String productcondition,String productprice)
	{	
	try
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

		int prodprice = Integer.parseInt(productprice);
	 
		String insertIntoCustomerOrderQuery = "Update Products set productname = ?,productcondition=?,productprice = ? where productid = ?"; 
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		
		 
		pst.setString(1,productname); 
        pst.setString(2,productcondition); 
		pst.setInt(3,prodprice);
		pst.setString(4,productid); 
		

		pst.execute();
	}

		catch(Exception e)
		{}
	}


	public static HashMap<String,Product> getProducts()
	{
		HashMap<String,Product> allproducts=new HashMap<String,Product>();
try
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

		
		Product p =new Product();
	 
		String insertIntoCustomerOrderQuery = "Select * from Products"; 
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		ResultSet rs = pst.executeQuery();

              while(rs.next())
                
            {
				

                p.setRetailer(rs.getString(2));
                p.setName(rs.getString(5));
                p.setId(rs.getString(1));
                p.setImage(rs.getString(4));
                p.setCondition(rs.getString(6));
                p.setPrice(rs.getInt(7));
                allproducts.put(rs.getString(5),p);

            }
	
		

		
	}

		catch(Exception e)
		{}

return allproducts;

	}

public static String getDealProducts(HashMap<String,Product> prod)
{
String htmlString ="";

try
{

Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

for(String key : prod.keySet())
{

       
             PreparedStatement psmt = conn.prepareStatement("select * from Products where productname = ?");
                psmt.setString(1,key);
              ResultSet rs = psmt.executeQuery();

              while(rs.next())

                
            {
                
            htmlString += "<li><div><ul type='none'><li><center> Product ID : "+rs.getString(1)+"</center></li><li><center> Product Name : "+rs.getString(5)+"</center></li><li><center><img width='200px' height='200px' src='images/"+rs.getString(4)+"' /></center></li><li><center>Retailer:"+rs.getString(2)+"</li></center><li><center>Condition:"+rs.getString(6)+"</li></center><li><center>price:$"+rs.getInt(7)+"</li></center></ul></li>";
                
            htmlString +="<form method='post' action='Cart'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><input type='hidden' name='productprice' value='"+rs.getInt(7)+"' /><center><input type='submit' value='Add to cart' size='06'/></center></form>";  

            htmlString +=  "<form method='post' action='WriteReview'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><input type='hidden' name='productprice' value='"+rs.getInt(7)+"'/><input type='hidden' name='retailers' value='"+rs.getString(2)+"'/><input type='hidden' name='producttype' value='"+rs.getString(3)+"'/><center><input type='submit' value='Write Review' size='06'/></center></form>";

            htmlString +=  "<form method='get' action='ViewReview'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><center><input type='submit' value='View Review' size='06'/></center><br><br></form>"; 

            }

        }
        }




	catch(Exception e)
		{}

		return htmlString;

}


	
}