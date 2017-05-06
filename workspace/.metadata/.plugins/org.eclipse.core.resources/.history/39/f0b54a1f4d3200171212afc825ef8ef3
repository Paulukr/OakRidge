package library.model.dao.declaration;

import java.sql.SQLException;

import library.model.entity.BookTitle;
import library.model.entity.JItem;
import library.model.exceptions.BookDublicateException;

public interface JItemDao{
	//quik lookUp
	// strait lookUp
	// loose lookUp
	//get authors id (names)
	//get book id (name, authors)

	//advanced lookUp
//	public Integer straitLookUp(String title, int[] authorsList) throws SQLException, BookDublicateException;
//	public Integer addBookTitle(BookTitle bookTitle) throws SQLException;
	JItem getJItemName(int databaseID) throws SQLException;
//	Integer addBookTitle4(BookTitle book) throws SQLException;

	JItem getJItemDispatch(int JItemNo, int databaseID) throws SQLException;
}
