import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;
import java.lang.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ProductDatabase implements ServletContextListener{
HttpSession session;
@Override
public void contextDestroyed(ServletContextEvent servletContextEvent) {
    try{

        AjaxUtility.delete();
        }
        catch (Exception e)
         {
            e.printStackTrace();
        }  
    
        
    }

       
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    
        
        
    HashMap<Integer, Product> hm=new HashMap<Integer, Product>();
    SaxParser4XMLdataStore prodList= new SaxParser4XMLdataStore("/Users/mounagiri/softwares/apache-tomcat-7.0.34/webapps/csj/ProductCatalog.xml",session);
    //hm=prodList.getList();
    Iterator it = hm.keySet().iterator();

                while (it.hasNext()) 
                {
                    int id = (Integer) it.next();
                    Product prod = (Product) hm.get(id);
                                          
                      try
                        {
                        AjaxUtility.loadTable(prod.getId(),prod.getRetailer(),prod.getType(),prod.getImage(),prod.getName(),prod.getCondition(),Integer.toString(prod.getPrice()));
                        }
                    

                        catch (Exception e) 
                        {
                            e.printStackTrace();
                        }      
    
                 }  
}
}

