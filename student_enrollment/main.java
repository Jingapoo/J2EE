package student_enrollment;

import java.util.Scanner;

public class main {

    public static void main(String[] args){

        System.out.print("Please enter the number of students to enroll: ");
        Scanner sc = new Scanner(System.in);
        int numOfStudents = sc.nextInt();
        Student[] students = new Student[numOfStudents];

        for(int n = 0; n < numOfStudents; n++){
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
        }
        for(int n = 0; n < numOfStudents; n++){

            students[n].showInfo();
        }

    }
}
