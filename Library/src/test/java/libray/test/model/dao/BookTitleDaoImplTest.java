package libray.test.model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.entity.Author;
import library.model.entity.BookTitle;
import library.model.exceptions.BookDublicateException;
import library.model.service.AuthorService;

public class BookTitleDaoImplTest {
	static 	BookTitleDaoImpl bookTitleDaoImpl;
	@Before
	public void setUp() throws Exception {
		bookTitleDaoImpl = BookTitleDaoImpl.getInstance();
		AuthorService	serv = AuthorService.getInstance();
		serv.restartBase();
	}

	@Test
	public void testStraitLookUpStringStringArray() {
//		fail("Not yet implemented");
	}

	@Test
	public void testStraitLookUpStringIntegerArray() {


		int[] authorsList =  {1};
//		bookTitleDaoImpl.straitLookUp("California1", authorsList);
		try {
			assertEquals(null, bookTitleDaoImpl.straitLookUp("California10", authorsList));
			assertEquals(Integer.valueOf(1), bookTitleDaoImpl.straitLookUp("California1", authorsList));
			assertEquals(Integer.valueOf(2), bookTitleDaoImpl.straitLookUp("California2", authorsList));
			assertEquals(Integer.valueOf(2), bookTitleDaoImpl.straitLookUp("California2", authorsList));
//			assertEquals(Integer.valueOf(15), bookTitleDaoImpl.straitLookUp("hello", authorsList ));
		} catch (SQLException e) {
			fail(e.toString());
		} catch (BookDublicateException e) {
			fail(e.toString());
		}



	}

	@Test
	public void testAddBookTitle() {


		Author author = new Author();
		author.setDatabaseID(15);
		author.setFullName("Author 15");
		java.util.List<Author> authors = Arrays.asList(author);
		BookTitle book = new BookTitle("hello", "study", 1, 2000,  authors);
		try {
			bookTitleDaoImpl.addBookTitle(book);
		} catch (SQLException e) {
			fail(e.toString());
		}
	}

	@Test
	public void testGetBookTitle() {

		Author author = new Author("Author", 0);
		java.util.List<Author> authors = Arrays.asList(author);
		BookTitle book1 = new BookTitle("hello2", "study", 1, 2000,  authors);
		Integer bookId = 0;
		BookTitle book2;
		try {
			bookId = bookTitleDaoImpl.addBookTitle(book1);
			book2 = bookTitleDaoImpl.getBookTitle(bookId);
			// be aware of trailing spaces !
			assertEquals(book1.getTitle().toString(), book2.getTitle().toString());
		} catch (SQLException e) {
			fail(e.toString());
		}

		book1 = new BookTitle("Буквар", "study", 1, 2000,  authors);
		bookId = 0;
			try {
			bookId = bookTitleDaoImpl.addBookTitle(book1);
			book2 = bookTitleDaoImpl.getBookTitle(bookId);
			assertEquals(book1.getTitle().toString(), book2.getTitle().toString());
		} catch (SQLException e) {
			fail(e.toString());
		}
	}

}
