package kr.co.itcen.main;

import kr.co.itcen.bookmall.dao.test.BookDaoTest;
import kr.co.itcen.bookmall.dao.test.CartDaoTest;
import kr.co.itcen.bookmall.dao.test.CategoryDaoTest;
import kr.co.itcen.bookmall.dao.test.MemberDaoTest;
import kr.co.itcen.bookmall.dao.test.OrderBookDaoTest;
import kr.co.itcen.bookmall.dao.test.OrderDaoTest;
import kr.co.itcen.bookmall.util.BookmallUtil;

public class BookMallTest {

	public static void main(String[] args) {	
		
		MemberDaoTest.insertMember();
		CategoryDaoTest.insertCategory();
		BookDaoTest.insertBook();
		CartDaoTest.insertCart();
		OrderDaoTest.insertOrder();	
		
		MemberDaoTest.getMember();
		BookDaoTest.getBook();
		CategoryDaoTest.getCategory();
		CartDaoTest.getCart();		
		OrderDaoTest.getOrder();
		OrderBookDaoTest.getOrderBook();

		BookmallUtil.deleteAll("book_order");	
		BookmallUtil.deleteAll("orders");
		BookmallUtil.deleteAll("cart");
		BookmallUtil.deleteAll("book");
		BookmallUtil.deleteAll("user");
		BookmallUtil.deleteAll("category");
		
				
		
		
	}
}
