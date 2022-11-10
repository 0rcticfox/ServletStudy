package com.dev.dao;

import com.edu.beans.*;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class MemberDAO {

	// connection 얻는 함수
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			// 1. JDNI 서버 생성
			InitialContext ic = new InitialContext();
			
			// 2. lookup()
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");

			// 3. getConnection()
			conn = ds.getConnection();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// 회원을 추가하는 함수
	public void insertMember(Member member) {
		
		try {
			Connection conn = this.getConnection();
			
			String sql = "insert into member values( ?, ?, ?, ?)";			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.executeUpdate();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
