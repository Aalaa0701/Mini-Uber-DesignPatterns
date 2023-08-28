import java.util.ArrayList;

public class Ticket {

    protected String ticketType;

    protected String status;
    protected String assignedAgent;



    protected String Issue;
    public Ticket(String ticketType) {
        this.ticketType = ticketType;
        this.status = "Open";
        this.assignedAgent = null;
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
    public void assignTicketToAgent(String agent) {
        this.assignedAgent = agent;  //setter
        this.status = "In Progress";
    }

    public void updateTicketStatus(String newStatus) {
        this.status = newStatus;    //setter

    }
    public void closeTicket() {
        this.status = "Closed";
        System.out.println("Ticket Closed !");

    }


}





