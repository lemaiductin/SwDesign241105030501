import java.time.LocalDate;

public class Timecard {
    private String employeeId;
    private LocalDate date;
    private double hoursWorked;

    public Timecard(String employeeId, LocalDate date, double hoursWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Timecard [Employee ID: " + employeeId + ", Date: " + date + ", Hours Worked: " + hoursWorked + "]";
    }
}
