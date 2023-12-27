import java.util.ArrayList;
abstract  class  Employee{
    private String name;

    private  int id ;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public  int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return  "Employee[name =" +name +", id =" + id + ", salary ="+ calculateSalary() +"]";
    }
}
class  FullTimeEmployee extends Employee{

    public double monthlySalary;

    public FullTimeEmployee(String name, int id , double monthlySalary){
        super(name, id);
        this.monthlySalary =monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private  int hoursWorked;

    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayRollSystem{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeetoRemove = null;

        for(Employee employee : employeeList){
            if (employee.getId()==id){
                employeetoRemove =employee;
                break;
            }
        }

        if(employeetoRemove != null){
            employeeList.remove(employeetoRemove);
        }
    }

    public void  displayEmployee(){
        for(Employee employee :employeeList){
            System.out.println(employee);
        }
    }


}
public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("ankit",1,50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("anuj",2,40,100);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Intial Employee");
        payRollSystem.displayEmployee();
        System.out.println("Removed employee");
        payRollSystem.removeEmployee(2);
        System.out.println("Remianing employee");
        payRollSystem.displayEmployee();
    }
}
