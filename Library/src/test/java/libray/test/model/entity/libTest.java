package libray.test.model.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.model.service.BookTitleService;

public class libTest {
	static BookTitleService librarian = new BookTitleService();;
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testfindOrAddAuthor() {
		librarian.findOrAddAuthor("MAN");
	}
	
	@Test
	public void testfindOrAddAuthors() {
		librarian.findOrAddAuthors("MAN", "Lin");
	}
}
