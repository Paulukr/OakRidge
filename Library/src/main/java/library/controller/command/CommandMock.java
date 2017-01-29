package library.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandMock implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		return "/index.jsp";
	}

}
