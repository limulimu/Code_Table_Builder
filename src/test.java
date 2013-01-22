import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import weka.core.Instances;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
		String dbURL = "jdbc:sqlserver://greenapple.it.uts.edu.au:1433; DatabaseName=Stu_Development"; // 连接服务器和数据库test
		String userName = "stu"; // 默认用户名
		String userPwd = "utsedu"; // 安装sql server 2005时的密码
		Connection dbConn = null;

		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("Connection Successful!"); // 如果连接成功
															// 控制台输出Connection
															// Successful!
		} catch (Exception e) {
			e.printStackTrace();
		}
		CodeTableService sc=new CodeTableService();
		List<CodeTable> ll = sc.genCodeTable("Test_CP_48510", "*", "1", dbConn);
		
		int a =0;

	}

}
