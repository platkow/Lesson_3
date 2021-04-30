public class EmployeeWithSalary {
    private String firstName;
    private String lastName;
    private int salary;

    public EmployeeWithSalary(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //Getters
    public int getSalary() {
        return salary;
    }

    public void getAllData(){
        System.out.println("Salary for employee " + firstName + " " + lastName + " is: " + salary);
    }
}
