package member;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##scott";
	String password = "1234";
	MemberDAO() {
		connDB();
	}
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
