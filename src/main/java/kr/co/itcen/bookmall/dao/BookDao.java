package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;

public class BookDao extends BookmallUtil{
	
	public void insertBook(BookVo vo) {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			
			String sql = "insert into book values(null, ?, ?, (select no from category where name=?))";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getCategory());
			
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public List<BookVo> getBook() {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookVo> list= new ArrayList<BookVo>();
		try {
			connection = getConnection();
			
			String sql = "select a.no, a.name, a.price, a.category_no, b.name"
					   + " from book a, category b"
					   + " where a.category_no = b.no";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
				BookVo vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCategory_no(rs.getLong(4));
				vo.setCategory(rs.getString(5));
				list.add(vo);
			}						
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
