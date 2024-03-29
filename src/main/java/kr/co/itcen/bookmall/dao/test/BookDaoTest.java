package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.util.BookmallUtil;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertBook();
		getBook();
		BookmallUtil.deleteAll("book");
	}
	
	public static void insertBook() {
		BookDao dao = new BookDao();				
		BookVo vo = new BookVo();		
		vo.setName("과학책");
		vo.setPrice(11000);
		category("과학", vo);	
		dao.insertBook(vo);
		
		BookVo vo1 = new BookVo();		
		vo1.setName("사회책");
		vo1.setPrice(12000);
		category("소설", vo1);	
		dao.insertBook(vo1);
		
		BookVo vo2 = new BookVo();		
		vo2.setName("인문책");
		vo2.setPrice(13000);
		category("인문", vo2);	
		dao.insertBook(vo2);
	}

	public static void getBook() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getBook();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	private static void category(String name, BookVo vo) {
		if(!BookDao.checkCategory(name)) {
			CategoryDao.insertCategory(name);
		}
		vo.setCategory(name);
		
	}
}
