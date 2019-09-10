package kr.co.itcen.bookmall.dao.test;

import kr.co.itcen.bookmall.dao.BookmallUtil;

public class BookMall {
	public static void main(String args[]) {
		MemberDaoTest.getMember();
		BookDaoTest.getBook();
		CategoryDaoTest.getCategory();
		CartDaoTest.getCart();		
		OrderDaoTest.getOrder();
		OrderBookDaoTest.getOrderBook();
		
		BookmallUtil.deleteAll("user");
		BookmallUtil.deleteAll("category");
		BookmallUtil.deleteAll("book");		
		BookmallUtil.deleteAll("cart");		
		BookmallUtil.deleteAll("orders");
		BookmallUtil.deleteAll("book_order");		
	}
}
