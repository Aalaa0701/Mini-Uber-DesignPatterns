import java.util.Queue;

public class SupportTicketsFile implements FileHandlingForSupportRead, FileHandlingForSupportWrite {
    private static SupportTicketsFile instance = new SupportTicketsFile();
    private SupportTicketsFile(){};

    public static SupportTicketsFile getInstance() {
        return instance;
    }

    @Override
    public void Write(Queue Support) {

    }

    @Override
    public void ReadSupport(Queue Support) {

    }
}
