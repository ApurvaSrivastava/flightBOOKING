import java.sql.*;
import java.util.Scanner;

public class BookTicket {
	static void booking()
	{
		Scanner sc = new Scanner(System.in);
		int fno;
		String userName;
		String email;
		String phone;
		int seat=0;
		String rest;
		try 
		{
			//Load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish connection to the database
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
						
			System.out.println("Enter flight number you want to book");
			fno=sc.nextInt();
			
			System.out.println("Enter your reservation type");
			rest=sc.next();
			
			System.out.println("Provide your name");
			userName=sc.next();
			
			System.out.println("Enter your phone number");
			phone=sc.next();
			
			
			System.out.println("Provide your email address");
			email=sc.next();
									
			// get the seat number for the respective type and flight from the table flight
			PreparedStatement s = c.prepareStatement("select * from flight where flightno = ?");
			s.setInt(1, fno);
			ResultSet rs = s.executeQuery();
			while(rs.next())
			{
				seat = rest.equalsIgnoreCase("economy")?rs.getInt(4):rs.getInt(5);
				System.out.println(seat);
			}
			
			// update the seat number in flight table
			if(rest.equalsIgnoreCase("Economy"))
			{
					
				PreparedStatement s1 = c.prepareStatement("update flight set economy = economy-1 where flightno= ?");
				s1.setInt(1, fno);
				s1.executeUpdate();
			}
			else
			{
				PreparedStatement s1 = c.prepareStatement("update flight set business = business-1 where flightno= ?");
				s1.setInt(1, fno);
				s1.executeUpdate();
			}
			
			//Inserting the details of ticket in to the passenger table
			PreparedStatement s2=c.prepareStatement("insert into passenger values(?,?,?,?,?,?)");
			s2.setInt(1,fno );
			s2.setString(2,rest);
			s2.setInt(3,seat);
		    s2.setString(4,userName);
			s2.setString(5,phone);
			s2.setString(6,email);
			s2.executeUpdate();
			System.out.println("Ticket booked successfully");			
			c.close();
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
