package book;

public class BuylistVO {

	private String buyBook;
	private String buyMember;
	private String buyDate;

	public String getBuyBook() {
		return buyBook;
	}

	public void setBuyBook(String buyBook) {
		this.buyBook = buyBook;
	}

	public String getBuyMember() {
		return buyMember;
	}

	public void setBuyMember(String buyMember) {
		this.buyMember = buyMember;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	@Override
	public String toString() {
		return "BuyListVO [buyBook=" + buyBook + ", buyMember=" + buyMember + ", buyDate=" + buyDate + "]";
	}

}