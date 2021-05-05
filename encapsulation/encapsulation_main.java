package encapsulation;

import java.util.Scanner;
import java.util.regex.*;

public class encapsulation_main {

    public static void main(String[] args) {


        Calendar calendar = new Calendar();

        Scanner input = new Scanner(System.in);

        System.out.println("Which year's calendar you would like to inquiry....Please enter a year no less than 1900..");

        while(true) {

            String numS = input.nextLine(); // if decimal will throw InputMismatchException...

            String regex = "[0-9]+"; //Regex to check string contains only digits
            Pattern p = Pattern.compile(regex); //Compile the ReGex

            Matcher m = p.matcher(numS); //Find match between given string and regex using Pattern.matcher()

            if ((numS == null) == true || numS.isEmpty() == true) {
                System.out.println("The input can't be empty or null!");
                continue;
            }else if (numS.length() != 4) {
                System.out.println("Not Valid format! Please re-enter...");
                continue;
            }else if(m.matches() == false){
                System.out.println("The number can ONLY be 4 digits! Please re-enter...");
                continue;
            }else{
                int num = Integer.parseInt(numS);
                if(num < 1900){
                    System.out.println("The earliest year you can inquiry is 1900! Please re-enter...");
                    continue;
                }else{
                    calendar.printCalendar(num);
                }
            }
        }

    }

}

