import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

class RideTicket extends Ticket implements Request_ticket {
    private Vector<RideTicket> rideTickets;

    public RideTicket(){
        super("ride");
    }
    public RideTicket(String ticketType, Vector<RideTicket> rideTickets) {
        super(ticketType);
        this.rideTickets = rideTickets;
    }


    public void request() {
        Scanner myObj = new Scanner(System.in);
        this.updateTicketStatus("Pending");
        System.out.println("Please Enter Your Ride issue ");
        String issue = myObj.nextLine();
        this.setIssue(issue);

        System.out.println("Thanks for contacting Service Support Your request is pending now ");
        rideTickets.add(this);

    }
}