package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao extends BookmallUtil{
	public void insertCart(CartVo vo) {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			
			String sql = "insert into cart values((select no from user where name=?), (select no from book where name=?))";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getBookName());
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
	

	public List<CartVo> getCart() {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CartVo> list= new ArrayList<CartVo>();
		try {
			connection = getConnection();
			
			String sql = "select a.user_no, a.book_no, b.name"
					   + " from cart a, book b"
					   + " where a.book_no = b.no";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
				CartVo vo = new CartVo();
				vo.setNo(rs.getLong(1));
				vo.setBook_no(rs.getLong(2));
				vo.setBookName(rs.getString(3));
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
