package library.controller.command.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.UrlConstants;
import library.controller.command.Command;

public class PageNotFoundCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		System.out.println("Page not found");
		return UrlConstants.PAGE_NOT_FOUND;
	}

}
