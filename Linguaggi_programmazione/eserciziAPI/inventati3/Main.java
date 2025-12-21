import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
          new Employee("Alice", "IT", 3200, 28),
          new Employee("Bob", "HR", 2800, 35),
          new Employee("Charlie", "IT", 4000, 42),
          new Employee("Diana", "Finance", 3600, 30),
          new Employee("Eve", "HR", 3000, 25),
          new Employee("Frank", "Finance", 4200, 45),
          new Employee("Grace", "IT", 3100, 27)
        );

        // 1 - Filtra tutti i dipendenti con salario >= 3500 e stampa il loro nome e salario
        employees.stream().filter(e -> e.getSalary() >= 3500).forEach(e -> System.out.println(e.getName() + " -> €" + e.getSalary()));

        // 2 - Raggruppa i dipendenti per dipartimento e conta quanti ce ne sono per ciascun dipartimento
        Map<String, Long> totDip = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("\nNumero di dipendenti per dipartimento:");
        totDip.forEach((dept, count) -> System.out.println(dept + " -> " + count));

        // 3 - Trova il dipendente più anziano e stampalo
        employees.stream().max(Comparator.comparingInt(Employee::getAge)).ifPresent(e -> System.out.println(e));
    }
}
