package library.model.service;

public class ServiceFactory {
	protected AuthorService authorService;
	protected BookTitleService bookTitleService;

    private static class LazyHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }
    public static ServiceFactory getInstance(){
        return LazyHolder.INSTANCE;
    }
	public AuthorService getAuthorService() {
		return authorService;
	}
	public BookTitleService getBookTitleService() {
		return bookTitleService;
	}

}
