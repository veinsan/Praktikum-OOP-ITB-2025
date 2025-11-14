public class MathTutorBot extends EducationalBot{
    private String subject;

    public MathTutorBot(String name, String subject){
        super(name);
        this.subject = subject;
    }

    public void respond(){
        System.out.println("Math tutor bot " + getName() + " untuk subject " + subject + " siap membantu");
    }

    public void displayInfo(){
        System.out.println("Math Tutor Bot " + getName() + " untuk subject " + subject + " telah melayani " + getSessionCount() + " sesi");
    }

    public void solveProblem(String problem){
        System.out.println("Menyelesaikan soal " + subject + ": " + problem);
    }

    public String getBotType(){
        return "Math Tutor Bot";
    }
}
