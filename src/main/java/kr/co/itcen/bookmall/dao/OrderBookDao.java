package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDao extends BookmallUtil {
	public void insertOrderBook(OrderBookVo vo) {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			String sql = "insert into book_order values("
					+ "(select b.no from user a, orders b where a.no = b.user_no and a.name = ?),"
					+ "(select no from book where name=?), ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getBookName());
			pstmt.setInt(3, vo.getAmount());
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
	

	public List<OrderBookVo> getOrderBook() {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderBookVo> list= new ArrayList<OrderBookVo>();
		try {
			connection = getConnection();
			
			String sql = "select a.order_no, a.book_no, b.name, d.name" + 
						" from book_order a, book b, orders c, user d" + 
						" where a.book_no = b.no" + 
						" and a.order_no = c.no" + 
						" and c.user_no = d.no";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNo(rs.getLong(1));
				vo.setBookNo(rs.getLong(2));
				vo.setBookName(rs.getString(3));
				vo.setUserName(rs.getString(4));
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
