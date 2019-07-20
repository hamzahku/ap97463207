/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class TeacherInfo {
    
    private String name;
    private String family;
    private String ID;
    public ArrayList<ClassInfo> ListClass = new ArrayList<>();
     public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getID() {
        return ID;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
     public void AddClass(String name,int v,String dt)
    {
        ClassInfo temp=new ClassInfo(name,v,dt);
        
        ListClass.add(temp);
        
    }
    
     public  ArrayList<Object>showstudent(List<studentInfo>ListStudent,String ClassName){
      
       ArrayList<Object>r=new ArrayList<>();
       int count=0;
         for (int i = 0; i < ListStudent.size(); i++) {
            for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {
                if (ListStudent.get(i).ListClass.get(j).getName().equals(ClassName)) {

                    r.add(new Object[]{ListStudent.get(i).ListStudentScores.get(j).score, ListStudent.get(i).getFamily(), ListStudent.get(i).getName()});

                    
                }
            }
        }
         
         return r;
     }

    void setScore(String ClassName, String Name, String Family, int Nomreh, ArrayList<studentInfo> ListStudent) {
   
      for (int i = 0; i < ListStudent.size(); i++) {
            if (ListStudent.get(i).getName().equals(Name) && ListStudent.get(i).getFamily().equals(Family)) {
                for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {
                    if (ListStudent.get(i).ListStudentScores.get(j).name.equals(ClassName)) {
                        ListStudent.get(i).ListStudentScores.get(j).score = Nomreh;
                    }
                }
            }
        }

        try {
            URL url = getClass().getResource("Student.txt");
            FileWriter FileStudent = new FileWriter(url.getPath());
            String newLine = System.getProperty("line.separator");
           
            for (int i = 0; i < ListStudent.size(); i++) {
                FileStudent.write(ListStudent.get(i).getName() + newLine);
                FileStudent.write(ListStudent.get(i).getFamily() + newLine);
                FileStudent.write(ListStudent.get(i).getID() + newLine);
                FileStudent.write(ListStudent.get(i).ListClass.size() + newLine);

                for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {

                    FileStudent.write(ListStudent.get(i).ListClass.get(j).getName() + newLine);
                    FileStudent.write(ListStudent.get(i).ListClass.get(j).getVahed() + newLine);
                    FileStudent.write(ListStudent.get(i).ListClass.get(j).getDateTime() + newLine);

                }

                FileStudent.write(ListStudent.get(i).ListStudentScores.size() + newLine);

                for (int j = 0; j < ListStudent.get(i).ListStudentScores.size(); j++) {

                    FileStudent.write(ListStudent.get(i).ListStudentScores.get(j).name + newLine);
                    FileStudent.write(ListStudent.get(i).ListStudentScores.get(j).score + newLine);

                }

            }
            FileStudent.close();
            JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

        }
       
    }

    void Jozve(String text, String Filename) {
     try {
            URL url = getClass().getResource("Jozveh.txt");
            FileWriter FileJozve = new FileWriter(url.getPath());
            String newLine = System.getProperty("line.separator");
            FileJozve.write(text + newLine);
            FileJozve.write(Filename + newLine);
            FileJozve.close();
        } catch (Exception e) {

        }
    JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
 }

    void deleteStudent(String Name, String Family, String ClassName, ArrayList<studentInfo> ListStudent) {
     for (int i = 0; i < ListStudent.size(); i++) {
            if (ListStudent.get(i).getName().equals(Name) && ListStudent.get(i).getFamily().equals(Family)) {
                for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {
                    if (ListStudent.get(i).ListClass.get(j).getName().equals(ClassName)) {

                        ListStudent.get(i).ListClass.remove(j);
                        ListStudent.get(i).ListStudentScores.remove(j);

                    }
                }
            }
        }
        try {
            URL url = getClass().getResource("Student.txt");
            FileWriter FileStudent = new FileWriter(url.getPath());
            String newLine = System.getProperty("line.separator");
            
            for (int i = 0; i < ListStudent.size(); i++) {
                FileStudent.write(ListStudent.get(i).getName() + newLine);
                FileStudent.write(ListStudent.get(i).getFamily() + newLine);
                FileStudent.write(ListStudent.get(i).getID() + newLine);
                FileStudent.write(ListStudent.get(i).ListClass.size() + newLine);

                for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {

                    FileStudent.write(ListStudent.get(i).ListClass.get(j).getName() + newLine);
                    FileStudent.write(ListStudent.get(i).ListClass.get(j).getVahed() + newLine);
                    FileStudent.write(ListStudent.get(i).ListClass.get(j).getDateTime() + newLine);

                }

                FileStudent.write(ListStudent.get(i).ListStudentScores.size() + newLine);

                for (int j = 0; j < ListStudent.get(i).ListStudentScores.size(); j++) {

                    FileStudent.write(ListStudent.get(i).ListStudentScores.get(j).name + newLine);
                    FileStudent.write(ListStudent.get(i).ListStudentScores.get(j).score + newLine);

                }

            }
            FileStudent.close();
            JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

        }
      }

    void SetAzmon(String text) {
      try {
            URL url = getClass().getResource("Azmon.txt");
            FileWriter FileAzmon = new FileWriter(url.getPath());
            String newLine = System.getProperty("line.separator");
            FileAzmon.write(text + newLine);
            FileAzmon.close();

        } catch (Exception e) {

        }
        JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
}

    void showAns(JTextArea jTextArea1) {
   URL url1 = getClass().getResource("Answer.txt");
        File Azmon = new File(url1.getPath());
        String newLine = System.getProperty("line.separator");
        ArrayList<String> stlst;
        try {

            stlst = (ArrayList<String>) Files.readAllLines(Paths.get(Azmon.getPath()));

            for (int i = 0; i < stlst.size(); i++) {
                jTextArea1.setText(jTextArea1.getText() + stlst.get(i) + newLine + newLine);
            }

        } catch (Exception e) {

        }  }

   
}
