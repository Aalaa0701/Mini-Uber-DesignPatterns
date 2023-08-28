import java.util.ArrayList;

public class Ticket {

    protected String ticketType;
    protected String ticketMaker;

    protected String status;

    protected String Issue;

    public Ticket(String ticketType) {
        this.ticketType = ticketType;
        this.status = "Open";
        this.Issue = null;
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

    public String getTicketMaker() {
        return ticketMaker;
    }

    public void setTicketMaker(String ticketMaker) {
        this.ticketMaker = ticketMaker;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    public void updateTicketStatus(String newStatus) {
        this.status = newStatus;    //setter

    }
    public void closeTicket() {
        this.status = "Closed";
        System.out.println("Ticket Closed !");

    }


}





