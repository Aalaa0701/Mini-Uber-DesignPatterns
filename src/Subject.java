public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public void setStatus(String status);

    Object getStatus();
    //public void getStatus(String status);
}