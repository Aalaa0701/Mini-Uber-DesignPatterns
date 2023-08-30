import java.util.*;

public class Agent implements Subject{
    private String agentId;

    Map<String, User> users;
    private Vector<RideTicket> rideTickets;
    private Vector<PaymentTicket> paymentTickets;

    Ticket chosenTicket;

    public Agent(String agentId, Map<String, User> users, Vector<RideTicket> rideTickets, Vector<PaymentTicket> paymentTickets) {
        this.agentId = agentId;
        this.users = users;
        this.rideTickets = rideTickets;
        this.paymentTickets = paymentTickets;
    }

    public void viewTickets(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("please enter 1 to view Ride tickets or 2 to view Payment tickets");
            int choice = input.nextInt();
            if(choice == 1){
                System.out.println("Choose one of available rides");
                if(rideTickets.size() > 0){
                    for(int i = 0; i < rideTickets.size(); i++){
                        System.out.println((i+1) +" "+ rideTickets.get(i).getTicketMaker() +" "+rideTickets.get(i).getIssue());
                    }
                    int number = input.nextInt();
                    setChosenTicket(rideTickets.get(number-1));
                }
                else{
                    System.out.println("No tickets are available");
                }
                break;
            }
            else if(choice == 2){
                System.out.println("Choose one of available rides");
                if(paymentTickets.size() > 0){
                    for(int i = 0; i < paymentTickets.size(); i++){
                        System.out.println((i+1) +" "+ paymentTickets.get(i).getTicketMaker() +" "+paymentTickets.get(i).getIssue());
                    }
                    int number = input.nextInt();
                    setChosenTicket(paymentTickets.get(number-1));
                }
                else{
                    System.out.println("No tickets are available");
                }
                break;
            }
            else{
                System.out.println("please enter a valid number");
            }
        }
    }
    public void setChosenTicket(Ticket chosenTicket) {
        this.chosenTicket = chosenTicket;
    }

    public void acceptTicket() {
        chosenTicket.updateTicketStatus("Accepted");
    }

    public void closeTicket() {
        chosenTicket.updateTicketStatus("Closed");
        System.out.println("Ticket Closed !");
        if(chosenTicket.getTicketType().equals("ride")){
            rideTickets.remove((RideTicket) chosenTicket);
        }
        else if(chosenTicket.getTicketType() .equals("payment")){
            paymentTickets.remove((PaymentTicket) chosenTicket);
        }

    }

    public Agent(String agentId){
        this.agentId=agentId;
    }

    @Override
    public void notifyObserver() {
        String update = "Your ticket of type " + chosenTicket.getTicketType() + " was accepted";
        users.get(chosenTicket.getTicketMaker()).updateTicketsForUser(update);
    }
}




