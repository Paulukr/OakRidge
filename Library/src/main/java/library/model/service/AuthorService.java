package library.model.service;

import java.sql.SQLException;

import library.model.dao.declaration.AuthorDao;
import library.model.dao.implemantation.AuthorDaoImpl;
import library.model.entity.Author;
import library.model.exceptions.AuthorDublicateException;

public class AuthorService {
	protected AuthorDao authorDao = AuthorDaoImpl.getInstance();
	protected AuthorService(){}
    private static class LazyHolder {
        private static final AuthorService INSTANCE = new AuthorService();
    }
    public static AuthorService getInstance(){
        return LazyHolder.INSTANCE;
    }
	public int tryAddAuthor(Author author) throws SQLException, AuthorDublicateException {
		Integer authorID = authorDao.findAuthorID(author.getName());
		if (authorID != null)
			return authorID;
		else
			return -addAuthor(author);
	}

	public int addAuthor(Author author) throws SQLException {
		return authorDao.addAuthor(author);
	}
	public void findOrAddAuthors(java.util.List<Author> authorsList ) throws SQLException, AuthorDublicateException {
		for (Author author : authorsList)
			author.setDatabaseID(tryAddAuthor(author));
	}
	public Integer findAuthorID(String name) throws SQLException, AuthorDublicateException {
		return authorDao.findAuthorID(name);
	}
	public Author getAuthorByID(int databaseId) throws SQLException {
		return authorDao.getAuthorByID(databaseId);
	}
}
