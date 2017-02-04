package library.controller.command.lib_commands;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.UrlConstants;
import library.controller.ViewConstants;
import library.controller.command.Command;
import library.model.dao.declaration.BookTypeDao;
import library.model.dao.implemantation.BookTypeDaoImpl;
import library.model.entity.BookTitle;
import library.model.service.BookTitleService;
import library.model.service.InvalidInputException;

public class GetBookFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		
		BookTypeDao typeDao = new BookTypeDaoImpl();
		
		BookTitleService service = new BookTitleService();
		try {
			String[] types = typeDao.getBookTypes();
			// find book return
			// add book
            request.setAttribute(ViewConstants.TITLE_TYPES_LIST, types);
		} catch (SQLException e) {
			return UrlConstants.R_BOOK_ADD_ERROR;
		}
		
		return UrlConstants.R_BOOK_ADD;
	}

}
