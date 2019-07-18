import java.util.Scanner;

public class FlightReservationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		int ch;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			
			System.out.println("Please select an option");
			System.out.println("1.Book a ticket\n2.Cancel a ticket\n3.Search for the flight\n4.View Reservation Details\n5.Exit");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("BOOKING");
					BookTicket.booking();
					break;//booking1
					

				case 2:
					System.out.println("cancel");//cancel
					CancelTicket.cancel();
					
					break;

				case 3:
					System.out.println("Flight Search");
					FlightInformation.search();//flight search
					break;

				case 4:
					System.out.println("view details"); //view details
					ViewTicket.viewTicket();
					break;
				case 5: System.exit(0);
				
				default: 	System.out.println("Invalid");
			}
			
			
		}
		
		
	}

}
