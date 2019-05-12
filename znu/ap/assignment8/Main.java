package assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println("type : 1- StudyStudent\n" + "2-GratudedStudent");
            for(int i=0;i<n;i++){
                if(sc.nextInt()==1){
                    try {
                        studystudent student = new studystudent();
                        System.out.println("Enter Name:");
                        sc.nextLine();
                        student.setName(sc.nextLine());
                        System.out.println("Enter Lastname:");
                        student.setLastName(sc.nextLine());
                        System.out.println("Enter StudentNumber");
                        student.setStudentNumber(sc.nextInt());
                        System.out.println("Enter Units:");
                        student.setUnits(sc.nextInt());
                        FileHandller.addStudent(student);
                    }catch (studystudent.WrongUnitsNumber e){
                        System.out.println(e);
                    }
                }else{
                    try {
                        gradutestudent student = new gradutestudent();
                        System.out.println("Enter Name:");
                        sc.nextLine();
                        student.setName(sc.nextLine());
                        System.out.println("Enter Lastname:");
                        student.setLastName(sc.nextLine());
                        System.out.println("Enter StudentNumber");
                        student.setStudentNumber(sc.nextInt());
                        System.out.println("Enter Graduted Year:");
                        student.setGraduteYear(sc.nextInt());
                        FileHandller.addStudent(student);
                    }catch (gradutestudent.WorngYearException e){
                        System.out.println(e);
                    }
                }
            }
            ArrayList<student> students = FileHandller.ReadStudents();
            Collections.sort(students);
            for(assignment8.student student:students){
                System.out.println(student.toString());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}