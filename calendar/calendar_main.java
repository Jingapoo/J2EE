package calendar;


import java.time.LocalDate;
import java.time.Month;
/**
 * A year calendar
 * Notes: Leap year 366 days
 *
 */

public class calendar_main {

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


    public static void main(String[] args) {

        /*
        all the dates from 1900 year to current year
         */

        int daysInYears = 0;
        int daysInMonths = 0;
        int monthDays = 0;
        int remainder = 0;
        // Getting the current date value
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        Month currentMonth = currentDate.getMonth(); // April
        int currentMonthInt = currentMonth.getValue();

        for (int i = 1900; i < currentYear; i++) {
            // Leap year is the year that can divided by 400 without remainder or can divided by 4 but not 100
            daysInYears += (i % 4 == 0 && i % 100 != 0) || i % 400 == 0 ? 366 : 365;
        }

        // Calculating days in current month
        for (int i = 1; i < currentMonthInt; i++) {
            if (i == 4 || i == 6 | i == 9 || i == 11) {
                daysInMonths += 30;
            } else if (i == 2) {
                daysInYears += (currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0 ? 29 : 28;
            } else {
                daysInMonths += 31;
            }
        }

        //calculating current month to confirm 1st date match which Week date(M/T/W/TH/F)
        remainder = (daysInYears + daysInMonths) % 7;

        if (currentMonthInt == 4 || currentMonthInt == 6 | currentMonthInt == 9 || currentMonthInt == 11) {
            monthDays = 30;
        }else if (currentMonthInt == 2) {
            monthDays += (currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0 ? 29 : 28;
        } else {
            monthDays = 31;
        }

        for(int m = 1; m <= 12; m++) {

            numberToMonth(m);

            System.out.print(" " + currentYear);

            System.out.println();

            System.out.println("Mo\tTu\tWe\tTh\tFr\tSa\tSu\n");

//        System.out.println(remainder); // 3 in April

            // print out the empty space before month
            for (int i = 0; i < remainder; i++) {
                System.out.print("\t");
            }
            // print out the dates
            for (int j = 1; j <= monthDays; j++) {
                if ((j + remainder) % 7 == 0) {
                    System.out.println(" " + j + "\t\n");
                } else {
                    System.out.print(" " + j + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
