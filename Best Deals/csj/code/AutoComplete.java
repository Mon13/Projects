

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.util.HashMap;
import java.util.Iterator;


public class AutoComplete extends HttpServlet {

    private ServletContext context;
    private ComposerData compData = new ComposerData();
    private HashMap composers = compData.getComposers();
	
	

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
		

    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
		
        StringBuffer sb = new StringBuffer();
		
		

        if (targetId != null) {
          
			targetId = targetId.trim().toLowerCase();
        }

     
        if (action.equals("complete")) {

             boolean namesAdded = false;
            if (!targetId.equals("")) {

               Iterator it = composers.keySet().iterator();

                while (it.hasNext()) {
					
			
                   int id = (Integer) it.next();
                    Composer composer = (Composer) composers.get(id);

                    if ( composer.getName().toLowerCase().startsWith(targetId) )
                        {

                        sb.append("<composer>");
                        sb.append("<id>" + composer.getId() + "</id>");
                        sb.append("<name>" + composer.getName() + "</name>");
                        
                        sb.append("</composer>");
                        namesAdded = true;
                    }
                }
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {
            // put the target composer in the request scope to display 
            if ((targetId != null) && composers.containsKey(targetId.trim()) ) {
			
                request.setAttribute("composer", composers.get(targetId.trim()));
                context.getRequestDispatcher("/ProductListing").forward(request, response);
            }
        }
    }
}
