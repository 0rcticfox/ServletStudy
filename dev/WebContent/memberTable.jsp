<%@ page import="org.apache.tomcat.dbcp.dbcp2.PStmtKey"%>
<%@ page import="oracle.jdbc.proxy.annotation.Pre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>    
<%@ page import="javax.naming.*" %>

<%
	// 1. JDNI 서버 생성
	InitialContext ic = new InitialContext();
	
	// 2. lookup()
	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
	
	// 3. getConnection()
	Connection conn = ds.getConnection();

	String sql = "create table member( id varchar(10) primary key, passwd varchar(10), name varchar(10), mail varchar(20))";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	
	
/* 	pstmt.setString(1, "id varchar(10) primary key");
	pstmt.setString(2, "passwd varchar(10)");
	pstmt.setString(3, "name varchar(10)");
	pstmt.setString(4, "mail varchar(20)");
 */	
	
	
	
	pstmt.execute();

	out.print("member 테이블이 생성되었습니다.");
	
	pstmt.close();
	conn.close();
%>
