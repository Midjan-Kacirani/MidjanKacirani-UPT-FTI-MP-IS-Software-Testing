package Ush10;

import java.util.Arrays;

public class Company {

    private String name;
    private Employee[] employees = new Employee[5];


    public Company(String name) {
        this.name = name;
    }

    public void setEmployees(Employee[] employees) {

        //Simple check added to enforce the fact that a company should have only 5 members (or less)
        int noEmployeesInputted = Math.min(employees.length, 5);

        for (int i = 0; i < noEmployeesInputted; i++) {
            this.employees[i] = employees[i];
        }

    }

    public void printEmployesAge() {
        for (int i = 0; i < this.employees.length; i++) System.out.println(this.employees[i].getAge());
    }

    public float getAvgAge() {
        int mosha = 0;
        for (Employee employee : this.employees) mosha += employee.getAge();
        return (float) mosha / this.employees.length;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + Arrays.toString(employees) +
                '}';
    }
}
