package library.model.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.controller.ViewConstants;
import library.model.dao.declaration.BookTitleDao;
import library.model.dao.declaration.BookTypeDao;
import library.model.dao.declaration.JItemDao;
import library.model.dao.implemantation.BookTitleDaoImpl;
import library.model.dao.implemantation.BookTypeDaoImpl;
import library.model.dao.implemantation.JItemDaoImpl;
import library.model.entity.Author;
import library.model.entity.BookTitle;
import library.model.entity.JItem;
import library.model.exceptions.BookDublicateException;
import library.model.exceptions.InvalidInputException;

public class JItemService {
	private static final Logger logger = Logger.getLogger(JItemService.class);
	protected JItemDao jItemDao = JItemDaoImpl.getInstance();

	/*
	 *
	 *
	 *
	 *
	 */
	protected JItemService() {
	}

	private static class LazyHolder {
		private static final JItemService INSTANCE = new JItemService();
	}

	public static JItemService getInstance() {
		return LazyHolder.INSTANCE;
	}

	public JItem getJItemByID(int id) throws SQLException {
		JItem jItem = jItemDao.getJItemName(id);
		return jItem;
	}
	public int getJItemDispatch(int jItemNo, int quantity){
		try {
			return jItemDao.getJItemDispatch(jItemNo, quantity);
		} catch (SQLException e) {
			logger.error("JITEM_DISPATCH", e);
			return -1;
		}
	}
}
