package BuilderPattern;

import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = List.of("Engineering Mathematics", "Data Structures", "Algorithms", "Computer Networks");
        return this;
    }
}
