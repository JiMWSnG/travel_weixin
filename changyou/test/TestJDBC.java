
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestJDBC {
//	private static  DBPool pool=new DBPool();
	public static Connection getConn() {
		Connection conn = null;
		String url = "jdbc:mysql://192.168.42.130/peanut";
		String username = "mysql";
		String password = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);// 取消自动提交
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
//		return pool.getDBConn();
		
	}

	public static  void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public static  void close(DBConn dbConn) {
//		if (dbConn != null) {
//			pool.release(dbConn);
//		}
//	}
	
	public static void rollback(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
