package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.util.BookmallUtil;
import kr.co.itcen.bookmall.vo.MemberVo;

public class MemberDao extends BookmallUtil {
	public void insertMember(MemberVo vo) {
		Connection connection = null;		
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			
			String sql = "insert into user values(null, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNumber());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPasswd());
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

	public List<MemberVo> getMember() {		
		Connection connection = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> list= new ArrayList<MemberVo>();
		try {
			connection = getConnection();		
			
			String sql = "select no, name, number, email, passwd from user";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			while(rs.next()) {				
				MemberVo vo = new MemberVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setNumber(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setPasswd(rs.getString(5));
				
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
