package libray.test.model.dao;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.entity.Author;
import library.model.entity.BookTitle;

public class BookTitleDaoImplTest {
	static 	BookTitleDaoImpl bookTitleDaoImpl = new BookTitleDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStraitLookUpStringStringArray() {
//		fail("Not yet implemented");
	}

	@Test
	public void testStraitLookUpStringIntegerArray() {
	

		int[] authorsList =  {1,2,3};
//		bookTitleDaoImpl.straitLookUp("California1", authorsList);
		assertEquals(null, bookTitleDaoImpl.straitLookUp("California10", authorsList));
		assertEquals(Integer.valueOf(1), bookTitleDaoImpl.straitLookUp("California1", authorsList));
		assertEquals(Integer.valueOf(2), bookTitleDaoImpl.straitLookUp("California2", authorsList));
//		assertEquals(Integer.valueOf(15), bookTitleDaoImpl.straitLookUp("hello", authorsList ));
		
	}

	@Test
	public void testAddBookTitle() {
//		fail("Not yet implemented");
	
		Author author = new Author();
		author.setDatabaseID(15);
		author.setFullName("Author 15");
		java.util.List<Author> authors = Arrays.asList(author);
		BookTitle book = new BookTitle("hello", "study", 1, 2000,  authors);
		bookTitleDaoImpl.addBookTitle(book);
	}

}
