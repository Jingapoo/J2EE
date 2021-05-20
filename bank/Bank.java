package bank;

import java.util.ArrayList;
import java.util.UUID;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewUserUUID(){

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();

        return uuidStr;

    }
    public String getNewAccountUUID(){

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();

        return uuidStr;
    }

    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    public User addUser(String firstName, String lastName, String pin){
        // create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //create a savings account
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    public User login(String userID, String pin){

        for(User u: this.users){
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }

        return null;
    }

    public String getName(){
        return this.name;

    }


}
