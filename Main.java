import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo dịch vụ TimecardService
        TimecardService timecardService = new TimecardService();

        // Tạo một nhân viên
        Employee employee = new Employee("John Doe");

        // Ghi nhận giờ làm việc cho nhân viên
        timecardService.recordTime(employee, 8.0);
        timecardService.recordTime(employee, 7.5);

        // Lấy và hiển thị tất cả Timecard của nhân viên
        System.out.println("Timecards for " + employee.getName() + ":");
        for (Timecard timecard : timecardService.getTimecardsForEmployee(employee.getEmployeeId())) {
            System.out.println(timecard);
        }

        // Cập nhật giờ làm việc cho một ngày cụ thể
        LocalDate dateToUpdate = SystemClock.getCurrentDate();
        timecardService.updateTimecard(employee, dateToUpdate, 8.5);

        // Hiển thị lại tất cả Timecard của nhân viên sau khi cập nhật
        System.out.println("Updated Timecards for " + employee.getName() + ":");
        for (Timecard timecard : timecardService.getTimecardsForEmployee(employee.getEmployeeId())) {
            System.out.println(timecard);
        }
    }
}
