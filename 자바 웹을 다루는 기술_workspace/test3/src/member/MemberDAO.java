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
			System.out.println("����̹� �ε� ����");
			DriverManager.getConnection(url, user, password);
			System.out.println("Connection ���� ����");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
