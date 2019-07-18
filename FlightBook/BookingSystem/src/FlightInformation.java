import java.sql.*;
import java.util.Scanner;
public class FlightInformation {
	public static void search()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			System.out.println("Enter your Source");
			String src = sc.nextLine();
			
			System.out.println("Enter your destination");
			String des = sc.nextLine();
			
			PreparedStatement s = c.prepareStatement("select * from flight where destination = ? and source = ?");
			s.setString(1, des);
			s.setString(2, src);
			ResultSet rs=s.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getInt(4)+" "+rs.getInt(5));
			}
			c.close();
			//sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
