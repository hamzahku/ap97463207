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
import java.sql.Struct;
import java.util.ArrayList;
import static javaproject.StudentFrame.ListStudent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class studentInfo {

    void setClass(String valuename, String valuevahed, String valueِDate, ArrayList<studentInfo> ListStudent,String ID) {
        ClassInfo temp = new ClassInfo(valuename, Integer.parseInt(valuevahed), valueِDate);
        studentInfo.Scores temp2 = new studentInfo.Scores();
        temp2.name = valuename;
        temp2.score = 0;
        for (int i = 0; i < ListStudent.size(); i++) {
            if (ListStudent.get(i).getID().equals(ID) == true) {
                ListStudent.get(i).ListClass.add(temp);
                ListStudent.get(i).ListStudentScores.add(temp2);

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

    void showClass(String[] header, DefaultTableModel dtm, JTable jTable1, ArrayList<studentInfo> ListStudent, String ID) {
        header = new String[]{"نمره", "تاریخ تشکیل", ",واحد", "نام"};
        dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(header);
        jTable1.setModel(dtm);

        for (int i = 0; i < ListStudent.size(); i++) {
            if (ListStudent.get(i).getID().equals(ID)) {
                for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {
                    for (int k = 0; k < ListStudent.get(i).ListStudentScores.size(); k++) {
                        if (ListStudent.get(i).ListClass.get(j).getName().equals(ListStudent.get(i).ListStudentScores.get(k).name) == true) {
                            dtm.addRow(new Object[]{ListStudent.get(i).ListStudentScores.get(k).score, ListStudent.get(i).ListClass.get(j).getDateTime(), ListStudent.get(i).ListClass.get(j).getVahed(), ListStudent.get(i).ListClass.get(j).getName()});
                        }
                    }
                }
            }
        }
    }

    void showJozve(String[] header, DefaultTableModel dtm, JTable jTable2) {
        header = new String[]{"جزوه", "نام درس"};
        dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(header);
        jTable2.setModel(dtm);

        URL url1 = getClass().getResource("Jozveh.txt");
        File JozveFile = new File(url1.getPath());
        ArrayList<String> stlst;
        try {

            stlst = (ArrayList<String>) Files.readAllLines(Paths.get(JozveFile.getPath()));
            dtm.addRow(new Object[]{stlst.get(1).substring(stlst.get(1).lastIndexOf("\\") + 1, stlst.get(1).length()), stlst.get(0)});

        } catch (Exception e) {

        }
    }

    void DeleteClass(String valueName, ArrayList<studentInfo> ListStudent) {
        for (int i = 0; i < ListStudent.size(); i++) {
            for (int j = 0; j < ListStudent.get(i).ListClass.size(); j++) {
                if (ListStudent.get(i).ListClass.size() > 0 && ListStudent.get(i).ListClass.get(j).getName().equals(valueName) == true) {
                    ListStudent.get(i).ListClass.remove(j);
                    ListStudent.get(i).ListStudentScores.remove(j);

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

    void Protest(ArrayList<studentInfo> ListStudent, String valueName) {
    for (int i = 0; i < ListStudent.size(); i++) {
            if (ListStudent.get(i).getID().equals(ID)) {
                try {
                    URL url = getClass().getResource("Protest.txt");
                    FileWriter FileProtest = new FileWriter(url.getPath());
                    String newLine = System.getProperty("line.separator");

                    FileProtest.write(ListStudent.get(i).getName() + newLine); 
                    FileProtest.write(ListStudent.get(i).getFamily() + newLine);
                    FileProtest.write(valueName + newLine);
                    FileProtest.close();
                } catch (Exception e) {

                }

            }

        }
        JOptionPane.showMessageDialog(null, "ثبت شد", "", JOptionPane.INFORMATION_MESSAGE);
}

    public static class Scores {

        public Scores(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public Scores() {
            this.name = "";
            this.score = 0;
        }
        public String name;
        public int score;
    }

    private String name;
    private String family;
    private String ID;
    public ArrayList<ClassInfo> ListClass = new ArrayList<>();
    public ArrayList<Scores> ListStudentScores = new ArrayList<>();

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

    public void AddScore(String name, int s) {
        Scores temp = new Scores(name, s);
        ListStudentScores.add(temp);

    }

    public void AddClass(String name, int v, String dt) {
        ClassInfo temp = new ClassInfo(name, v, dt);

        ListClass.add(temp);

    }

}
