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

public class BookTitleService {

/*	 quik lookUp
	 strait lookUp
	 loose lookUp
	 get authors id (names)
	 get book id (name, authors)

	 	 advanced lookUp
*/


	public Integer tryAddBookTitle(BookTitle bookTitle) throws SQLException {
		Integer bookITitleID =  findBookTitleID(bookTitle);
		if (bookITitleID != null)
			return bookITitleID;
		else
			return -addBookTitle(bookTitle);
	}
	protected Integer addBookTitle(BookTitle bookTitle) throws SQLException {

		try(BookTitleDao bookTitleDao = new BookTitleDaoImpl()) {
			return bookTitleDao.addBookTitle4(bookTitle);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String[] getBookTypes() throws SQLException {
		BookTypeDao bookTypeDao = new BookTypeDaoImpl();
		return bookTypeDao.getBookTypes();
	}
	public BookTitle getBookTitleByID(int id) throws SQLException {
		BookTitleDao bookTitleDao = new BookTitleDaoImpl();
		return bookTitleDao.getBookTitle(id);
	}
	public Integer findBookTitleID(BookTitle bookTitle) throws SQLException {
		java.util.List<Author> authorsList = findOrAddAuthors(
				bookTitle.getAuthors().stream().map(Author::getName).toArray(String[]::new));
		bookTitle.setAuthors(authorsList);
		return findBookTitleID(bookTitle.getTitle(),
				bookTitle.getAuthors().stream().mapToInt(Author::getDatabaseID).toArray());
	}
	public Integer findBookTitleID(String titleName, int...authors) throws SQLException {
		BookTitleDao bookTitleDao = new BookTitleDaoImpl();
		return bookTitleDao.straitLookUp(titleName, authors);
	}

	public Author findOrAddAuthor(String authorName) {
		AuthorDao authorDao = new AuthorDaoImpl();
		if (!authorDao.check_availability(authorName))
			authorDao.addAuthor(authorName);
		int id = authorDao.getNo(authorName);
		Author author = new Author();
		author.setDatabaseID(id);
		author.setFullName(authorName);
		return author;
	}

	public List<Author> findOrAddAuthors(String... authors) {
		java.util.List<Author> authorsList = new ArrayList<>();
		AuthorDao authorDao = new AuthorDaoImpl();

		for (String authorName : authors) {
			if (!authorDao.check_availability(authorName))
				authorDao.addAuthor(authorName);
			int id = authorDao.getNo(authorName);
			Author author = new Author();//TODO constructor
			author.setDatabaseID(id);
			author.setFullName(authorName);
			authorsList.add(author);
		}
		return authorsList;
	}
	public BookTitle getAddBookTitleRequestData(HttpServletRequest request) throws InvalidInputException {

		BookTitle bookTitle = new BookTitle();

		try {
			bookTitle.setTitle(HttpRequestDataProcessor.getSentence(request, ViewConstants.TITLE_NAME));
//			bookTitle.setType(HttpRequestDataProcessor.getWord(request, ViewConstants.TITLE_TYPE_NAME));
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
