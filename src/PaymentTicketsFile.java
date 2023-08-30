import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PaymentTicketsFile implements FileHandlingForRead, FileHandlingForWrite{
    private static PaymentTicketsFile instance = new PaymentTicketsFile();
    private PaymentTicketsFile(){};

    public static PaymentTicketsFile getInstance() {
        return instance;
    }


    @Override
    public void write(Vector support) {
        File ticketsFile = new File("src/PaymentTickets.txt");
        try{
            PrintWriter ticketsWriter = new PrintWriter(new FileWriter(ticketsFile));
            for(int i =0;i<support.size();i++){
                PaymentTicket temp = (PaymentTicket) support.get(i);
                //String line = temp.getDriver().getDriverName()+" "+temp.getDriver().getDriverRate();
                String line = temp.getTicketMaker()+" "+temp.getStatus()+" "+temp.getIssue();
                ticketsWriter.println(line);
            }

            ticketsWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void read(Vector support) {
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
                    ticketTemp.updateTicketStatus(status);
                    ticketTemp.setIssue(ticketContent);
                    //Support.add(supportTicketTemp);
                    support.add(ticketTemp);
                }


            }
            ticketsScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }
}
