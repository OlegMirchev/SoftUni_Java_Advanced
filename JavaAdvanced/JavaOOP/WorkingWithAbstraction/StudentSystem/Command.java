package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.StudentSystem;

public class Command {
    private StudentRepository repository;

    public Command() {
        this.repository = new StudentRepository();
    }

    public String handle(String[] args) {
        if (args[0].equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            Student student = new Student(name, age, grade);
            this.repository.add(student);
            return null;
        } else if (args[0].equals("Show")) {
            String name = args[1];
            return this.repository.get(name).intern();
        }
        return args[0];
    }
}
