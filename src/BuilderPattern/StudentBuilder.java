package BuilderPattern;

import java.util.List;

public abstract class StudentBuilder {
    String rollNo;
    String name;
    String address;
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNo;

    public StudentBuilder setRollNo(String rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public StudentBuilder setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public abstract StudentBuilder setSubjects();

    public Student build() {
        return new Student(this);
    }

}
