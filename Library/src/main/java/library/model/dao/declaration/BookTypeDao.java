package library.model.dao.declaration;

import java.sql.SQLException;

public interface BookTypeDao {

	String[] getBookTypes() throws SQLException;

}
