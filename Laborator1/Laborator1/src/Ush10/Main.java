package Ush10;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("fn1", "ln1", 1);
        Employee employee2 = new Employee("fn2", "ln2", 1);
        Employee employee3 = new Employee("fn3", "ln3", 1);
        Employee employee4 = new Employee("fn4", "ln4", 1);
        Employee employee5 = new Employee("fn5", "ln5", 1);
        Employee employee6 = new Employee("fn6", "ln6", 1);
        Employee employee7 = new Employee("fn7", "ln7", 1);

        Employee[] employees = new Employee[10];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;
        employees[4] = employee5;
        employees[5] = employee6;

        Company company = new Company("Kompani");
        company.setEmployees(employees);

        company.printEmployesAge();

        System.out.println(company.toString());


    }
}
