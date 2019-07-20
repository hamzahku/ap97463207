/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
class AdminInfo {

    void AddTeacher(String name, String family, String id, ArrayList<TeacherInfo> ListTeacher) {

        TeacherInfo temp = new TeacherInfo();

        temp.setName(name);
        temp.setFamily(family);
        temp.setID(id);

        try {
            URL url = getClass().getResource("Teacher.txt");
            FileWriter FileTeacher = new FileWriter(url.getPath());
            String newLine = System.getProperty("line.separator");
            ListTeacher.add(temp);
            for (int i = 0; i < ListTeacher.size(); i++) {
                FileTeacher.write(ListTeacher.get(i).getName() + newLine);
                FileTeacher.write(ListTeacher.get(i).getFamily() + newLine);
                FileTeacher.write(ListTeacher.get(i).getID() + newLine);
                FileTeacher.write(ListTeacher.get(i).ListClass.size() + newLine);

                for (int j = 0; j < ListTeacher.get(i).ListClass.size(); j++) {

                    FileTeacher.write(ListTeacher.get(i).ListClass.get(j).getName() + newLine);
                    FileTeacher.write(ListTeacher.get(i).ListClass.get(j).getVahed() + newLine);
                    FileTeacher.write(ListTeacher.get(i).ListClass.get(j).getDateTime() + newLine);

                }

            }
            FileTeacher.close();
            JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

        }
    }

    void AddStudent(String name, String family, String id, ArrayList<studentInfo> ListStudent) {
        studentInfo temp = new studentInfo();

        temp.setName(name);
        temp.setFamily(family);
        temp.setID(id);

        try {
            URL url = getClass().getResource("Student.txt");
            FileWriter FileStudent = new FileWriter(url.getPath());
            String newLine = System.getProperty("line.separator");
            ListStudent.add(temp);
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

    void AddClass(String name, int vahed, String DateTime, String ID, ArrayList<TeacherInfo> ListTeacher, ArrayList<ClassInfo> ListClass) {
    boolean find = false;

        for (int o = 0; o < ListTeacher.size(); o++) {
            if (ListTeacher.get(o).getID().equals(ID) == true) {
                find=true;
                ClassInfo temp = new ClassInfo();

                temp.setName(name);
                temp.setVahed(vahed);
                temp.setDateTime(DateTime);
                try {
                    URL url = getClass().getResource("Class.txt");
                    FileWriter FileClass = new FileWriter(url.getPath());
                    String newLine = System.getProperty("line.separator");
                    ListClass.add(temp);
                    for (int i = 0; i < ListClass.size(); i++) {
                        FileClass.write(ListClass.get(i).getName() + newLine);
                        FileClass.write(ListClass.get(i).getVahed() + newLine);
                        FileClass.write(ListClass.get(i).getDateTime() + newLine);

                    }
                    FileClass.close();

                    for (int i = 0; i < ListTeacher.size(); i++) {
                        if (ListTeacher.get(i).getID().equals(ID)) {
                            ListTeacher.get(i).ListClass.add(temp);

                            url = getClass().getResource("Teacher.txt");
                            FileWriter FileTeacher = new FileWriter(url.getPath());

                            for (int k = 0; k < ListTeacher.size(); k++) {
                                FileTeacher.write(ListTeacher.get(k).getName() + newLine);
                                FileTeacher.write(ListTeacher.get(k).getFamily() + newLine);
                                FileTeacher.write(ListTeacher.get(k).getID() + newLine);
                                FileTeacher.write(ListTeacher.get(k).ListClass.size() + newLine);

                                for (int j = 0; j < ListTeacher.get(k).ListClass.size(); j++) {

                                    FileTeacher.write(ListTeacher.get(k).ListClass.get(j).getName() + newLine);
                                    FileTeacher.write(ListTeacher.get(k).ListClass.get(j).getVahed() + newLine);
                                    FileTeacher.write(ListTeacher.get(k).ListClass.get(j).getDateTime() + newLine);

                                }

                            }
                            FileTeacher.close();
                        }
                    }
                    JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {

                }
            }
        }
          if(find==false)
                 JOptionPane.showMessageDialog(null, "این استاد ثبت شده نیست", "", JOptionPane.INFORMATION_MESSAGE);
 
  }

}
