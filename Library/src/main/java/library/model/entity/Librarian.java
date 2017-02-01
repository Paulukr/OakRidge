package library.model.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;

import library.model.dao.declaration.AuthorDao;
import library.model.dao.declaration.BookTitleDao;
import library.model.dao.declaration.BookTypeDao;
import library.model.dao.implemantation.AuthorDaoImpl;
import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.dao.implemantation.BookTypeDaoImpl;

public class Librarian {
	boolean addVolumeNewTitle() {
		return false;
	}

	boolean addVolumeExistingTitle() {
		return false;
	}

	public boolean addVolume() {
		// volume adds to title, if new title add it first
		// form add title
		// go to author, get id. If new -> new, also check if unique
		// form add volume
		return false;
	}

	public boolean addBookTitle(String title, String type, int tipeNo, int publishedYear, String[] authors) {
		// get authors
		java.util.List<Author> authorsList = findOrAddAuthors(authors);
		
		Integer bookITitleID =  findBookTitleID(title, authorsList.stream().mapToInt(a -> a.getDatabaseID()).toArray());
		if (bookITitleID != null) {
			return false;
		}
		// quik lookUp
		// strait lookUp
		// loose lookUp
		// get authors id (names)
		// get book id (name, authors)

		
		// advanced lookUp

		BookTitle bookTitle = new BookTitle(title, type, tipeNo, publishedYear, authorsList);
		

		
		
		return false;
	}
	public String[] getBookTypes() throws SQLException {
		BookTypeDao bookTypeDao = new BookTypeDaoImpl();
		return bookTypeDao.getBookTypes();
	}
	public Integer findBookTitleID(String titleName, int...authors) {
		BookTitleDao bookTitleDao = new BookTitleDaoImpl();
		return bookTitleDao.straitLookUp(titleName, authors);
	}
	
	public BookTitle geBookTitle(int databaseID) {
		BookTitleDao bookTitleDao = new BookTitleDaoImpl();
		return bookTitleDao.geBookTitle(databaseID);
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
			Author author = new Author();
			author.setDatabaseID(id);
			author.setFullName(authorName);
			authorsList.add(author);
		}
		return authorsList;
	}

}
