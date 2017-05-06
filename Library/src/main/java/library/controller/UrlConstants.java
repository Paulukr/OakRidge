package library.controller;

import javax.xml.ws.Dispatch;

public class UrlConstants {




    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";
    public static final String NULL = "null";

    public static final String SUFFIX = "/";
    public static final String PREFIX = "/user";




    public static final String HOME = "/Library/index.jsp";


    public static final String COMMAND = "/map";
    public static final String LIBRARIAN = "/librarian";
    public static final String USER = "/Library/map/user";

    public static final String BOOK = "/book";
    public static final String VOLUME = "/volume";
    public static final String ADD = "/add";
    public static final String SEARCH = "/search";
	public static final String ADD_FORM = "/add_form";
	public static final String SEARCH_FORM = "/search_form";
	public static final String BORROW = "/borrow";
	//book
    public static final String C_GET_BOOK_ADD_FORM = COMMAND + LIBRARIAN + BOOK+ ADD_FORM;
    public static final String C_BOOK_ADD = COMMAND + LIBRARIAN + BOOK + ADD;

    public static final String C_GET_BOOK_SEARCH_FORM = COMMAND + LIBRARIAN + BOOK+ SEARCH_FORM;
    public static final String C_BOOK_SEARCH = COMMAND + LIBRARIAN + BOOK + SEARCH;

    public static final String C_BOOK_BORROW = COMMAND + LIBRARIAN + BOOK + BORROW;
    //volume
    public static final String C_GET_VOLUME_ADD_FORM = COMMAND + LIBRARIAN + VOLUME + ADD_FORM;
    public static final String C_VOLUME_ADD = COMMAND + LIBRARIAN + VOLUME + ADD;
    //

    //J
    public static final String ITEM = "/item";
    public static final String DISPATCH = "/dispatch";
    public static final String C_GET_JITEM_SEARCH = COMMAND + LIBRARIAN + ITEM + SEARCH;
    public static final String C_JITEM_DISPATCH = COMMAND + LIBRARIAN + ITEM + DISPATCH;
    public static final String JHOME = "/JItem.jsp";
    public static final String JITEMRESULT = "/JItemResult.jsp";



    public static final String RESOURCE = "/WEB-INF";
    public static final String RESPONSES = "/responses";
    public static final String VIEWS = "/views";

    public static final String R_BOOK_ADD = RESOURCE + VIEWS + "/AddBook.jsp";
    public static final String R_BOOK_ADD_SUCCESS = RESOURCE + RESPONSES + "/AddBookSuccess.jsp";
    public static final String R_BOOK_ADD_ERROR = RESOURCE + RESPONSES + "/AddBookError.jsp";





//    public static final String PAGE_NOT_FOUND = "/WEB-INF/responses/PageNotFound.jsp";
    public static final String PAGE_NOT_FOUND = RESOURCE + RESPONSES + "/PageNotFound.jsp";





}
