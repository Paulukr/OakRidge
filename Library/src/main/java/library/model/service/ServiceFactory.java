package library.model.service;

import java.beans.PropertyVetoException;

import javax.management.RuntimeErrorException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import library.controller.ErrorList;
import library.model.dao.DatabaseUtility;


public class ServiceFactory {
	AuthorService authorService;
	BookTitleService bookTitleService;

    private static class LazyHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }
    public static ServiceFactory getdataSource(){
        return LazyHolder.INSTANCE;
    }
}
