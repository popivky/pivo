public class Manager implements Employee {

    int salary = 40000;
    int sales;

    public Manager (){

        sales =(int) ( Math.random() * (140000 - 115000) + 115000);

        salary += sales * 0.05;
    }

    public int getMonthSalary(){

        return salary;
    }

    public int getSales(){

        return sales;

    }




}