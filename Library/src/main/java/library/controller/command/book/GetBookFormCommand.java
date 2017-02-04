package library.controller.command.book;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.UrlConstants;
import library.controller.ViewConstants;
import library.controller.command.Command;
import library.model.service.BookTitleService;

public class GetBookFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		BookTitleService service = new BookTitleService();
		try {
			String[] types = service.getBookTypes();
			// find book return
			// add book
			request.setAttribute(ViewConstants.TITLE_TYPES_LIST, types);
		} catch (SQLException e) {
			return UrlConstants.R_BOOK_ADD_ERROR;
		}
		return UrlConstants.R_BOOK_ADD;
	}

}
