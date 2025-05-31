package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsPartThree {
  // Using user defined objects
  public static void main(String[] args) {
    List<Employee> employees =
        Arrays.asList(
            new Employee("Raja", 9000, 1, "Bengaluru", "HR"),
            new Employee("Nandu", 3000, 2, "Chennai", "Testing"),
            new Employee("Helen", 18000, 3, "Bengaluru", "Accounts"),
            new Employee("Rohini", 8000, 4, "Chennai", "Accounts"),
            new Employee("Rakesh", 18000, 5, "Cochin", "HR"),
            new Employee("Harini", 12000, 6, "Cochin", "Accounts"),
            new Employee("Susheela", 22000, 7, "Bengaluru", "Testing"),
            new Employee("Nimisha", 7000, 8, "Chennai", "Accounts"));

    // FIND ALL EMPLOYEES FROM A SPECIFIC CITY and GET THE COUNT
    long totalCount = employees.stream().filter(emp -> emp.getCity().equals("Bengaluru")).count();
    System.out.println(totalCount);

    // FIND ALL THE EMPLOYEES WHERE SALARY IS GREATER THAN A PARTICULAR VALUE
    employees.stream().filter(emp -> emp.getSalary() > 10000).forEach(System.out::println);

    // PRINT ALL THE EMPLOYEE NAMES ONLY IN UPPER CASE AND ALPHABETICAL ORDER
    employees.stream().map(emp -> (emp.getEmpName().toUpperCase())).forEach(System.out::println);

    // GET THE FIRST EMPLOYEE WHERE DEPT IS "HR" AND IF NOT Available THROW EXCEPTION
    Optional<Employee> optEmp =
        employees.stream().filter(employee -> employee.getDepartment().equals("HR")).findFirst();
    optEmp.ifPresent(System.out::println);

    // GET THE TOTAL SALARY OF ALL EMPLOYEES IN A SPECIFIC DEPARTMENT
    double salarySum =
        employees.stream()
            .filter(employee -> employee.getDepartment().equals("Accounts"))
            .mapToDouble(Employee::getSalary)
            .sum();
    System.out.println(salarySum);

    // ___INTERMEDIATE___
    // CHECK  IF ALL THE EMPLOYEES HAVE A SALARY GREATER THAN A SPECIFIC VALUE
    Boolean isMatching = employees.stream().anyMatch(employee -> employee.getSalary() > 10000);
    System.out.println(isMatching);

    // GET THE SUM OF SALARIES OF ALL EMPLOYEES AND THE AVERAGE SALARY
    double sum = employees.stream().mapToDouble(Employee::getSalary).sum();
    System.out.println(sum);

    OptionalDouble avg = employees.stream().mapToDouble(Employee::getSalary).average();
    avg.ifPresent(System.out::println);

    // GET A MAP OF EMPLOYEE NAMES AND THEIR SALARIES
    Map<String, Double> mapEmp =
        employees.stream().collect(Collectors.toMap(Employee::getEmpName, Employee::getSalary));
    mapEmp.forEach((name, sal) -> System.out.println(name + " : " + sal));

    // PRINT THE EMPLOYEE DETAILS FROM HIGHEST TO LOWEST SALARY
    employees.stream()
        .sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
        .forEach(System.out::println);

    // GET THE EMPLOYEES WITH HIGHEST SALARY
    Optional<Employee> optionalEmployee =
        employees.stream().max(Comparator.comparing(Employee::getSalary));
    optionalEmployee.ifPresent(System.out::println);

    // get all the employees with the highest salary
    double maxsal = employees.stream().mapToDouble(Employee::getSalary).max().getAsDouble();

    // filter the employees with that salary
    employees.stream()
        .filter(employee -> employee.getSalary() == maxsal)
        .forEach(System.out::println);

    // GET THE EMPLOYEES WITH THE SECOND-HIGHEST SALARY
    // get the second-highest salary
    double secondHighest =
        employees.stream()
            .map(Employee::getSalary)
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .get();
    System.out.println(secondHighest);

    // filter the employees with the second-highest salary
    employees.stream()
        .filter(employee -> employee.getSalary() == secondHighest)
        .forEach(System.out::println);

    // GET THE EMPLOYEES WHO ARE EARNING ABOVE THE AVERAGE SALARY
    // get the average salary
    double avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();

    // filter the employees having salary > avg salary
    employees.stream()
        .filter(employee -> employee.getSalary() > avgSalary)
        .forEach(System.out::println);

    // GET THE EMPLOYEE WITH THE LONGEST NAME
    Employee emp = employees.stream().max(Comparator.comparing(Employee::getEmpName)).get();
    System.out.println(emp);

    // ___ADVANCED___
    // GROUP ALL THE EMPLOYEES BY DEPARTMENT
    Map<String, List<Employee>> mapEmps =
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    mapEmps.forEach((dept, listEmp) -> System.out.println(dept + ":" + listEmp));

    // GET THE COUNT OF EMPLOYEES BY DEPARTMENT
    Map<String, Long> empDept =
        employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    empDept.forEach((dept, count) -> System.out.println(dept + ":" + count));

    // GET THE SUM OF SALARIES OF ALL EMPLOYEES BY DEPARTMENT
    employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
        .forEach((dept, sumSalary) -> System.out.println(dept + ":" + sumSalary));

    // GET THE AVERAGE SALARIES OF ALL EMPLOYEES PER DEPARTMENT
    employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
        .forEach((dept, avgsalary) -> System.out.println(dept + ":" + avgsalary));

    // CHECK IF ALL EMPLOYEES BELONG TO A SPECIFIC DEPARTMENT(ACCOUNTS)
    boolean isDeptMatching =
        employees.stream().allMatch(emp1 -> emp1.getDepartment().equals("Accounts"));
    System.out.println(isDeptMatching);

    // LIST ALL EMPLOYEES GROUPING BY CITIES BUT BELONG TO THE SAME DEPARTMENT
    Map<String, List<Employee>> listOfEmployees =
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    listOfEmployees.forEach(
        (dept, listemp) -> {
          System.out.println(dept);
          listemp.stream()
              .collect(Collectors.groupingBy(Employee::getCity))
              .forEach((city, emps) -> System.out.println(city + ":" + emps));
        });

    // FIND THE DEPARTMENT WITH THE HIGHEST AVERAGE SALARY
    Map<String, Double> mapDeptAvgSalary =
        employees.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    System.out.println(mapDeptAvgSalary);

    String key = mapDeptAvgSalary.keySet().stream().max(Comparator.comparing(mapDeptAvgSalary::get)).get();
    double highest = mapDeptAvgSalary.get(key);
    System.out.println(key);
  }
}
