
package assignment8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {


        Scanner sc = new Scanner(System.in);
        Studying s = new Studying();
        graduate g = new graduate();

        try {



            System.out.println(">>>> Enter number of student for add ");
            int x = sc.nextInt();
            for (int i = 0; i < x; i++) {

                System.out.println("press >>>> 1 to add student studying\n"+
                                   "press >>>> 2 to add student graduate");
                int n = sc.nextInt();


                try {

                    System.out.println("Enter Name :");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter Lastname :");
                    String lastname=sc.nextLine();
                    System.out.println("Enter StudentNumber :");
                    int studentNumber = sc.nextInt();


                    if (n == 1) {
                        System.out.println("Enter Units :");
                        s.setUnits(sc.nextInt());
                        s.setName(name);
                        s.setLastName(lastname);
                        s.setStudentNumber(studentNumber);
                        filestudents.addStudent(s);

                    } else {
                        System.out.println("Enter Graduated Year:");
                        g.setGraduteYear(sc.nextInt());
                        g.setName(name);
                        g.setLastName(lastname);
                        g.setStudentNumber(studentNumber);
                        filestudents.addStudent(g);
                    }

                } catch (Studying.WrongUnitsNumber e) {
                    System.out.println(e);
                } catch (graduate.WorngYearException e) {
                    System.out.println(e);
                }
            }

            ArrayList<studentMain> list_students = filestudents.ReadStudents();
            Collections.sort(list_students);
            for (studentMain student : list_students) {
                System.out.println(student.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}
