

package assignment8;
import java.io.*;
import java.util.ArrayList;

public class filestudents {


    private static File file =  new File("students.txt");

    public static void addStudent(studentMain student) throws IOException {
        FileWriter fileWriter = new FileWriter(file,true);
        if(student instanceof graduate){
            fileWriter.write(student.toString());
        }else if(student instanceof Studying){
            fileWriter.write(student.toString());
        }
        fileWriter.close();
    }


    public static ArrayList<studentMain> ReadStudents() throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        ArrayList<studentMain> students = new ArrayList<>();
        while(line!=null){
            String[] info = line.split("\t");
            if(info[0].equals("Study")){
                Studying student = new Studying(info[1],info[2],Integer.valueOf(info[3]),Integer.valueOf(info[4]));
                students.add(student);
            }else{
               graduate student = new graduate(info[1],info[2],Integer.valueOf(info[3]),Integer.valueOf(info[4]));
                students.add(student);
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return students;
    }
}
