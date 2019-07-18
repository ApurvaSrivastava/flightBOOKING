import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewTicket {
	static void viewTicket()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Plese enter your flight number");
		int fno = sc.nextInt();
		System.out.println("Plese enter your phone number");
		String phone = sc.next();
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		PreparedStatement s = c.prepareStatement("select * from passenger where phoneno = ? and flightno = ?");
		s.setString(1,phone);
		s.setInt(2, fno);
		ResultSet rs = s.executeQuery();
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "
			+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
		c.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
