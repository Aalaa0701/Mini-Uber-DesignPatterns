import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
class RideTicket extends Ticket implements Request_ticket {
    private Queue<RideTicket> rideTickets;

    public RideTicket(){
        super("ride");
    }
    public RideTicket(String ticketType, Queue<RideTicket> rideTickets) {
        super(ticketType);
        this.rideTickets = rideTickets;
    }


    public void request() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Enter your username");
        String username = myObj.nextLine();
        System.out.println("Please Enter Your Ride issue ");
        String issue = myObj.nextLine();
        this.status = "Pending";
        this.Issue = issue;
        this.setTicketMaker(username);

        System.out.println("Thanks for contacting Service Support Your request is pending now ");
        rideTickets.add(this);

    }
}