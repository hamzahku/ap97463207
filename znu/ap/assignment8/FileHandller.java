package assignment8;

import java.io.*;
import java.util.ArrayList;

public class FileHandller {
    private static File file =  new File("students.txt");;
    public static void addStudent(student student) throws IOException{
        FileWriter fileWriter = new FileWriter(file,true);
        if(student instanceof gradutestudent){
            fileWriter.write(student.toString());
        }else if(student instanceof studystudent){
            fileWriter.write(student.toString());
        }
        fileWriter.close();
    }
    public static ArrayList<student> ReadStudents() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        ArrayList<student> students = new ArrayList<>();
        while(line!=null){
            String[] info = line.split("\t");
            if(info[0].equals("Study")){
                studystudent student = new studystudent(info[1],info[2],Integer.valueOf(info[3]),Integer.valueOf(info[4]));
                students.add(student);
            }else{
                gradutestudent student = new gradutestudent(info[1],info[2],Integer.valueOf(info[3]),Integer.valueOf(info[4]));
                students.add(student);
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return students;
    }
}