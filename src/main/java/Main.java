import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String firstNameUser = "";
        String lastNameUser = "";
        int salaryUser = 0;
        int userOption;
        int employeeCounter = 1;

        //Get employees data from user
        System.out.println("You're going to be asked about: first name, last name and salary for five employees.");

        List<EmployeeWithSalary> listOfEmployees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        do {
            EmployeeWithSalary employee = new EmployeeWithSalary(firstNameUser, lastNameUser, salaryUser);

            //firstname
            System.out.println("Please enter first name of employee " + employeeCounter);
            firstNameUser = scanner.next();
            employee.setFirstName(firstNameUser);

            //lastname
            System.out.println("Please enter last name of employee " + employeeCounter);
            lastNameUser = scanner.next();
            employee.setLastName(lastNameUser);

            //salary
            System.out.println("Please enter salary of employee " + employeeCounter);

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("You entered string, please enter integer value grater than 0.");
            }

            salaryUser = scanner.nextInt();
            employee.setSalary(salaryUser);

            //Add employee with provided data to the List
            listOfEmployees.add(employee);
            employeeCounter++;

        } while (employeeCounter < 6);

        do {
            //Display menu
            displayMenu();

            //Get option value
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("You entered string, please enter integer between 1 and 4.");
                displayMenu();
            }

            userOption = scanner.nextInt();

            while(userOption < 0 || userOption > 5){
                System.out.println("You entered value out of range, please enter integer between 1 and 4.");
                displayMenu();
               userOption = scanner.nextInt();
            }

            //Action depending on chosen option
            switch (userOption) {
                case 1:
                    // Display sum of all salaries
                    int salary;
                    int salarySum = 0;

                    for (EmployeeWithSalary emp : listOfEmployees) {
                        salary = emp.getSalary();
                        salarySum += salary;
                    }
                    System.out.println("Sum of all employees salaries is " + salarySum);
                    break;
                case 2:
                    //Display data of all employees
                    for (EmployeeWithSalary emp : listOfEmployees) {
                        emp.getAllData();
                    }
                    break;
                case 3:
                    //Add new employee
                    System.out.println("To add new employee please provide following data: ");
                    EmployeeWithSalary employee = new EmployeeWithSalary(firstNameUser, lastNameUser, salaryUser);

                    //firstname
                    System.out.println("First name");
                    firstNameUser = scanner.next();
                    employee.setFirstName(firstNameUser);

                    //lastname
                    System.out.println("Last name");
                    lastNameUser = scanner.next();
                    employee.setLastName(lastNameUser);

                    //salary
                    System.out.println("Salary");

                    while (!scanner.hasNextInt()) {
                        scanner.next();
                        System.out.println("You entered string, please enter integer value > 0.");
                    }
                    salaryUser = scanner.nextInt();
                    employee.setSalary(salaryUser);

                    //Add new employee to the List
                    listOfEmployees.add(employee);
                    employeeCounter++;
                    System.out.println("Last added employee has index: " + listOfEmployees.lastIndexOf(employee));
                    break;
                case 4:
                    //End program
                    System.out.println("You chose to end program. Bye bye!");
                    break;
                default:
                    System.out.println("Somehow you chose different value than available.");
            }
        } while (userOption != 4);
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println(" Menu \n 1 – Print sum of all employees salary \n 2 – Display all employees data \n 3 – Add new employee \n 4 – End program \n");
        System.out.println("Which option do you choose?");
    }
}
