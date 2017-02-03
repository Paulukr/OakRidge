package libray.test.model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.hamcrest.core.IsEqual;
import org.hamcrest.number.IsCloseTo;
import org.junit.Before;
import org.junit.Test;

import library.model.dao.ExampleQuery;

public class ExampleQueryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQuery() {
		try {
			assertEquals(ExampleQuery.query() > 2, true);
		} catch (SQLException e) {
			fail("SQL exception");
		}
	}

}
