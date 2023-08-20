import java.util.Queue;

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

    }
}
