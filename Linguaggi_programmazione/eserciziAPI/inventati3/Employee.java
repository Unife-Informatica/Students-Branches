public class Employee {
  private String name;
  private String department;
  private double salary;
  private int age;

  public Employee(String name, String department, double salary, int age) {
    this.name = name;
    this.department = department;
    this.salary = salary;
    this.age = age;
  }

  public String getName() { return name; }
  public String getDepartment() { return department; }
  public double getSalary() { return salary; }
  public int getAge() { return age; }

  @Override
  public String toString() {
    return String.format("%s (%s) - €%.2f - %d anni", name, department, salary, age);
  }
}
