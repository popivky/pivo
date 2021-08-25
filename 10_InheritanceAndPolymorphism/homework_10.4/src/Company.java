import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company implements Comparator<Employee> {

    public int getIncome() {

        int income = 0;
        for(Employee e : employees) {
            if (e instanceof Manager) {
                income += ((Manager) e).getSales();
            }
        }

        return income;

    }

    public List<Employee> getEmployees() {

        return new ArrayList<>(employees);

    }


    public List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {

        employees.add(employee);

    }

    public void hireAll(List<Employee> employees) {

        for (Employee e : employees) {

            hire(e);

        }

    }


    public void fire(Employee employee) {

        employees.remove(employee);

    }


    public List<Employee> getTopSalaryStaff(int count) {

        Collections.sort(employees);
        Collections.reverse(employees);
        return employees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        Collections.sort(employees);
        return employees.subList(0, count);

    }

    public int compare(Employee o1, Employee o2){
        return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
    }
}