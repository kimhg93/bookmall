package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertOrder();
		getOrder();
	}
	
	private static void insertOrder() {		
		OrderDao dao = new OrderDao();				
		OrderVo vo = new OrderVo();			
		vo.setPayment(11000);
		vo.setAddress("경기도 부천시 범안로 220");
		vo.setUserName("둘리");
		OrderBookDaoTest.insertOrderBook("인문책", "둘리", 5);
		dao.insertOrder(vo);
		
		OrderVo vo1 = new OrderVo();
		vo1.setPayment(15000);
		vo1.setAddress("경기도 부천시 범안로 221");
		vo1.setUserName("또치");
		OrderBookDaoTest.insertOrderBook("사회책", "또치", 3);
		dao.insertOrder(vo1);
	}

	public static void getOrder() {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getOrder();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
}
