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
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����
		String dbURL = "jdbc:sqlserver://greenapple.it.uts.edu.au:1433; DatabaseName=Stu_Development"; // ���ӷ����������ݿ�test
		String userName = "stu"; // Ĭ���û���
		String userPwd = "utsedu"; // ��װsql server 2005ʱ������
		Connection dbConn = null;

		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("Connection Successful!"); // ������ӳɹ�
															// ����̨���Connection
															// Successful!
		} catch (Exception e) {
			e.printStackTrace();
		}
		CodeTableService sc=new CodeTableService();
		List<CodeTable> ll = sc.genCodeTable("Test_CP_48510", "*", "1", dbConn);
		
		int a =0;

	}

}
