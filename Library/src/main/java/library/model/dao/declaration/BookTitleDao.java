package library.model.dao.declaration;

import library.model.entity.BookTitle;

public interface BookTitleDao {
	//quik lookUp
	// strait lookUp
	// loose lookUp
	//get authors id (names)
	//get book id (name, authors)
	
	//advanced lookUp
	public Integer straitLookUp(String title, int[] authorsList);
	public boolean addBookTitle(BookTitle bookTitle);
	BookTitle geBookTitle(int databaseID);
}
