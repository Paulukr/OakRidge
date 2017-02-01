package library.model.dao.implemantation;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.dao.DaoConstants;
import library.model.dao.declaration.AuthorDao;

public class AuthorDaoImpl extends AbstractDao implements AuthorDao {

    private static final Logger logger = Logger.getLogger(AbstractDao.class);
	
	@Override
	public boolean check_availability(String fullName) {
		try {
			init();
			prepareStatement(DaoConstants.AUTHOR_CHECK_AVAILABILITY);
			// (Author_name)
			preparedStatement.setString(1, fullName);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int result = resultSet.getInt(1);
				preparedStatement.close();

				if (result == 0)
					return false;
				if (result == 1)
					return true;
				else
					throw new Exception(ErrorList.DuplicateAuthors);

			} else {
				preparedStatement.close();
				throw new Exception(ErrorList.AbsentResultSet);
			}
		} catch (Exception e) {
			logger.error(ErrorList.SelectAuthor, e);
			throw new RuntimeException(ErrorList.SelectAuthor, e);
		}
	}

	@Override
	public Integer getNo(String fullName) {
		try {
			init();
			prepareStatement(DaoConstants.AUTHOR_GET_NO);
			// (Author_name)
			preparedStatement.setString(1, fullName);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int result = resultSet.getInt(1);
				preparedStatement.close();
				return result;
			} else {
				preparedStatement.close();
				throw new Exception(ErrorList.AbsentResultSet);
			}
		} catch (Exception e) {
			logger.error(ErrorList.SelectAuthor, e);
			throw new RuntimeException(ErrorList.SelectAuthor, e);
		}
	}

	@Override
	public boolean addAuthor(String fullName) {
		try {
			init();
			prepareStatement(DaoConstants.AUTHOR_ADD);
			// (Author_name)
			preparedStatement.setString(1, fullName);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {

			logger.error(ErrorList.SelectAuthor, e);
			
			throw new RuntimeException(ErrorList.SelectAuthor, e);
		}
	}

}
