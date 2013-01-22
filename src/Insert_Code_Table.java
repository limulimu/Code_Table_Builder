import java.sql.*;
public class Insert_Code_Table {

	public void insert(String[] input,Connection conn) throws ClassNotFoundException, SQLException
	{
	    // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       // System.out.println("驱动程序已加载");
      //  String connectionUrl = "jdbc:sqlserver://localhost;DatabaseName=Stu_Mining_201208;username=sa;password=123";
        Connection   con = conn;
        Statement s = con.createStatement();
      //  s.executeQuery("insert into codetable (encode) values('999')");
        //s.executeUpdate("truncate table codetable");
        s.executeUpdate("insert into codetable values('"+input[0]+"','"+input[1]+"','"+input[2]+"','"+input[3]+"','"+input[4]+"','"+input[5]+"','"+input[6]+"')");
      
	}
	
};
