import java.io.File;
import java.io.FileNotFoundException;
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


    }

    @Override
    public void readSupport(Queue Support) {
        try{
            File supportTicketsFile = new File("src/SupportTickets.txt");
            Scanner ticketsScan = new Scanner(supportTicketsFile);
            StringBuilder stringBuilder = new StringBuilder();
            ticketsScan.useDelimiter("//");
            while(ticketsScan.hasNext()){
                String word = ticketsScan.next();
                stringBuilder.append(word);

            }
            ticketsScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }

    }
}
