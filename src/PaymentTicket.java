import java.util.ArrayList;
import java.util.Scanner;
class PaymentTicket extends Ticket implements Request_ticket {
    private ArrayList<String> payment_Issues;
    private Request_ticket requestTicket;

    @Override
    public void setNextChain(Request_ticket nextChain) {
        this.requestTicket=nextChain;
    }

    public PaymentTicket() {
        super("Payment");

    }
    public void request(Ticket ticketType){
        if(ticketType.getTicketType().equals("Payment")) {
            Scanner myObj = new Scanner(System.in);

            System.out.println("Hello,Your ticket is open now ,Please Enter Your Payment issue ");
            String issue = myObj.nextLine();
            this.status = "Pending";
            payment_Issues.add("Issue" + issue + " Status : " + this.status);
            System.out.println("Thanks for connecting Support Team, Your request is pending now ");
        }
        else {
            requestTicket.request(ticketType);
        }
    }
}