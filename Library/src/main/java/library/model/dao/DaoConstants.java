package library.model.dao;

public class DaoConstants {
	// sql queries for prepared statements
		// BookTitle
    public static final String RECREATE_BASE = "SELECT refillDatabase()";
    public static final String BOOK_TITLE_ADD = " INSERT INTO Title_table ( Title_name, Type_no, Title_year_published, Author_no)"
    		+ " VALUES(?, ?, ?, ?)" +"RETURNING Title_no";
    public static final String BOOK_TITLE_GET_INSTANCE = " SELECT Title_name, Type_no, Title_year_published, Author_no  FROM Title_table"
    		+ " WHERE Title_no = ?";
    public static final String BOOK_TITLE_FIND_SIGNATURE = "SELECT Title_no FROM title_table WHERE Title_name = ? AND Author_no = ? ";
    public static final String BOOK_TYPES_GET = "SELECT Type_description FROM Type_table ORDER BY Type_no ASC";
    public static final String BOOK_TITLE_DELETE = "DELETE FROM Title_table WHERE id = ?";

	// Author
//    public static final String AUTHOR_CHECK_AVAILABILITY = "SELECT COUNT ( *) FROM Author_table WHERE Author_name = ?" ;
    public static final String AUTHOR_GET_NO = "SELECT Author_no FROM Author_table WHERE Author_name = ?" ;
    public static final String AUTHOR_ADD = " INSERT INTO Author_table ( Author_name ) VALUES(?)" +"RETURNING Author_no";
    public static final String AUTHOR_GET_INSTANCE = "SELECT Author_name FROM Author_table WHERE Author_no = ?" ;

    //Volume
    public static final String BOOK_VOLUME_FIELDS = "Vol_price, Vol_buy_year, Vol_available, Title_no, Borrow_type_available ";
    public static final String BOOK_VOLUME_GET_INSTANCE = "SELECT " + BOOK_VOLUME_FIELDS  + " FROM Volume_table WHERE Volume_no = ?";
    public static final String BOOK_VOLUME_ADD = " INSERT INTO Volume_table ( " + BOOK_VOLUME_FIELDS + ") VALUES(?, ?, ?, ?, ?)" +"RETURNING Title_no";
    public static final String BOOK_VOLUME_GET_PULL = "SELECT " + BOOK_VOLUME_FIELDS + " FROM Volume_table WHERE Title_no = ?";
    public static final String BOOK_VOLUME_GET_COUNT_AVAILABLE = "SELECT COUNT (Volume_no)"
    		+ " FROM Volume_table WHERE Title_no = ? AND Vol_available = 1";
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
