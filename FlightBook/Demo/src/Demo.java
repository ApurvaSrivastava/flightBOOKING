import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {
	public static void main(String args[])
	{
		//int fno = 201;
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		PreparedStatement s = c.prepareStatement("select * from plane where flightno = 201");
	//	s.setInt(1, fno);
		
		ResultSet rs = s.executeQuery();
		while(rs.next())
			System.out.println( rs.getString(2));
		c.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}


