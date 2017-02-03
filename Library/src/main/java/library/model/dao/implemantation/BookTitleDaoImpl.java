package library.model.dao.implemantation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.model.dao.DaoConstants;
import library.model.dao.declaration.BookTitleDao;
import library.model.entity.Author;
import library.model.entity.BookTitle;

public class BookTitleDaoImpl extends AbstractDao  implements BookTitleDao{
	
    private static final Logger logger = Logger.getLogger(BookTitleDaoImpl.class);

	@Override
	public Integer straitLookUp(String title, int[] authorsList) throws SQLException {
			try {
				init();//TODO
				//SELECT Title_no FROM title_table WHERE Title_name = 'California1' AND Author_no = 1;
//				prepareStatement(DaoConstants.AUTHOR_GET_NO);
				
				prepareStatement(DaoConstants.BOOK_TITLE_FIND_SIGNATURE);
				// (Title_name, AND Author_no)
				preparedStatement.setString(1, title);
				preparedStatement.setInt(2, authorsList[0]);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					int result = resultSet.getInt(1);
					String duplicateList = null; 
					while(resultSet.next()){
						duplicateList += " " + result;
						result = resultSet.getInt(1);
					}
					if(duplicateList != null)
						throw new SQLException(ErrorList.DuplicateBooks + duplicateList );
					preparedStatement.close();
					return result;
				} else {
					preparedStatement.close();
					return null;
				}
			} catch (SQLException e) {
				logger.error(ErrorList.SelectBook, e);
				throw new SQLException(ErrorList.SelectAuthor, e);
			}
	}
	@Override
	public BookTitle getBookTitle(int databaseID) throws SQLException{
		BookTitle bookTitle = new BookTitle();
		try {
			prepareStatement(DaoConstants.BOOK_TITLE_SELECT);
			preparedStatement.setInt(1, databaseID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next())
				return null;
			bookTitle.setTitle(resultSet.getString(1));
			bookTitle.setTypeNo(resultSet.getInt(2));
			bookTitle.setPublishedYear(resultSet.getInt(3));
			Author author = new Author();
			author.setDatabaseID(resultSet.getInt(4));
			bookTitle.getAuthors().add(author);
//			while (resultSet.next()){
//				author = new Author();
//				author.setDatabaseID(resultSet.getInt(4));
//				bookTitle.getAuthors().add(author);
//			}
				
			
		} catch (SQLException e) {
            logger.error(ErrorList.InsertTitle, e);
            throw new SQLException(ErrorList.InsertTitle, e);
		}
		return bookTitle;
	}
	
	@Override
	public Integer addBookTitle(BookTitle book) throws SQLException {
//		if (straitLookUp(book.getTitle(),
//				 book.getAuthors().stream().mapToInt(Author::getDatabaseID).toArray()) > 0) {
//			return false;		
//		}
        try {
        	init();//TODO
        	//INSERT INTO title_table ( Title_name, Type_no, Title_year_published, Author_no)
//        	prepareStatementKeyGeneration(DaoConstants.BOOK_TITLE_ADD);
        	prepareStatement(DaoConstants.BOOK_TITLE_ADD);
//        	prepareStatement("INSERT INTO title_table (Title_no) VALUES (? )");
//        	"SELECT * FROM title_table"

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getTypeNo());
            preparedStatement.setInt(3, book.getPublishedYear());
            preparedStatement.setInt(4, 1);
            logger.error("\n sql \n" + DaoConstants.BOOK_TITLE_ADD + " ");
            
            
            try (ResultSet generatedKeys = preparedStatement.executeQuery()) {
                if (generatedKeys.next()) {
                    book.setDatabaseID(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(ErrorList.InsertTitle, e);
            throw new SQLException(ErrorList.InsertTitle, e);
        }
		return book.getDatabaseID();
	}

}
