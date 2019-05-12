package assignment8;

public abstract class student implements Comparable<student> {
    private int studentNumber;
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public int compareTo(student o) {
        if(this.getStudentNumber()>o.getStudentNumber())
            return 1;
        else if(this.getStudentNumber()<o.getStudentNumber())
            return -1;
        else
            return 0;
    }
}