import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 180; i++) {

            company.hire(new Operator());

        }

        List<Employee> staff = new ArrayList<>();

        for (int i = 0; i < 80; i++) {

            staff.add(new Manager());
        }

        for (int i = 0; i < 10; i++) {

            staff.add(new TopManager(company));
        }

        company.hireAll(staff);

        System.out.println("Топ 10 самых высоких зарплат в компании");


        List<Employee> topSalary = company.getTopSalaryStaff(10);

        for (Employee man : topSalary) {

            System.out.println(man.getMonthSalary());
        }


        System.out.println("Топ 30 низких зарплат в компании");


        List<Employee> lowSalary = company.getLowestSalaryStaff(30);

        for (Employee man : lowSalary) {

            System.out.println(man.getMonthSalary());
        }


        List<Employee> employees = company.getEmployees();

        System.out.println("Колличество сотрудников до увольнения: " + employees.size());

        for (int i = 0; i < 135; i++) {
            company.fire(employees.get(i));
        }

        System.out.println("Колличество сотрудников после увольнения: " + company.getEmployees().size());

        System.out.println("Топ 10 самых высоких зарплат в компании после увольнения");


        List<Employee> topSalaryTwo = company.getTopSalaryStaff(10);

        for (Employee man : topSalaryTwo) {

            System.out.println(man.getMonthSalary());
        }


        System.out.println("Топ 30 низких зарплат в компании после увольнения");


        List<Employee> lowSalaryTwo = company.getLowestSalaryStaff(30);

        for (Employee man : lowSalaryTwo) {

            System.out.println(man.getMonthSalary());
        }


    }
}