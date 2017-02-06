package library.model.entity;

public class BookVolume {
	/*
	create table Volume_table
	Volume_no SERIAL not null primary key,
	Vol_price real,
	Vol_buy_year int,
	Vol_total_quantity int,
	Vol_available_quantity int,
	Title_no int references Title_table(Title_no),
	Borrow_type_available int
 */
	protected int volumeNo;
	protected double price;
	protected int buyYear;
	protected int available;
	protected int title_no;
	protected int borrow_type_available;
	public int getVolumeNo() {
		return volumeNo;
	}
	public void setVolumeNo(int volumeNo) {
		this.volumeNo = volumeNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBuyYear() {
		return buyYear;
	}
	public void setBuyYear(int buyYear) {
		this.buyYear = buyYear;
	}

	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getTitle_no() {
		return title_no;
	}
	public void setTitle_no(int title_no) {
		this.title_no = title_no;
	}
	public int getBorrow_type_available() {
		return borrow_type_available;
	}
	public void setBorrow_type_available(int borrow_type) {
		this.borrow_type_available = borrow_type;
	}

}
