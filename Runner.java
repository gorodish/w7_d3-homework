/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){
        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");
        Department department3 = new Department("Sales");
        Department department4 = new Department("Finance");
        Department department5 = new Department("Admin");


        department1.save();
        department2.save();
        department3.save();
        department4.save();
        department5.save();


        Employee employee1 = new Employee("Suzie Smith", department1, 45000);
        Employee employee2 = new Employee("Jamie Jones", department2, 25000);
        Employee employee3 = new Employee("Donald Trump", department3, 25000);
        Employee employee4 = new Employee("Ivanka Trump", department3, 25000);
        Employee employee5 = new Employee("Melania Trump", department4, 25000);
        Employee employee6 = new Employee("Ivana Trump", department4, 25000);
        Employee employee7 = new Employee("Tiffany Trump", department5, 25000);
        Employee employee8 = new Employee("Eric Trump", department5, 25000);


        employee1.save();
        employee2.save();
        employee3.save();
        employee4.save();
        employee5.save();
        employee6.save();
        employee7.save();
        employee8.save();


    }
}
