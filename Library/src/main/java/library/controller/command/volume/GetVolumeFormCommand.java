package library.controller.command.volume;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.controller.UrlConstants;
import library.controller.ViewConstants;
import library.controller.command.Command;
import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.entity.BookTitle;
import library.model.exceptions.InvalidInputException;
import library.model.service.BookTitleService;
import library.model.service.HttpRequestDataProcessor;
import library.model.service.ServiceFactory;

public class GetVolumeFormCommand implements Command {
	private static final Logger logger = Logger.getLogger(BookTitleDaoImpl.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookTitleService bookTitleService = serviceFactory.getBookTitleService();
		try {
			int bookTitleDatabaseID = HttpRequestDataProcessor.getInt(request, ViewConstants.TITLE_INSTANSE_INDEX);
			if (bookTitleService.getBookTitleByID(bookTitleDatabaseID) != null)
				return UrlConstants.C_GET_VOLUME_ADD_FORM;
		} catch (InvalidInputException e) {
			logger.error(ErrorList.INVALID_INPUT, e);
			request.setAttribute(ViewConstants.ERROR_MESSAGE, ErrorList.BOOK_NOT_CHOSEN + e.getMessage());
		} catch (SQLException e) {
			logger.error(ErrorList.INTERNAL_ERROR, e);
			request.setAttribute(ViewConstants.ERROR_MESSAGE, ErrorList.INTERNAL_ERROR + e.getMessage());
		}
		logger.error(ErrorList.INVALID_INPUT);
		return UrlConstants.C_GET_BOOK_SEARCH_FORM;
	}

}
