package bank;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    //UUID (Universally Unique Identifier), also known as GUID (Globally Unique Identifier) represents a 128-bit long value that is unique for all practical purposes.
    private String uuid;
    // The MD5 Hash of the user's pin number
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;

        //store the pin's MD5 hash
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }catch (NoSuchAlgorithmException e){
            System.err.println("Error! caught No Such Algorithm Exception. ");
            e.printStackTrace();
            System.exit(1);
        }

        // get a new, unique universal ID for the user
        this.uuid = bank.getNewUserUUID();

        this.accounts = new ArrayList<Account>();

        System.out.printf("New User %s, %s with ID %s created.\n", lastName, firstName, this.uuid);

    }


    public String getUUID(){
        return uuid;
    }
    public boolean validatePin(String aPin){

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        }catch (NoSuchAlgorithmException e){
            System.err.println("Error! caught No Such Algorithm Exception. ");
            e.printStackTrace();
            System.exit(1);
        }

        return false;

    }

    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void printAccountsSummary(){
        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        for(int a = 0; a < this.accounts.size(); a++){
            System.out.printf("%d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    public int numAccounts(){
        return this.accounts.size();
    }

    public void printAcctTransHistory(int acctIndex){
        this.accounts.get(acctIndex).printTransHistory();
    }

    public double getAcctBalance(int acctIndex){
        return this.accounts.get(acctIndex).getBalance();
    }

    public String getAcctUUID(int acctIndex){
        return this.accounts.get(acctIndex).getUUID();
    }

    public void addAcctTransaction(int acctIndex, double amount, String memo) {
        this.accounts.get(acctIndex).addTransaction(amount,memo);
    }
}
