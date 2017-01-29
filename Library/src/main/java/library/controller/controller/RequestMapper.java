package library.controller.controller;
import org.apache.log4j.Logger;

import library.controller.UrlConstants;
import library.controller.command.Command;
import library.controller.command.CommandMapper;

import java.io.IOException;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main servlet. All of requests go here.
 *
 * @author Anastasia Milinchuk
*/
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
//        response.getOutputStream().println("<p>doPost</p>");
    	Command command = commandMapper.getGetCommand(request.getRequestURI());
        @SuppressWarnings("unused")
		String forwardPage = command.execute(request, response);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
//  if (forwardPage != null) {
//  request.getRequestDispatcher(forwardPage).forward(request, response);
//}
/*        response.sendRedirect("http://localhost:8080/Library/NewFile.html");
response.sendRedirect("/Library/NewFile.html");
response.sendRedirect("/Library/index.jsp");
request.getRequestDispatcher("/NewFile.html").forward(request, response);
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
        

        
    	Command command = commandMapper.getPostCommand(request.getRequestURI());
    	String result = command.execute(request, response);
//        response.getOutputStream().println("<p>doPost</p>");
        
        request.getRequestDispatcher(result).forward(request, response);
    }

    /**
     * Retrieve string with url to page.
     * Execute command, which equal to request url.
     *
     * @param request is request from client
     * @param response is response to client
     * @param command is command that call client
     * @return page url
     * @throws ServletException
     * @throws IOException
     */
    protected String doRequest(HttpServletRequest request, HttpServletResponse response, Command command)
            throws ServletException, IOException {
        try {

            return "normal post";
        } catch (Exception e) {

            return "Exception";
        }
    }
}