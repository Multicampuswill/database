package book;

public class BasketVO {

	private String basketBook;
	private String basketMember;
	private String basketDate;

	public String getBasketBook() {
		return basketBook;
	}

	public void setBasketBook(String basketBook) {
		this.basketBook = basketBook;
	}

	public String getBasketMember() {
		return basketMember;
	}

	public void setBasketMember(String buyMember) {
		this.basketMember = buyMember;
	}

	public String getBasketDate() {
		return basketDate;
	}

	public void setBasketDate(String buyDate) {
		this.basketDate = buyDate;
	}

	@Override
	public String toString() {
		return "BasketVO [basketBook=" + basketBook + ", buyMember=" + basketMember + ", buyDate=" + basketDate + "]";
	}

}
