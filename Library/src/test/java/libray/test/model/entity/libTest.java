package libray.test.model.entity;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import library.model.exceptions.AuthorDublicateException;
import library.model.service.AuthorService;

public class libTest {
	static AuthorService librarian = AuthorService.getInstance();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testfindOrAddAuthor() {
		try {
			librarian.findAuthorID("MAN");
		} catch (SQLException | AuthorDublicateException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testfindOrAddAuthors() {
		try {
			assertEquals("MAN", librarian.getAuthorByID(1).getName());
			assertEquals(null, librarian.getAuthorByID(10));
		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}
}
