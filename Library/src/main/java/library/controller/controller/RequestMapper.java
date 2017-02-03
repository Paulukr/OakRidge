package library.controller.controller;
import org.apache.log4j.Logger;

import library.controller.UrlConstants;
import library.controller.ViewConstants;
import library.controller.command.Command;
import library.controller.command.CommandMapper;
import library.model.entity.BookTitle;

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
    	String requestUri = request.getRequestURI();
    	Command command = commandMapper.getGetCommand(requestUri);
    	String shared = "sharedValueGET";
    	request.setAttribute("sharedId", shared); // add to request

		String result = command.execute(request, response);
    	inspect(request);
        request.getRequestDispatcher(result).forward(request, response);
    	System.out.println(request.getContextPath());
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
		request.getRequestDispatcher(UrlConstants.PAGE_NOT_FOUND).forward(request, response);
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
    	String shared = "sharedValuePOST";
    	request.setAttribute("sharedId", shared); // add to request
    	String requestUri = request.getRequestURI();
    	Command command = commandMapper.getPostCommand(requestUri);
    	String result = command.execute(request, response);
    	String resultB = String.valueOf(request.getAttribute("sharedId"));
    	inspect(request);
        request.getRequestDispatcher(result).forward(request, response);
    }

    private void inspect(HttpServletRequest request){
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
		 String paramName = params.nextElement();
		 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		}

		Enumeration<String> attribs = request.getAttributeNames();
		while(attribs.hasMoreElements()){
		 String attribName = attribs.nextElement();
		 System.out.println("Attribute Name - "+ attribName +", Value - "+request.getAttribute(attribName));
		 if(attribName.equals(ViewConstants.TITLE_INSTANSE))
			 System.err.println("book name: " + ((BookTitle)request.getAttribute(attribName)).getTitle());
		}
    }
}