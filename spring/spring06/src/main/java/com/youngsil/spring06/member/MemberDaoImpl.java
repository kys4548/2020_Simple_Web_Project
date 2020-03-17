package com.youngsil.spring06.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	//로딩할 드라이버 
	private String driver = "oracle.jdbc.dirver.OracleDriver";
	//연결할 DB
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//DB ID
	private String userid = "c##scott";
	//DB PASSWORD
	private String userpw = "tiger";
	
	private DriverManagerDataSource dataSource;
	
	private JdbcTemplate template;
	
	public MemberDaoImpl() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userid);
		dataSource.setPassword(userpw);
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}
	
	public List<Member> select(final String mName) {
		List<Member> list = null;
		
		final String sql = "select * from member where mName = ?";
		list = template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, mName);
			}
			
			
		}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setmId(rs.getString("mId"));
				member.setmPw(rs.getString("mPw"));
				member.setmName(rs.getString("mName"));
				
				return member;
			}
			
		});
		return list;
	}
	
	public void insert(final Member member) {
		
		final String sql = "INSERT INTO member (mId, mPw, mName) VALUES (?, ?, ?)";
		
//		1rd
//		template.update(sql, member.getmId(), member.getmPw(), member.getmPw());
		
//		2rd
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, member.getmId());
//				pstmt.setString(2, member.getmPw());
//				pstmt.setString(3, member.getmName());
//				
//				return pstmt;
//			}
//		});
		
		
		//3rd
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getmId());
				pstmt.setString(2, member.getmPw());
				pstmt.setString(3, member.getmName());
			}
		});
	}
}
