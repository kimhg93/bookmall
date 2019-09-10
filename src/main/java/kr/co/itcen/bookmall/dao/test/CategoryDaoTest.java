package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookmallUtil;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;



public class CategoryDaoTest {

	public static void main(String[] args) {
		insertCategory();
		getCategory();
		//BookmallUtil.deleteAll("category");
	}

	private static void insertCategory() {
		CategoryDao dao = new CategoryDao();				
		CategoryVo vo = new CategoryVo();		
		vo.setName("인문");
		dao.insertCategory(vo);
		
		CategoryVo vo1 = new CategoryVo();		
		vo1.setName("소설");
		dao.insertCategory(vo1);
		
		CategoryVo vo2 = new CategoryVo();		
		vo2.setName("과학");
		dao.insertCategory(vo2);
	}
	
	public static void getCategory() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getCategory();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
