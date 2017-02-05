package libray.test.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import library.model.dao.declaration.AuthorDao;
import library.model.dao.implemantation.AuthorDaoImpl;
import library.model.exceptions.AuthorDublicateException;
import library.model.service.AuthorService;

public class AuthorDaoImplTest {
	AuthorDao authorDao;
	@Before
	public void setUp() throws Exception {
		authorDao = AuthorDaoImpl.getInstance();
		AuthorService	serv = AuthorService.getInstance();
		serv.restartBase();
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
