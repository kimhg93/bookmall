package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {
	public static void main(String[] args) {
		getOrderBook();
	}
	
	protected static void insertOrderBook(String bookName, String userName, int amount) {
		OrderBookDao dao = new OrderBookDao();				
		OrderBookVo vo = new OrderBookVo();			
		vo.setBookName(bookName);
		vo.setUserName(userName);
		vo.setAmount(amount);
		dao.insertOrderBook(vo);
	}

	public static void getOrderBook() {
		OrderBookDao dao = new OrderBookDao();
		List<OrderBookVo> list = dao.getOrderBook();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
