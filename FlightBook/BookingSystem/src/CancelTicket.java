import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CancelTicket {
	static void cancel()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the flight number you want to cancel");
		int fno  = sc.nextInt();
		System.out.println("Please enter your phone number");
		String phone  = sc.next();
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		PreparedStatement s = c.prepareStatement("delete from passenger where phoneno = ? and flightno = ?");
		s.setString(1,phone);
		s.setInt(2,fno);
		s.executeUpdate();
		System.out.println("Your ticket is successfully cancelled");
		c.close();
		//sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
