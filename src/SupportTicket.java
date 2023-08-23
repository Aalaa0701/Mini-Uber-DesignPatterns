public class SupportTicket {
    String customerName;
    String agentName;
    String ticketContent;


    public SupportTicket(String customerName, String agentName, String ticketContent) {
        this.customerName = customerName;
        this.agentName = agentName;
        this.ticketContent = ticketContent;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getTicketContent() {
        return ticketContent;
    }
}
