package library.controller;

import java.awt.print.Book;

public class UrlConstants {
	

	
	
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";
    public static final String NULL = "null";

    public static final String SUFFIX = "/";
    public static final String PREFIX = "/user";


    public static final String COURSE = PREFIX + "/course" + SUFFIX;
    public static final String COURSES = PREFIX + "/courses";
    public static final String STUDENTS = PREFIX + "/students";
    public static final String PROFILE =  PREFIX + "/profile";
    public static final String MY_COURSES = PREFIX +"/myCourses";
    public static final String LOGOUT = PREFIX + "/logout";
    public static final String FIND = PREFIX + "/find";
    public static final String COURSE_ADD = COURSE + "add";
    public static final String FOLLOW = PREFIX + "/follow";
    public static final String COURSE_EDIT = COURSE + "edit";
    public static final String STUDENT_EDIT = PREFIX + "/student/edit";
    public static final String UNFOLLOW = PREFIX + "/unfollow";
    public static final String COURSE_DELETE = COURSE + "delete";
    public static final String USER = "/user";
//    public static final String PAGE_NOT_FOUND = "/notFound";
    public static final String STUDENTS_COURSE_GET = STUDENTS + "/?course=";
    public static final String COURSE_EDIT_GET = COURSE + "?id=";
    public static final String LANG_GET = "lang=";
    public static final String QUESTION_SYMBOL = "?";
    public static final String EQUAL_SYMBOL = "=";
    public static final String AND_SYMBOL = "&";
    public static final String ERROR = PREFIX + "/error";
    

    
    
    
    public static final String LIBRARIAN = "/Library/map/librarian";
    
//    public static final String USER = "/user";
    
    public static final String BOOK = "/book";
    public static final String ADD = "/add";
    public static final String BOOK_ADD = LIBRARIAN + BOOK + ADD;
   
    
    public static final String BOOK_ADD_SUCCESS = "/WEB-INF/responces/AddBook.jsp";
    public static final String BOOK_ADD_ERROR = "/WEB-INF/responces/AddBookError.jsp";
    
    public static final String PAGE_NOT_FOUND = "/notFound";
    

    
    
    
}
