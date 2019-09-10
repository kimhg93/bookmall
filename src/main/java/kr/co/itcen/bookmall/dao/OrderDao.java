package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.util.BookmallUtil;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao extends BookmallUtil{
	
	public void insertOrder(OrderVo vo) {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			
			String sql = "insert into orders values(null, ?, ?, (select no from user where name=?))";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getPayment());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getUserName());
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
	

	public List<OrderVo> getOrder() {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderVo> list= new ArrayList<OrderVo>();
		try {
			connection = getConnection();
			
			String sql = "select a.no, a.payment, a.address, a.user_no, b.name" + 
						 " from orders a, user b" + 
						 " where a.user_no = b.no";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
				OrderVo vo = new OrderVo();
				vo.setNo(rs.getLong(1));
				vo.setPayment(rs.getInt(2));
				vo.setAddress(rs.getString(3));
				vo.setUser_no(rs.getLong(4));
				vo.setUserName(rs.getString(5));
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
