import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

class PaymentTicket extends Ticket implements Request_ticket {
   Vector<PaymentTicket> paymentTickets;



    public PaymentTicket() {
        super("Payment");

    }

        public PaymentTicket(String ticketType, Vector<PaymentTicket> paymentTickets) {
        super(ticketType);
        this.paymentTickets = paymentTickets;
    }

    public void request(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Hello,Your ticket is open now ,Please Enter Your username ");
        String username = myObj.nextLine();
        System.out.println("Please Enter Your Issue ");
        String issue = myObj.nextLine();
        this.status = "Pending";
        this.setTicketMaker(username);
        this.setIssue(issue);
        System.out.println("Thanks for connecting Support Team, Your request is pending now ");
        paymentTickets.add(this);
    }
}