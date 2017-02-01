package library.model.dao.implemantation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.dao.DaoConstants;
import library.model.dao.declaration.BookTitleDao;
import library.model.dao.declaration.BookTypeDao;
import library.model.entity.Author;
import library.model.entity.BookTitle;

public class BookTypeDaoImpl extends AbstractDao implements BookTypeDao {

	private static final Logger logger = Logger.getLogger(BookTypeDaoImpl.class);

	@Override
	public String[] getBookTypes() throws SQLException  {
		List<String> types = new ArrayList<>();
		try {
			prepareStatement(DaoConstants.BOOK_TYPES_GET);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				types.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			logger.error(ErrorList.InsertTitle, e);
			throw new SQLException(ErrorList.InsertTitle, e);
		}
		return types.toArray(new String[0]);
	}
}
