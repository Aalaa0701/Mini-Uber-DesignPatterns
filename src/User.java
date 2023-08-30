import java.util.Vector;

public class User implements Observer {
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void update() {
        if(tickets.size() > 0){
            for(int i = 0;i<tickets.size();i++){
                System.out.println(tickets.get(i));
            }
        }
    }
}

