package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertOrder();
		getOrder();
	}
	
	public static void insertOrder() {		
		OrderDao dao = new OrderDao();				
		OrderVo vo = new OrderVo();	
		String name = "둘리";
		vo.setPayment(11000);
		vo.setAddress("경기도 부천시 범안로 220");
		vo.setUserName(name);
		dao.insertOrder(vo);
		OrderBookDaoTest.insertOrderBook("인문책", name, 5);
		OrderDao.setPayment(name);
				
		OrderVo vo1 = new OrderVo();
		name = "또치";
		vo1.setPayment(15000);
		vo1.setAddress("경기도 부천시 범안로 221");
		vo1.setUserName(name);
		dao.insertOrder(vo1);
		OrderBookDaoTest.insertOrderBook("사회책", name, 3);
		OrderBookDaoTest.insertOrderBook("과학책", name, 2);
		OrderBookDaoTest.insertOrderBook("인문책", name, 6);
		OrderDao.setPayment(name);
		
	}

	public static void getOrder() {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getOrder();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
}
