package libray.test.model.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.model.entity.Librarian;

public class libTest {
	static Librarian librarian = new Librarian();;
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
