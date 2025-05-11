package BuilderPattern;

import java.util.List;

public class Student {
    String rollNo;
    String name;
    String address;
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNo;

    public Student(StudentBuilder studentBuilder) {
        this.rollNo = studentBuilder.rollNo;
        this.name = studentBuilder.name;
        this.address = studentBuilder.address;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.subjects = studentBuilder.subjects;
        this.mobileNo = studentBuilder.mobileNo;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Father's Name: " + fatherName);
        System.out.println("Mother's Name: " + motherName);
        System.out.println("Subjects: " + subjects);
        System.out.println("Mobile No: " + mobileNo);
    }
}
