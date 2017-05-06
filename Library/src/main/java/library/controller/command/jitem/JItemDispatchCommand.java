package library.controller.command.jitem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.controller.UrlConstants;
import library.controller.ViewConstants;
import library.controller.command.Command;
import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.exceptions.InvalidInputException;
import library.model.service.HttpRequestDataProcessor;
import library.model.service.JItemService;
import library.model.service.ServiceFactory;

public class JItemDispatchCommand implements Command {
	private static final Logger logger = Logger.getLogger(BookTitleDaoImpl.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		JItemService jItemService = serviceFactory.getJItemService();
		try {
			int jitemDatabaseID = HttpRequestDataProcessor.getInt(request, ViewConstants.JITEM_MODEL_INDEX);
			int jItemQuantity = HttpRequestDataProcessor.getInt(request, ViewConstants.JITEM_QUANTITY);

			int result = jItemService.getJItemDispatch(jitemDatabaseID, jItemQuantity);
			request.setAttribute(ViewConstants.JITEM_DISPATCH_RESULT, result);
			return UrlConstants.JITEMRESULT;

		} catch (InvalidInputException e) {
			logger.error(ErrorList.INVALID_INPUT, e);
			request.setAttribute(ViewConstants.ERROR_MESSAGE, ErrorList.BOOK_NOT_CHOSEN + e.getMessage());
		}
		logger.error(ErrorList.INVALID_INPUT);
		return UrlConstants.C_GET_BOOK_SEARCH_FORM;
	}

}
