import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLIntegration {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo" , "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select * from data where name = 'kalyani';");
		
		rs.next();
		
		System.out.println(rs.getInt("id"));
		System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("age"));
		System.out.println(rs.getString("place"));

	}

}
