package BuilderPattern;

import java.util.List;

public class MBAStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = List.of("Marketing", "Finance", "Operations", "Human Resources");
        return this;
    }
}
