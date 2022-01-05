package DOANCUOIKI;

public class Staff extends Person {

    protected double salary;

    @Override
    public double SumSalary() {
        return salary;
    }

    public Staff(String username, String password, String fullName, int age, String gender, String phone, double salary) {
        super(username, password, fullName, age, gender, phone);
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    

    @Override
    public String Info() {
        return  
        username + "\t" + fullName + "\t   " + age + " \t   " + gender + "\t  " + phone + "\t  " + salary + "\t" + "0.0   \t   " + "Nhan Vien" ;
    }
}
