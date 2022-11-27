package JavaAdvancedExam.Bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
      return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder(String.format("Employees working at Bakery %s:%n", this.name));

        for (Employee employee : employees) {
            output.append(employee).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
