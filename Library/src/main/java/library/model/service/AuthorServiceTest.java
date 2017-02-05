package library.model.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.model.entity.Author;
import library.model.exceptions.AuthorDublicateException;

public class AuthorServiceTest {
	public AuthorService serv;

	@Before
	public void setUpBeforeClass() throws Exception {
		serv = AuthorService.getInstance();
	}

	@Test
	public void testTryAddAuthor() {
		Author author = new Author("Man", 0);

		try {
			serv.tryAddAuthor(author);
			assertEquals(true, null != serv.getAuthorByID(1));
		} catch (SQLException | AuthorDublicateException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testFindAuthorID() {
		Author author3 = new Author("Yan", 0);

		try {
			assertEquals(1, serv.findAuthorID("Man").intValue());
			serv.tryAddAuthor(author3);
			assertEquals(3, serv.findAuthorID("Yan").intValue());
		} catch (SQLException | AuthorDublicateException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetAuthorByID() {
		Author author = new Author("Man", 0);
		try {
			assertEquals(author.getName(), serv.getAuthorByID(1).getName());
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

}
