import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimecardService {
    private List<Timecard> timecards = new ArrayList<>();

    public void recordTime(Employee employee, double hoursWorked) {
        LocalDate currentDate = SystemClock.getCurrentDate();
        Timecard timecard = new Timecard(employee.getEmployeeId(), currentDate, hoursWorked);
        timecards.add(timecard);
        System.out.println("Recorded time: " + timecard);
    }

    public List<Timecard> getTimecardsForEmployee(String employeeId) {
        List<Timecard> employeeTimecards = new ArrayList<>();
        for (Timecard timecard : timecards) {
            if (timecard.getEmployeeId().equals(employeeId)) {
                employeeTimecards.add(timecard);
            }
        }
        return employeeTimecards;
    }

    public void updateTimecard(Employee employee, LocalDate date, double newHoursWorked) {
        for (Timecard timecard : timecards) {
            if (timecard.getEmployeeId().equals(employee.getEmployeeId()) && timecard.getDate().equals(date)) {
                timecard.setHoursWorked(newHoursWorked);
                System.out.println("Updated timecard: " + timecard);
                return;
            }
        }
        System.out.println("Timecard not found for employee ID " + employee.getEmployeeId() + " on date " + date);
    }
}
