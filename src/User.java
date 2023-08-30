import java.util.Vector;

public class User {
    String userName;
    String password;
    Vector<String> tickets;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        tickets = new Vector<>();
    }

    public void updateTicketsForUser(String update){
        tickets.add(update);
    }

    public void notifyUser(){
        if(tickets.size() > 0){
            for(int i = 0;i<tickets.size();i++){
                System.out.println(tickets.get(i));
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

