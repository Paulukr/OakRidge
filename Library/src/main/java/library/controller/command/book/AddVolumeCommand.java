package library.controller.command.book;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.UrlConstants;
import library.controller.command.Command;

public class AddVolumeCommand  implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
    	Enumeration<String> resultE = request.getAttributeNames();
    	String resultA = String.valueOf(request.getAttribute("first_name"));
    	
		Object rawData = request.getAttribute("first_name");
		if(rawData == null)
			return UrlConstants.PAGE_NOT_FOUND;
		String data = String.valueOf(rawData);
		
      try {
		response.getOutputStream().println("<p>doPost atribute </p> + data");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return UrlConstants.HOME;
		}

}
