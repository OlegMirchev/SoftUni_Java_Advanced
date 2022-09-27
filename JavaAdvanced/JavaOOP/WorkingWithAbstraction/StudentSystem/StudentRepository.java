package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.StudentSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentName;

    public StudentRepository() {
        this.studentName = new LinkedHashMap<>();
    }

    public void add(Student student) {
        this.studentName.put(student.getName(), student);
    }

    public Student get(String name) {
     return this.studentName.get(name);
    }
}
