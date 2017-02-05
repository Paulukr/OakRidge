package library.controller.command;

import junit.framework.TestCase;
import library.controller.UrlConstants;

public class CommandMapperTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testGetGetCommand() {
		CommandMapper cMapper = new CommandMapper();
		Command com = cMapper.getGetCommand("notest");
		assertNotNull(cMapper);
		com = cMapper.getGetCommand("notest");
		assertNotNull(cMapper);
		com = cMapper.getGetCommand(UrlConstants.PAGE_NOT_FOUND);
		assertNotNull(cMapper);
		assertEquals("/WEB-INF/responses/PageNotFound.jsp", com.execute(null, null));
		com = cMapper.getGetCommand(UrlConstants.HOME);
		assertNotNull(cMapper);
		assertEquals("/WEB-INF/responses/PageNotFound.jsp", com.execute(null, null));

	}

	public void testGetPostCommand() {
		assertNull(null);
	}

}
