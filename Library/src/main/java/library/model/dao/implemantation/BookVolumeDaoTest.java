package library.model.dao.implemantation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import library.model.dao.declaration.AuthorDao;
import library.model.entity.BookVolume;

public class BookVolumeDaoTest {
	static BookVolumeDao dao;
	@Before
	public void setUp() throws Exception {
		dao = BookVolumeDaoImpl.getInstance();
		AuthorDao authorDao = new AuthorDaoImpl();
		authorDao.restartBase();
	}


	@Test
	public void testGetVolumePool() {
		try {
			List<BookVolume> bookVolumes = dao.getVolumePool(1);
			assertEquals(2, bookVolumes.size());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetAvaluableQuantity() {
		try {
			assertEquals(2, dao.getAvaluableQuantity(1));
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetBookVolume() {
		try {
			List<BookVolume> bookVolumes = dao.getVolumePool(1);
			BookVolume bookVolume = dao.getBookVolume(1);
			assertEquals(2010, bookVolume.getBuyYear());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testAddBookVolume() {
		try {
			BookVolume bookVolume = new BookVolume();
			bookVolume.setBuyYear(2015);
			bookVolume.setTitle_no(1);
			bookVolume.setPrice(15);
			dao.addBookVolume(bookVolume);
			List<BookVolume> bookVolumes = dao.getVolumePool(1);
			assertEquals(3, bookVolumes.size());
			assertEquals(15, bookVolumes.get(2).getPrice(), 0.01);
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
