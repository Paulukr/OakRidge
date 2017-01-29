package library.controller.command;

import java.util.HashMap;
import java.util.Map;

import library.controller.UrlConstants;
import library.controller.command.lib_commands.AddBookCommand;

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
		getCommandsMap.put(UrlConstants.PAGE_NOT_FOUND, new CommandMock());
		getCommandsMap.put("test", new CommandMock());
    }
	
	private void postMapInit() {
		postCommandsMap.put(UrlConstants.PAGE_NOT_FOUND, new CommandMock());
		postCommandsMap.put(UrlConstants.BOOK_ADD, new AddBookCommand());

    }
	
	String string = new String(UrlConstants.BOOK_ADD);
	
	public Command getGetCommand(String URI) {
		return getCommand(URI, getCommandsMap);
	}
	public Command getPostCommand(String URI) {
		return getCommand(URI, postCommandsMap);
	}
	
	private Command getCommand(String URI, Map<String, Command> commandsMap) {
    	
    	System.out.println("\n\n\nConstants\n" +UrlConstants.BOOK_ADD + "\n\n\n");
    	
    	commandsMap.forEach((a,b) ->{System.out.println(a);});
    	
    	System.out.println("\n\n\nURI\n" +URI + "\n\n\n");
    	
    	
		Command command = commandsMap.get(URI);
		if (command == null)
			command = commandsMap.get(UrlConstants.PAGE_NOT_FOUND);
		
		return command;
	}
        
}
