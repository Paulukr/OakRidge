package libray.test.model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import library.model.dao.declaration.AuthorDao;
import library.model.dao.implemantation.AuthorDaoImpl;
import library.model.entity.Author;
import library.model.exceptions.AuthorDublicateException;

public class AuthorDaoImplTest {
	AuthorDao authorDao;
	@Before
	public void setUp() throws Exception {
		authorDao = AuthorDaoImpl.getInstance();
	}

	@Test
	public void testGetNo() {
		try {
			assertEquals(1, authorDao.findAuthorID("Man").intValue());
			assertEquals(2, authorDao.findAuthorID("Lin").intValue());
		} catch (SQLException | AuthorDublicateException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testAddAuthor() {

		try {
			assertEquals(1, authorDao.findAuthorID(("Man")).intValue());
			assertEquals(2, authorDao.findAuthorID("Lin").intValue());
			assertEquals(null, authorDao.findAuthorID("Boyd"));
		} catch (SQLException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (AuthorDublicateException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
