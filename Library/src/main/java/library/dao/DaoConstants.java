package library.dao;

public class DaoConstants {
	// sql queries for prepared statements
		// BookTitle
    public static final String BOOK_TITLE_ADD = " INSERT INTO Title_table ( Title_name, Type_no, Title_year_published, Author_no)"
    		+ " VALUES(?, ?, ?, ?)";
    public static final String BOOK_TITLE_SELECT = " SELECT Title_name, Type_no, Title_year_published, Author_no  FROM Title_table"
    		+ " WHERE Title_no = 5";
//    public static final String CREATE = "INSERT INTO Title_table (Title_no) " 
//    		+ " VALUES(? ) ";
    
    public static final String DELETE = "DELETE FROM Title_table WHERE id = ?";
//    public static final String UPDATE = "update";
//    public static final String FIND_ONE = "";
	// Author
    public static final String AUTHOR_CHECK_AVAILABILITY = "SELECT COUNT ( *) FROM Author_table WHERE Author_name = ?" ;
    public static final String AUTHOR_GET_NO = "SELECT Author_no FROM Author_table WHERE Author_name = ?" ;
    public static final String AUTHOR_ADD = " INSERT INTO Author_table ( Author_name ) VALUES(?)";
    /*
    public static final String FIND_ALL = "find.all";
    public static final String FIND_BY_TUTOR = "find.by.tutor";
    public static final String FIND_BY_STUDENT = "find.by.student";
    public static final String FIND_UNFOLLOW = "find.unfollow";
    public static final String FIND_BY_USER_COURSE = "find.by.user.course";
    public static final String FIND_ONE_BY_EMAIL = "find.by.email";
    */
}
/*
 * create= INSERT INTO courses ( name, about, start_date, end_date, tutor_id) \
  VALUE(?, ?, ?, ?, ?)
#
delete= DELETE FROM courses WHERE id = ?
#
soft.delete = DELETE FROM courses WHERE id = ?
#
update= UPDATE courses SET \
  name = ?, \
  about = ?, \
  start_date = ?, \
  end_date = ?, \
  tutor_id = ? \
  WHERE id = ?
#
find.one = SELECT * FROM courses \
  JOIN users ON tutor_id = users.id \
  WHERE courses.id = ?
#
find.by.student = SELECT * FROM courses \
  JOIN progress \
  ON courses.id = progress.course_id \
  WHERE user_id = ?
#
find.by.tutor = SELECT * FROM courses JOIN users ON tutor_id = users.id WHERE tutor_id = ?
#
find.all = SELECT * FROM courses JOIN users ON tutor_id = users.id
#
find.unfollow = select * from courses \
                join users on courses.tutor_id = users.id \
                where courses.id not in ( \
                select progress.course_id from users \
                join progress \
                on users.id = progress.user_id \
                where users.id = ? )
*/
