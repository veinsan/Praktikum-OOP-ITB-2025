public class COD extends Pembayaran implements Payable{
    public COD(int balance){
        super(balance);
    }

    public void pay(int amount){
        if (amount > 0 && getBalance() >= amount){
            System.out.println("[COD] Paid: " + amount + ". Remaining balance: " +(getBalance()-amount));
            setBalance(getBalance()-amount);
        }
        else{
            System.out.println("[COD] Payment failed. Insufficient balance or invalid amount.");
        }
    }
}
