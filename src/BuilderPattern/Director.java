package BuilderPattern;

public class Director {
    private StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student constructStudent() {
        if (this.studentBuilder instanceof EngineeringStudentBuilder)
            return createEngineeringStudent();
        else if (this.studentBuilder instanceof MBAStudentBuilder)
            return createMBAStudent();
        return null;
    }

    public Student createEngineeringStudent() {
        return studentBuilder.setRollNo("ENG123")
                .setName("John Doe")
                .setAddress("123 Engineering St.")
                .setFatherName("Mr. Doe")
                .setMotherName("Mrs. Doe")
                .setMobileNo("1234567890")
                .setSubjects()
                .build();
    }

    public Student createMBAStudent() {
        return studentBuilder.setRollNo("MBA123")
                .setName("Jane Smith")
                .setAddress("456 MBA Ave.")
                .setMobileNo("0987654321")
                .setSubjects()
                .build();
    }
}
