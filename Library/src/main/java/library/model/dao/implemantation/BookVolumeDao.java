package library.model.dao.implemantation;

import java.sql.SQLException;
import java.util.List;

import library.model.entity.BookVolume;

public interface BookVolumeDao {

	List<BookVolume> getVolumePool(int bookTitleId) throws SQLException;

	int getAvaluableQuantity(int bookTitleId) throws SQLException;

	BookVolume getBookVolume(int databaseID) throws SQLException;

	Integer addBookVolume(BookVolume volume) throws SQLException;

}