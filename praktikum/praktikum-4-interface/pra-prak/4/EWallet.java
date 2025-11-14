public class EWallet extends Pembayaran implements Payable, Refundable{
    public EWallet(int balance){
        super(balance);
    }

    public void pay(int amount){
        if (amount > 0 && getBalance() >= amount){
            System.out.println("[EWallet] Paid: " + amount + ". Remaining balance: " +(getBalance()-amount));
            setBalance(getBalance()-amount);
        }
        else{
            System.out.println("[EWallet] Payment failed. Insufficient balance or invalid amount.");
        }
    }

    public void refund(int amount){
        if (amount > 0){
            System.out.println("[EWallet] Refunded: " + amount + ". New balance: " + (getBalance() + amount));
            setBalance(getBalance() + amount);
        }
        else{
            System.out.println("[EWallet] Refund failed. Invalid amount.");
        }
    }
}