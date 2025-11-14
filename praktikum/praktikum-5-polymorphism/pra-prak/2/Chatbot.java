public abstract class Chatbot{
    private String name;
    private int session;
    public Chatbot(String name){
        this.name = name;
        session = 0;
    }

    public abstract void respond();

    public void startSession(){
        System.out.println("Session started for " + name);
        session++;
    }

    public abstract void displayInfo();

    protected String getName(){
        return name;
    }

    protected void setName(String name){
        this.name = name;
    }

    public String getBotType(){
        return "Chatbot";
    }

    public int getSessionCount(){
        return session;
    }
}