package library.controller.command;

import java.util.HashMap;
import java.util.Map;

import library.controller.UrlConstants;
import library.controller.command.book.AddBookCommand;
import library.controller.command.book.AddVolumeCommand;
import library.controller.command.book.GetBookFormCommand;
import library.controller.command.book.PageNotFoundCommand;
import library.controller.command.book.SearchBookCommand;

public class CommandMapper {
	public static final String GET = "GET";
	public static final String POST = "POST";
	Map<String, Command> getCommandsMap = new HashMap<>();
	Map<String, Command> postCommandsMap = new HashMap<>();
	
    public CommandMapper() {
    	getMapInit();
    	postMapInit();
	}


	private void getMapInit() {
//        commandsMap.put(UrlHolder.PATH_LOGOUT, new CommandMock());
		getCommandsMap.put(UrlConstants.PAGE_NOT_FOUND, new PageNotFoundCommand());
		getCommandsMap.put("test", new PageNotFoundCommand());
		getCommandsMap.put(UrlConstants.C_BOOK_SEARCH, new SearchBookCommand());
		getCommandsMap.put(UrlConstants.C_GET_BOOK_ADD_FORM, new GetBookFormCommand());
    }
	
	private void postMapInit() {
		postCommandsMap.put(UrlConstants.PAGE_NOT_FOUND, new PageNotFoundCommand());
		postCommandsMap.put(UrlConstants.C_BOOK_ADD, new AddBookCommand());
		postCommandsMap.put(UrlConstants.C_VOLUME_ADD, new AddVolumeCommand());

    }
	
	String string = new String(UrlConstants.C_BOOK_ADD);
	
	public Command getGetCommand(String URI) {
		return getCommand(URI, getCommandsMap);
	}
	public Command getPostCommand(String URI) {
		return getCommand(URI, postCommandsMap);
	}
	
	private Command getCommand(String uri, Map<String, Command> commandsMap) {
    	
    	System.out.println("\n\n\nConstants\n" +UrlConstants.C_BOOK_ADD + "\n\n\n");
    	
    	commandsMap.forEach((a,b) ->{System.out.println(a);});
    	
//    	URI = ".." + URI;
    	
    	
    	
    	
    	System.out.println("\n\n\nURI\n" +uri + "\n\n\n");
    	// TODO ad hoc
    	uri = uri.substring(8);
    	System.out.println("\n\n\nURI ad hoc\n" +uri + "\n\n\n");
    	
		Command command = commandsMap.get(uri);
		if (command == null)
			command = commandsMap.get(UrlConstants.PAGE_NOT_FOUND);
		
		return command;
	}
        
}
