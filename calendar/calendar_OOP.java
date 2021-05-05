package calendar;

import java.time.LocalDate;

public class calendar_OOP {

    public static void numberToMonth(int num) {

        switch (num) {
            case 1:
                System.out.print("January");
                break;
            case 2:
                System.out.print("February");
                break;
            case 3:
                System.out.print("March");
                break;
            case 4:
                System.out.print("April");
                break;
            case 5:
                System.out.print("May");
                break;
            case 6:
                System.out.print("June");
                break;
            case 7:
                System.out.print("July");
                break;
            case 8:
                System.out.print("August");
                break;
            case 9:
                System.out.print("September");
                break;
            case 10:
                System.out.print("October");
                break;
            case 11:
                System.out.print("November");
                break;
            case 12:
                System.out.print("December");
                break;

        }

    }

    public static void main(String[] args){

        // Getting the current date value
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        printCalendar(currentYear);
    }

    /**
     * Determine whether current year is leap year
     */
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * count days in month
     */
    public static int countDaysInMonth(int month, int year){
        if (month == 4 || month == 6 | month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else {
            return 31;
        }
    }

    /**
     * count days in all months
     */

    public static int countDaysInAllMonths(int currentMonth, int currentYear){
        int daysInAllMonths = 0;
        for(int i = 1; i < currentMonth; i++){
            daysInAllMonths += countDaysInMonth(i, currentYear);
        }
        return daysInAllMonths;
    }

    /**
     * Count daysInAllYears, from 1900 to current year
     */

    public static int countDaysInAllYears(int currentYear){
        int daysInAllYears = 0;
        for(int i = 1900; i < currentYear; i++){
            daysInAllYears += isLeapYear(i) ? 366 : 365;
        }
        return daysInAllYears;
    }

    /**
     * print out A year calendar
     */

    public static void printCalendar(int currentYear){

        int daysInAllYears = countDaysInAllYears(currentYear);
        for(int i = 1; i <= 12; i++){

            System.out.print("\t\t\t\t\t");

            numberToMonth(i);

            System.out.println();

            System.out.println("Mo\t\tTu\t\tWe\t\tTh\t\tFr\t\tSa\t\tSu\n");

            int emptySpace = (daysInAllYears + countDaysInAllMonths(i, currentYear)) % 7;

            for (int j = 0; j < emptySpace; j++) {
                System.out.print(" \t\t");
            }

            for (int k = 1; k <= countDaysInMonth(i, currentYear); k++) {
                if ((k + emptySpace) % 7 == 0) {
                    System.out.println(k + " \t\t");
                } else {
                    System.out.print(k + " \t\t");
                }
            }
            System.out.println();
        }
    }
}
