public class TopManager implements Employee {

    public Company company;
    int salary = 45000;
    int bonus;

    public TopManager(Company company) {

        this.company = company;

    }

    public int getMonthSalary() {


        if (company.getIncome() > 10000000)
            return (int) (salary * 1.5);
        return salary;


    }
}