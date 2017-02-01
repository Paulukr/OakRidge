package library.controller.controller;
import org.apache.log4j.Logger;

import library.controller.UrlConstants;
import library.controller.command.Command;
import library.controller.command.CommandMapper;

import java.io.IOException;
import java.util.Enumeration;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("unused")
@WebServlet("/map/*")
public class RequestMapper extends HttpServlet {
	CommandMapper commandMapper = new CommandMapper();



    /**
     * This method obtain all GET request
     *
     * @param request is request from client
     * @param response is response to client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	
//    	Enumeration<String> resultE = request.getAttributeNames();
//    	String resultA = String.valueOf(request.getParameter("first_name"));
    	
    	Command command = commandMapper.getGetCommand(request.getRequestURI());
 
    	String shared = "sharedValueGET";
    	request.setAttribute("sharedId", shared); // add to request
    	
		String result = command.execute(request, response);
        request.getRequestDispatcher(result).forward(request, response);
    	System.out.println(request.getContextPath());
    	System.out.println(request.getContextPath());
//        request.getRequestDispatcher(UrlConstants.PAGE_NOT_FOUND).forward(request, response);
    }

/*   
 *   if (forwardPage != null) {
 *		request.getRequestDispatcher(forwardPage).forward(request, response);
 *		}
 * 		response.getOutputStream().println("<p>doPost</p>");
 *      response.sendRedirect("http://localhost:8080/Library/NewFile.html");
		response.sendRedirect("/Library/NewFile.html");
		response.sendRedirect("/Library/index.jsp");
		request.getRequestDispatcher("/NewFile.html").forward(request, response);
*       response.getOutputStream().println("<p>doPost</p>");
*/

    /**
     * This method obtain all of POST request.
     *
     * @param request is clients request
     * @param response is response to client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	Enumeration<String> resultE = request.getAttributeNames();
    	String resultA = String.valueOf(request.getAttribute("first_name"));
    	
    	Command command = commandMapper.getPostCommand(request.getRequestURI());

    	String result = command.execute(request, response);
     
    	String shared = "sharedValuePOST";
    	request.setAttribute("sharedId", shared); // add to request
    	
    	String resultB = String.valueOf(request.getAttribute("sharedId"));
    	
        request.getRequestDispatcher(result).forward(request, response);
    }
}