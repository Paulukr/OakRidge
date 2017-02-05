package library.model.service;


public class BookVolumeService {
	protected BookVolumeService(){}
    private static class LazyHolder {
        private static final BookVolumeService INSTANCE = new BookVolumeService();
    }
    public static BookVolumeService getInstance(){
        return LazyHolder.INSTANCE;
    }
	boolean addVolumeNewTitle() {
		return false;
	}

	boolean addVolumeExistingTitle() {
		return false;
	}

	public boolean addVolume() {
		// volume adds to title, if new title add it first
		// form add title
		// go to author, get id. If new -> new, also check if unique
		// form add volume
		return false;
	}

}
