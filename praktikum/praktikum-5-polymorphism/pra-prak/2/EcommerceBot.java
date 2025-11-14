public class EcommerceBot extends CustomerServiceBot{
    private String website;

    public EcommerceBot(String name, String website){
        super(name);
        this.website = website;
    }

    public void respond(){
        System.out.println("Ecommerce bot " + getName() + " dari " + website + " siap melayani Anda");
    }

    public void displayInfo(){
        System.out.println("Ecommerce Bot "+ getName() + " dari " + website + " telah melayani " + getSessionCount() + " sesi");
    }

    public void processOrder(String order){
        System.out.println("Memproses pesanan: " + order + " dari " + website);
    }

    public String getBotType(){
        return "Ecommerce Bot";
    }
}