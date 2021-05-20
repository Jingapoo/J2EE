package student_enrollment;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private double tuitionBalance = 0.00;
    private static int costOfCourse = 600;
    private static int id = 1000;


    public void gradeYearToLevel(int num) {

        switch (num) {
            case 1:
                System.out.print("Freshmen");
                break;
            case 2:
                System.out.print("Sophomore");
                break;
            case 3:
                System.out.print("Junior");
                break;
            case 4:
                System.out.print("Senior");
                break;
        }

    }

    public Student() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        firstName = sc.nextLine();

        System.out.print("Enter student Last name: ");
        lastName = sc.nextLine();

        System.out.print("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nPlease choose student class level: ");
        gradeYear = sc.nextInt();

        setStudentID();

//        System.out.print(firstName + " " + lastName  + " " + studentID + " ");
//
//        gradeYearToLevel(gradeYear);
//
//        System.out.println();


    }

    private void setStudentID(){
        id++;
        // Grade Level + ID
        this.studentID = gradeYear + "" + id;
    }

    public void enroll(){
        do{
            System.out.print("Enter course to enroll(Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if(!course.equals("Q")){
                courses = courses + "\n " + course;
                tuitionBalance  = tuitionBalance + costOfCourse;
            }else{
                break;
            }
        }while(1 != 0);

        System.out.println("ENROLLED IN: " + courses);

    }

    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition(){
        viewBalance();
        System.out.print("Enter the amount you would like to pay: $");
        Scanner input = new Scanner(System.in);
        double payment = input.nextDouble();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();

    }
    public void showInfo(){

        System.out.println("Name: " + firstName + " " + lastName + "\nStudent ID: " + studentID);

        System.out.print("Class Level: ");
        gradeYearToLevel(gradeYear);

        System.out.println();

        System.out.println("Courses Enrolled: " + courses + "\nBalance: $" + tuitionBalance);

    }

}
