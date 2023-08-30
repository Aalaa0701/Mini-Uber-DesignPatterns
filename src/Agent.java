import java.util.ArrayList;
import java.util.List;

public class Agent  implements Observer {
    private String agentId;
    private Subject ticket;

    public Agent(String agentId){
        this.agentId=agentId;
    }
    @Override
    public void update() {
        String status = (String) ticket.getStatus();
        System.out.println("Agent " + agentId + " updated the ticket status to: " + status);
    }
    public void setTicket(Subject ticket) {
        this.ticket = ticket;
    }
    public void changeTicketStatus(String status) {
        ticket.setStatus(status);
    }

    // other getters and setters
}




/*


 private String agentId;
    private String name;
    private List<Ticket> acceptedTickets;

    public Agent(String agentId, String name) {
        this.agentId = agentId;
        this.name = name;
        this.acceptedTickets = new ArrayList<>();
    }

    public void acceptTicket(SupportTicket ticket) {
        ticket.updateTicketStatus("Accepted");
        acceptedTickets.add(ticket);
    }
    public void closeTicket() {
        this.status = "Closed";
        System.out.println("Ticket Closed !");

    }
 */