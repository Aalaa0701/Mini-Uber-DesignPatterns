import java.util.ArrayList;
import java.util.List;


// Ticket.java
public class Ticket implements Subject {

    protected String ticketType;

    protected String status;
    protected String assignedAgent;



    protected String Issue;
    private List<Observer> observers;
    public Ticket(String ticketType) {
        this.ticketType = ticketType;
        this.status = "Open";
       // this.assignedAgent = null;
        this.Issue = null;
        this.observers=new ArrayList<>();
    }
// new Update
    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if(!observers.contains(obj)) observers.add(obj);
    }
    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }
    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update();
        }
    }
    @Override
    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
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





