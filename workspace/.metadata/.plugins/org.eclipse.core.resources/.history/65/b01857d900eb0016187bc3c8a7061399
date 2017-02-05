package libray.test.model.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.model.dao.implemantation.AuthorDaoImpl;

public class AuthorDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCheck_availability() {
		AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl();
		assertEquals(true, authorDaoImpl.check_availability("Man"));
		assertEquals(false, authorDaoImpl.check_availability("Jan"));
	}

	@Test
	public void testGetNo() {
		AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl();
		assertEquals(1, authorDaoImpl.getNo("Man").intValue());
		assertEquals(2, authorDaoImpl.getNo("Lin").intValue());
	}
	
	@Test
	public void testAddAuthor() {
		AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl();
		authorDaoImpl.addAuthor("Boyd");
		assertEquals(1, authorDaoImpl.getNo("Man").intValue());
		assertEquals(2, authorDaoImpl.getNo("Lin").intValue());
		assertEquals(3, authorDaoImpl.getNo("Boyd").intValue());
	}
	
}
