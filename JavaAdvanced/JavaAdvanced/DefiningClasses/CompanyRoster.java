package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.*;

public class CompanyRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> mapDepartment = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee = null;

            if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (input.length == 5) {
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            mapDepartment.putIfAbsent(department, new Department(department));
            mapDepartment.get(department).getListEmployee().add(employee);
        }
        Department highPaidDep = mapDepartment.entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().calculateAverageSalary()))
                .get().getValue();

        System.out.println("Highest Average Salary: " + highPaidDep.getName());
        highPaidDep.getListEmployee().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }

    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this(name, salary, position, department);
            this.email = email;
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email) {
            this(name, salary, position, department);
            this.email = email;
        }

        public Employee(String name, double salary, String position, String department, int age) {
            this(name, salary, position, department);
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }
    }

    public static class Department {
        List<Employee> listEmployee;
        private String name;

        public Department(String name) {
            this.name = name;
            listEmployee = new ArrayList<>();
        }

        public List<Employee> getListEmployee() {
            return listEmployee;
        }

        public double calculateAverageSalary() {
            return this.listEmployee.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        }

        public String getName() {
            return name;
        }
    }
}
