import java.io.*;
import java.util.Queue;
import java.util.Scanner;

public class PaymentTicketsFile implements FileHandlingForSupportRead, FileHandlingForSupportWrite{
    private static PaymentTicketsFile instance = new PaymentTicketsFile();
    private PaymentTicketsFile(){};

    public static PaymentTicketsFile getInstance() {
        return instance;
    }

    @Override
    public void readSupport(Queue Support) {
        try{
            File supportTicketsFile = new File("src/PaymentTickets.txt");
            Scanner ticketsScan = new Scanner(supportTicketsFile);
            while(ticketsScan.hasNextLine()){
                String username, status, ticketContent ="";
                String[] line = ticketsScan.nextLine().split(" ");
                if (line.length > 2) {
                    username = line[0];
                    status = line[1];
                    for(int i =2;i< line.length;i++){
                        ticketContent+=line[i];
                        if(i< line.length-1){
                            ticketContent+=" ";
                        }
                    }
                    PaymentTicket ticketTemp = new PaymentTicket();
                    ticketTemp.setTicketMaker(username);
                    ticketTemp.setStatus(status);
                    ticketTemp.setIssue(ticketContent);
                    //Support.add(supportTicketTemp);
                    Support.offer(ticketTemp);
                }


            }
            ticketsScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }

    @Override
    public void write(Queue Support) {
        File ticketsFile = new File("src/PaymentTickets.txt");
        try{
            PrintWriter ticketsWriter = new PrintWriter(new FileWriter(ticketsFile));
            while(!Support.isEmpty()){
                String line ="";
                PaymentTicket temp = (PaymentTicket) Support.poll();
                line= temp.getTicketMaker()+" "+temp.getStatus()+" "+temp.getIssue();
                ticketsWriter.println(line);
            }

            ticketsWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}
