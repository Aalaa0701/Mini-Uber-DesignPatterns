import java.util.ArrayList;
import java.util.Scanner;
class RideTicket extends Ticket implements Request_ticket {
    private ArrayList<String> ride_Issues;

    public RideTicket() {
        super("Ride");
    }
    public void request(){

        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Enter Your Ride issue ");
        String issue = myObj.nextLine();
        this.status = "Pending";
        this.Issue = issue;
        ride_Issues.add(issue+" Status : "+this.status);

        System.out.println("Thanks for contacting Service Support Your request is pending now ");


    }

}



