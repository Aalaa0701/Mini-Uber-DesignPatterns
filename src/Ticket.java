import java.util.ArrayList;
import java.util.List;


// Ticket.java
public class Ticket {

    protected String ticketType;
    protected String ticketMaker;
    protected String status;
    protected String Issue = "";



    public Ticket(String ticketType) {
        this.ticketType = ticketType;
        this.status = "Open";
    }


    public void updateTicketStatus(String newStatus) {
        this.status = newStatus;

    }

    public String getTicketMaker() {
        return ticketMaker;
    }

    public void setTicketMaker(String ticketMaker) {
        this.ticketMaker = ticketMaker;
    }

    public void setIssue(String Issue){

        this.Issue= Issue;
    }
    public String getIssue() {
        return Issue;
    }
    public String getTicketType() {
        return ticketType;
    }

    public String getStatus() {
        return status;
    }





}





