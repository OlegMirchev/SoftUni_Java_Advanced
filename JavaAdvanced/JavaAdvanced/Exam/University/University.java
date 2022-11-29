package JavaAdvancedExam.University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public String registerStudent(Student student) {
        if (capacity > this.students.size()) {
            if (this.students.contains(student)) {
                return "Student is already in the university";
            }else {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        }else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public int getStudentCount() {
      return this.students.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        for (Student student : students) {
            output.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject())).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
