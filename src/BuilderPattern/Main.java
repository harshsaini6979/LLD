package BuilderPattern;

public class Main {
    public static void main(String[] args) {
        Director engineerStudent = new Director(new EngineeringStudentBuilder());
        Director mbaStudent = new Director(new MBAStudentBuilder());

        Student engineeringStudent = engineerStudent.constructStudent();
        Student mbaStudentObj = mbaStudent.constructStudent();

        engineeringStudent.display();
        System.out.println();
        mbaStudentObj.display();
    }
}
