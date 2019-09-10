package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertMember();
		getMember();
		//BookmallUtil.deleteAll("user");
	}

	private static void insertMember() {
		MemberDao dao = new MemberDao();
				
		MemberVo vo = new MemberVo();		
		vo.setName("둘리");
		vo.setNumber("010-1234-5678");
		vo.setEmail("dooli@gamil.com");
		vo.setPasswd("dooli4543");
		dao.insertMember(vo);
		
		MemberVo vo1 = new MemberVo();
		vo1.setName("또치");
		vo1.setNumber("010-5555-6666");
		vo1.setEmail("tochi@gamil.com");
		vo1.setPasswd("tochi1234");		
		dao.insertMember(vo1);
	}
	
	public static void getMember() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getMember();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}
