package spring05.member.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spring05.member.dto.Member;

public class MemberDao {

	//로딩할 드라이버 
	private String driver = "oracle.jdbc.dirver.OracleDriver";
	//연결할 DB
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//DB ID
	private String userid = "c##scott";
	//DB PASSWORD
	private String userpw = "tiger";
	
	
	//DB가 연결된 connect
	private Connection conn = null;
	//쿼리문 전송에 필요한 객체
	private PreparedStatement pstmt = null;
	//결과값 Set
	private ResultSet rs = null;
	
	public int select(String mName) {
		
		
		try{
			//사용할 드라이버 로딩
			Class.forName(driver);
			
			//url, id, password를 이용해 DB연결
			conn = DriverManager.getConnection(url, userid, userpw);
			
			//SQL작성 및 전송
			String sql = "select * from member where mName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			
			//자원 해제
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
	
	
	
	public int insert(Member member) {
		int result = 0;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "insert into member (mId, mPw, mName) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getmId());
			pstmt.setString(2, member.getmPw());
			pstmt.setString(3, member.getmName());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return result;
	}
	
	public void getMemberDB() {
		
	}
}
