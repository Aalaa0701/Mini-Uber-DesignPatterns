import java.io.*;
import java.util.Queue;
import java.util.Scanner;

public class SupportTicketsFile implements FileHandlingForSupportRead, FileHandlingForSupportWrite {
    private static SupportTicketsFile instance = new SupportTicketsFile();
    private SupportTicketsFile(){};

    public static SupportTicketsFile getInstance() {
        return instance;
    }

    @Override
    public void write(Queue Support) {
        File ticketsFile = new File("src/SupportTickets.txt");
        try{
            PrintWriter ticketsWriter = new PrintWriter(new FileWriter(ticketsFile));
            while(!Support.isEmpty()){
                String line ="";
                SupportTicket temp = (SupportTicket) Support.poll();
                line= temp.getCustomerName()+" "+temp.getAgentName()+" "+temp.getTicketContent();
                ticketsWriter.println(line);
            }

            ticketsWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }

    }

    @Override
    public void readSupport(Queue Support) {
        try{
            File supportTicketsFile = new File("src/SupportTickets.txt");
            Scanner ticketsScan = new Scanner(supportTicketsFile);
            while(ticketsScan.hasNextLine()){
                String customerName, agentName, ticketContent ="";
                String[] line = ticketsScan.nextLine().split(" ");
                if (line.length > 2) {
                    customerName = line[0];
                    agentName = line[1];
                    for(int i =2;i< line.length;i++){
                        ticketContent+=line[i];
                        if(i< line.length-1){
                            ticketContent+=" ";
                        }
                    }
                    SupportTicket supportTicketTemp = new SupportTicket(customerName,agentName,ticketContent);
                    //Support.add(supportTicketTemp);
                    Support.offer(supportTicketTemp);
                }


            }
            ticketsScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }

    }

}
