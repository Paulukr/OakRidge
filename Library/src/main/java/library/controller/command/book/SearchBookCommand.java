package library.controller.command.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.UrlConstants;
import library.controller.command.Command;
import library.model.entity.BookTitle;
import library.model.service.BookTitleService;
import library.model.service.InvalidInputException;

public class SearchBookCommand implements Command {

	public SearchBookCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		BookTitleService service = new BookTitleService();
		try {
			BookTitle bookTitle = service.getAddBookTitleRequestData(request);
			// find book return
			// add book
		} catch (InvalidInputException e) {
			return UrlConstants.R_BOOK_ADD_ERROR;
		}
		return UrlConstants.R_BOOK_ADD_SUCCESS;
	}

}
