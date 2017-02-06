package library.controller.command.book;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.controller.UrlConstants;
import library.controller.ViewConstants;
import library.controller.command.Command;
import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.entity.BookTitle;
import library.model.exceptions.AuthorDublicateException;
import library.model.exceptions.BookDublicateException;
import library.model.exceptions.InvalidInputException;
import library.model.service.AuthorService;
import library.model.service.BookTitleService;
import library.model.service.ServiceFactory;

public class GetBoookFindForm implements Command {
    private static final Logger logger = Logger.getLogger(BookTitleDaoImpl.class);
	public GetBoookFindForm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookTitleService bookTitleService = serviceFactory.getBookTitleService();
		AuthorService authorService = serviceFactory.getAuthorService();
		try {
			BookTitle newBookTitle = bookTitleService.getAddBookTitleRequestData(request);
			authorService.findOrAddAuthors(newBookTitle.getAuthors());
			Integer bookId = bookTitleService.tryAddBookTitle(newBookTitle);
			if (bookId < 0) {
				bookId = -bookId;
				BookTitle bookTitle = bookTitleService.getBookTitleByID(bookId);
	            request.setAttribute(ViewConstants.TITLE_INSTANSE_LIST, new BookTitle[] {bookTitle});
	            request.setAttribute(ViewConstants.ERROR_MESSAGE, ErrorList.BOOK_SUCCESFULLY_ADDED);
	            logger.trace(ErrorList.BOOK_SUCCESFULLY_ADDED + " " +  bookId);
	    		return UrlConstants.R_BOOK_ADD_SUCCESS;
			}else {
				BookTitle bookTitle = bookTitleService.getBookTitleByID(bookId);
	            request.setAttribute(ViewConstants.TITLE_INSTANSE_LIST, new BookTitle[] {bookTitle});
	            request.setAttribute(ViewConstants.ERROR_MESSAGE, ErrorList.BOOK_ALREADY_ADDED);
				return UrlConstants.R_BOOK_ADD_ERROR;
			}
			// find book return
			// add book
		} catch (InvalidInputException | SQLException e) {
            logger.error(ErrorList.ADD_BOOK, e);
            request.setAttribute(ViewConstants.TITLE_INSTANSE_LIST, new BookTitle[] {});
            request.setAttribute(ViewConstants.ERROR_MESSAGE, e.getMessage());
			return UrlConstants.R_BOOK_ADD_ERROR;
		} catch (AuthorDublicateException | BookDublicateException e) {
            logger.error(ErrorList.DUPLICATE_BOOKS, e);
            request.setAttribute(ViewConstants.TITLE_INSTANSE_LIST, new BookTitle[] {});
            request.setAttribute(ViewConstants.ERROR_MESSAGE, e.getMessage());
			return UrlConstants.R_BOOK_ADD_ERROR;
		}
	}

}
