package library.model.entity;

public class BookTitle {
	private String title;

	private String type;
	private int typeNo;
	private int publishedYear;
	private java.util.List<Author> authors = new java.util.ArrayList<>();

	public BookTitle() {

	}

	public BookTitle(String title, String type, int typeNo, int publishedYear, java.util.List<Author> authors) {
		this.title = title;
		this.authors = authors;
		this.type = type;
		this.publishedYear = publishedYear;
		this.typeNo = typeNo;

	}
	
	public void setAuthor(String authorName) {
		authors.add(new Author(authorName, 0));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.util.List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(java.util.List<Author> authors) {
		this.authors = authors;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public int getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}

}
