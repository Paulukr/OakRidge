package library.model.dao.declaration;

import java.sql.SQLException;

import library.model.entity.Author;
import library.model.exceptions.AuthorDublicateException;

public interface AuthorDao {

	public Integer findAuthorID(String fullName) throws SQLException, AuthorDublicateException;
	public Integer addAuthor(Author author) throws SQLException;
	public Author getAuthorByID(int databaseId) throws SQLException;

}
