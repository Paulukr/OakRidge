package library.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.http.HttpServletRequest;

import library.controller.ViewConstants;
import library.model.dao.declaration.AuthorDao;
import library.model.dao.declaration.BookTitleDao;
import library.model.dao.declaration.BookTypeDao;
import library.model.dao.implemantation.AuthorDaoImpl;
import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.dao.implemantation.BookTypeDaoImpl;
import library.model.entity.Author;
import library.model.entity.BookTitle;
import library.model.exceptions.BookDublicateException;
import library.model.exceptions.InvalidInputException;

public class BookTitleService {
	protected BookTitleDao bookTitleDao = BookTitleDaoImpl.getInstance();
	protected BookTypeDao bookTypeDao = BookTypeDaoImpl.getInstance();

	/*
	 * quik lookUp strait lookUp loose lookUp get authors id (names) get book id
	 * (name, authors)
	 *
	 * advanced lookUp
	 */
	protected BookTitleService() {
	}

	private static class LazyHolder {
		private static final BookTitleService INSTANCE = new BookTitleService();
	}

	public static BookTitleService getInstance() {
		return LazyHolder.INSTANCE;
	}

	public Integer tryAddBookTitle(BookTitle bookTitle) throws SQLException, BookDublicateException {
		Integer bookITitleID = findBookTitleID(bookTitle);
		if (bookITitleID != null)
			return bookITitleID;
		else
			return -addBookTitle(bookTitle);
	}

	protected Integer addBookTitle(BookTitle bookTitle) throws SQLException {
		return bookTitleDao.addBookTitle(bookTitle);
	}

	public String[] getBookTypes() throws SQLException {
		return bookTypeDao.getBookTypes();
	}

	public BookTitle getBookTitleByID(int id) throws SQLException {
		return bookTitleDao.getBookTitle(id);
	}

	public Integer findBookTitleID(BookTitle bookTitle) throws SQLException, BookDublicateException {
		bookTitle.setAuthors(bookTitle.getAuthors());
		return findBookTitleID(bookTitle.getTitle(),
				bookTitle.getAuthors().stream().mapToInt(Author::getDatabaseID).toArray());
	}

	public Integer findBookTitleID(String titleName, int... authors) throws SQLException, BookDublicateException {
		return bookTitleDao.straitLookUp(titleName, authors);
	}

	public BookTitle getAddBookTitleRequestData(HttpServletRequest request) throws InvalidInputException {
		BookTitle bookTitle = new BookTitle();
		try {
			bookTitle.setTitle(HttpRequestDataProcessor.getSentence(request, ViewConstants.TITLE_NAME));
			// bookTitle.setType(HttpRequestDataProcessor.getWord(request,
			// ViewConstants.TITLE_TYPE_NAME));
			bookTitle.setTypeNo(HttpRequestDataProcessor.getInt(request, ViewConstants.TITLE_TYPE_NO));
			bookTitle.setPublishedYear(HttpRequestDataProcessor.getYear(request, ViewConstants.TITLE_YEAR));
			bookTitle.setAuthor(HttpRequestDataProcessor.getSentence(request, ViewConstants.TITLE_AUTHOR));

			// logger.info(LoggingMessagesHolder.SUCCESSFUL_PICK_DATA);
			return bookTitle;
		} catch (InvalidInputException invalidInputException) {
			// TODO log
			throw invalidInputException;
		}
	}
}
