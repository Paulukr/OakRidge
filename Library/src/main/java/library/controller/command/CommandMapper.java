package library.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import library.controller.UrlConstants;
import library.controller.command.book.AddBookCommand;
import library.controller.command.book.AddVolumeCommand;
import library.controller.command.book.GetBookFormCommand;
import library.controller.command.book.PageNotFoundCommand;
import library.controller.command.book.SearchBookCommand;
import library.controller.command.volume.GetVolumeFormCommand;
import library.model.dao.implemantation.AbstractDao;

public class CommandMapper {
	public static final String GET = "GET";
	public static final String POST = "POST";
	Map<String, Command> getCommandsMap = new HashMap<>();
	Map<String, Command> postCommandsMap = new HashMap<>();
	private static final Logger logger = Logger.getLogger(AbstractDao.class);

	public CommandMapper() {
		getMapInit();
		postMapInit();
	}

	private void getMapInit() {
		// commandsMap.put(UrlHolder.PATH_LOGOUT, new CommandMock());
		getCommandsMap.put(UrlConstants.PAGE_NOT_FOUND, new PageNotFoundCommand());
		getCommandsMap.put("test", new PageNotFoundCommand());

		getCommandsMap.put(UrlConstants.C_BOOK_SEARCH, new SearchBookCommand());
		getCommandsMap.put(UrlConstants.C_BOOK_SEARCH, new SearchBookCommand());
		getCommandsMap.put(UrlConstants.C_GET_BOOK_ADD_FORM, new GetBookFormCommand());
		getCommandsMap.put(UrlConstants.C_GET_VOLUME_ADD_FORM, new GetVolumeFormCommand());



	}

	private void postMapInit() {
		postCommandsMap.put(UrlConstants.PAGE_NOT_FOUND, new PageNotFoundCommand());
		postCommandsMap.put(UrlConstants.C_BOOK_ADD, new AddBookCommand());
		postCommandsMap.put(UrlConstants.C_VOLUME_ADD, new AddVolumeCommand());
		getCommandsMap.put(UrlConstants.C_GET_VOLUME_ADD_FORM, new GetVolumeFormCommand());

	}

	public Command getGetCommand(String uri) {
		return getCommand(uri, getCommandsMap);
	}

	public Command getPostCommand(String uri) {
		return getCommand(uri, postCommandsMap);
	}

	private Command getCommand(String uri, Map<String, Command> commandsMap) {
		logger.debug("command request received: " + uri);

		// TODO ad hoc
		if (uri.length() > 8)
			uri = uri.substring(8); // ".."#
		logger.debug("command request p: " + uri);

		Command command = commandsMap.get(uri);
		if (command == null)
			command = commandsMap.get(UrlConstants.PAGE_NOT_FOUND);

		return command;
	}

}
