package library.model.dao.declaration;

import java.io.Closeable;
import java.sql.SQLException;

import library.model.entity.BookTitle;
import library.model.exceptions.BookDublicateException;

public interface BookTitleDao{
	//quik lookUp
	// strait lookUp
	// loose lookUp
	//get authors id (names)
	//get book id (name, authors)

	//advanced lookUp
	public Integer straitLookUp(String title, int[] authorsList) throws SQLException, BookDublicateException;
	public Integer addBookTitle(BookTitle bookTitle) throws SQLException;
	BookTitle getBookTitle(int databaseID) throws SQLException;
	Integer addBookTitle4(BookTitle book) throws SQLException;
}
