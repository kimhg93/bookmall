package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.util.BookmallUtil;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertCart();
		getCart();
		BookmallUtil.deleteAll("cart");
	}
	
	public static void insertCart() {
		CartDao dao = new CartDao();				
		CartVo vo = new CartVo();
		vo.setUserName("둘리");
		vo.setBookName("인문책");
		dao.insertCart(vo);
		
		CartVo vo1 = new CartVo();	
		vo1.setUserName("둘리");
		vo1.setBookName("사회책");
		dao.insertCart(vo1);
		
		CartVo vo2 = new CartVo();	
		vo2.setUserName("또치");
		vo2.setBookName("과학책");
		dao.insertCart(vo2);
	}

	public static void getCart() {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getCart();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
