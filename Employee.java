

public class Employee {
    private String employeeId;
    private String name;
    private static int idCounter = 1;

    public Employee(String name) {
    	this.employeeId = "EMP" + idCounter++;
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }
}
