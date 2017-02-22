import java.sql.ResultSet;
import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;


    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return this.salary;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void save() {
        int department_id = this.department.getId();
        String sql = String.format("INSERT INTO employees (name, department_id, salary) VALUES ('%s', %d, %7.2f);", this.name, department_id, this.salary);
        this.id = SqlRunner.executeUpdate(sql);
        System.out.println("Employee save query run");
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble("salary");
                String department = rs.getString("department");
                System.out.println(name);
                System.out.println("Employee All query completed");
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public void getEmployeeDetails() {
        String sql = String.format("SELECT employees.name, employees.salary, departments.title  FROM employees WHERE department_id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble("salary");
                String title = rs.getString("title");

                System.out.println("Employee: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("Department: " + title);
                System.out.println("get employee Query completed");
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM employees;";
        System.out.println("Employee Delete query completed");

        SqlRunner.executeUpdate(sql);
    }

    public void deleteOne() {
        String sql = String.format("DELETE * FROM employees WHERE department_id = %d;", this.id);
        System.out.println("Employee Delete one query completed");

        SqlRunner.executeUpdate(sql);
    }

    public void update() {
        String sql = String.format("UPDATE employees SET name = '%s', salary = %7.2f WHERE id = %d;", this.name, this.salary, this.id);
        System.out.println("Employee Update query completed");

        SqlRunner.executeUpdate(sql);
    }
}