package library.model.service;

public class ServiceFactory {
	protected AuthorService authorService = AuthorService.getInstance();
	protected BookTitleService bookTitleService = BookTitleService.getInstance();

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
