### 6.CA SỬ DỤNG CREATE EMPLOYEE REPORT
**ReportService**: Chịu trách nhiệm xử lý các yêu cầu liên quan đến việc tạo mới nhân viên và lưu trữ thông tin nhân viên.

**Report**: báo cáo về giờ làm việc, ngày nghỉ phép, tổng lương.

**Employee**: Lớp đại diện cho nhân viên trong hệ thống.

**ProjectManagementDatabase**: chứa thông tin về các mã số công việc và dự án, chỉ dùng để truy xuất thông tin mà không cập nhật.

**SystemClock**: Cung cấp thời gian hiện tại cho hệ thống, phục vụ cho việc ghi lại các mốc thời gian khi tạo báo cáo.

### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP
**Employee**: có các thuộc tính như idEmployee, name, reportPreferences.

**ReportService**: có các thuộc tính như availableReportTypes, availableChargeNumbers

**Report**:  có các thuộc tính như reportType. startDate, endDate, content

**ProjectManagementDatabase**:  có các thuộc tính như chargeNumbers, projectDetails

**SystemClock**: có thuộc tính như currentDateTime
### MỐI QUAN HỆ GIỮA CÁC LỚP
**ReportService - Employee(Dependency)**:ReportService phụ thuộc vào Employee để xác thực và lấy thông tin cần thiết khi tạo báo cáo.

**ReportService - Report(Association)**:ReportService tạo và quản lý các Report cho nhân viên.

**ReportService - ProjectManagementDatabase(Dependency)**:ReportService truy xuất dữ liệu từ ProjectManagementDatabase để lấy thông tin về mã số công việc khi cần.

**ReportService - SystemClock(Dependency)**:ReportService sử dụng SystemClock để lấy thời gian hiện tại khi tạo báo cáo.

Biểu đồ lớp : 
![Diagram](https://www.planttext.com/api/plantuml/png/V5CxRjj04Ett5DE5B7G15O43EQK38N9df1YjHkGct2KpknGW6AvTk77A84rIfWXo01Ofv8lm1Bc2br-JD6qM137pvirxCyF_nRypwv1ThXCXti33VLdScHXC53_yHf2dNnAIilYHmU7q4roSbyLt2UxqnyH2o0IjXVSwIz8Z4LmByCz2xRh84ZQEbOcQk44zYJ1bARirqvwOZ2JRfsywyeyrP4DyKBBlW0TK2MuJQhANn-ofzEhJ1BEAaIFwaEijyHG54HbYT2rHGBtmpaAuR2LC9NLQk9SmzbOFzTnJBw5wDq4oksb8fiQHSS-ThpdzJD9TeC68j8Vu6joYxQSWNp6so9hgSt9-33EstNe428Pa7JfyBcfpj8xqAadbbrv6pjoeeqkbXzwgDgjnDWZR_4rrR1TbyKt1rnmDn6Ln2v4gYx_3enDYlF_5uktJkNacoln4_UKS8SWj3Kvndp8SC54xT2erW6O7_XE1oHiYdmbdcDl5Bk6TjQbKJMaWcRnWMtFeUXdT2SnnlBoriTnMYEUgTUqvrI_NpZKQRc9c4iDqDGpdX-zFKcUX46SUMltkZm000F__0m00)


### 7.CA SỬ DỤNG LOGIN
**LoginService**: Quản lý và xử lý thông tin đăng nhập của người dùng. Xác thực tên đăng nhập và mật khẩu.

**Employee**: Lớp đại diện cho nhân viên trong hệ thống, lưu trữ các thông tin như tên đăng nhập, mật khẩu và quyền truy cập của người dùng.

**System**: Hệ thống thực hiện việc kiểm tra và xác thực tên đăng nhập và mật khẩu để quyết định quyền truy cập vào hệ thống.

### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP
**Employee**: có các thuộc tính như  username, password, role, idEmpoyee.

**LoginService**: có các thuộc tính như username, password.

**System**: Phụ thuộc vào loginService để thực hiện đăng nhập và cấp quyền truy cập vào các chức năng của hệ thống

### MỐI QUAN HỆ GIỮA CÁC LỚP
**LoginService - Employee(Dependency)**: LoginService phụ thuộc vào Employee để xác thực tên đăng nhập và mật khẩu. LoginService truy vấn thông tin từ Employee để kiểm tra tính hợp lệ của thông tin đăng nhập.

**LoginService - System(Association)**: LoginService tương tác với System để cấp quyền truy cập cho người dùng nếu tên đăng nhập và mật khẩu hợp lệ.
Biểu đồ lớp : ![Diagram](https://www.planttext.com/api/plantuml/png/b95D2i8m48NtESKi5Sm5WaWLtRdh2K8wr40oASbKAUB9N7Wahs1Rh1BTwFRDlFVDp_rwAnBhoArtmZYT4knyuqA726S18C5Maw2Wv6Yf7kKsOIJjSx7f_QSGgqoCmRsxBk99sOVQKednQCr4-ZKIGBTyG69hDEFiqxRuyimLR48_XQOtl-mIen_906uOvk-Wrw6MKkRxADXYWrGXcKva5IbN4rh1EgLWh6ORI1Hz-_231m000F__0m00)

### 8.CA SỬ DỤNG Maintain Purchase Order
**PurchaseOrder**: Lớp đại diện cho đơn đặt hàng, bao gồm thông tin về khách hàng, sản phẩm, ngày tháng

**PurchaseOrderService**: Dịch vụ quản lý các đơn đặt hàng trong hệ thống, hỗ trợ các hành động tạo mới, cập nhật và xóa đơn đặt hàng.

**System**: Hệ thống sẽ giúp giao diện người dùng cho nhân viên và kiểm tra quyền truy cập và tính hợp lệ của đơn đặt hàng.
### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP

**PurchaseOrder**: Có các thuộc tính như idOrder, customer, products, date, totalAmount.

**PurchaseOrderService**: Chịu trách nhiệm quản lý các đơn đặt hàng và thực hiện các thao tác với chúng.

**System**: Xử lý xác thực quyền truy cập và lưu trữ thông tin liên quan đến đơn đặt hàng.
### MỐI QUAN HỆ GIỮA CÁC LỚP

System tương tác với PurchaseOrder để kiểm tra quyền truy cập và tính hợp lệ của đơn đặt hàng.

PurchaseOrderService sử dụng PurchaseOrder để thực hiện các thao tác như tạo mới, cập nhật và xóa đơn đặt hàng.

System tương tác với PurchaseOrderService để quản lý và thực hiện các thao tác trên đơn hàng.

Biểu đồ lớp : ![Diagram](https://www.planttext.com/api/plantuml/png/b55DIaCn4Dxd5BFKnRj0aD9ADu9WuPrWJ8OQI3AFp4GeuibSU2IlO4nRyPKdw2Omty_CDvEFj_UrA1QjAHeNKGHsjRWd57eedWgy6801Wk-LXL5BoFkEkIhAwGAS2llgL2pS1z6R8xFgb4Sb2zlszb9PCMuIrwmDvVeOoRoQfGmZbUVWg4S1S8LQYqvSyJ7KJ7rjuPOv4kOkhvF_ZznJf9dypf_t-w7ypZaUH2cTaYNCkF_RgDRWP1s6rSN5BMn4s0NKmDaiNcB9jAM9igVi3h-sFjld4zRDzlNxdm000F__0m00)

#### 9.CA SỬ DỤNG Create Administrative Report
**ReportService**: Chịu trách nhiệm xử lý các yêu cầu tạo báo cáo hành chính (Administrative Report). Nó nhận các tiêu chí từ Payroll Administrator, truy xuất thông tin cần thiết và tạo báo cáo dựa trên các tiêu chí đó.

**Report**: Đại diện cho báo cáo hành chính trong hệ thống, bao gồm các thông tin như loại báo cáo, ngày bắt đầu và kết thúc, và nội dung báo cáo.

**PayrollAdministrator**: Người yêu cầu tạo báo cáo hành chính, cung cấp các tiêu chí và quyết định lưu hoặc hủy báo cáo sau khi đã tạo.

**ProjectManagementDatabase**: Chứa thông tin cần thiết để tạo báo cáo, như tổng giờ làm việc và lương theo năm.

**SystemClock**: Cung cấp thời gian hiện tại khi tạo báo cáo, giúp đảm bảo thông tin thời gian chính xác trong báo cáo.
### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP

**PayrollAdministrator**: có thuộc tính requestedReport

**ReportService**: có các thuộc tính như reportCriteria, availableReports	

**Report**: có các thuộc tính như 	reportType, startDate, endDate, content

**ProjectManagementDatabase**: 	chargeNumbers, projectDetails

**SystemClock**: currentDateTime
## MỐI QUAN HỆ GIỮA CÁC LỚP

**ReportService - Report (Association)**	ReportService tạo và quản lý các Report cho Payroll Administrator dựa trên tiêu chí yêu cầu.

**ReportService - PayrollAdministrator(Dependency)**	ReportService nhận yêu cầu từ Payroll Administrator và cung cấp báo cáo dựa trên tiêu chí được chỉ định.

**ReportService - ProjectManagementDatabase(Dependency)**	ReportService truy xuất dữ liệu từ ProjectManagementDatabase để lấy thông tin cho báo cáo.

**ReportService - SystemClock(Dependency)**	ReportService sử dụng SystemClock để lấy thời gian hiện tại khi tạo báo cáo.
Biểu đồ lớp : ![Diagram](https://www.planttext.com/api/plantuml/png/X99DJiCm48NtEOKla0j4g6hLBW5Lf1UOEACmu9zqFAaK8Kx6WYFr2hMRfY8XY8rbFS_tF6_iyzVtEWYmTDPasa08QWyzUsCsjIL7GHZ4i_h8bCeLux7385Y_OEjP2bKAaskop-p63dg9V2ADToXfMoP19hWpwGXEG0OgWmCN2lKORtmOAbPpsudVeMznudLDiGE9Qbgl6hfwfcZl1Dr2vtlsRwZb2HmqQ6D9HA22CARGhy0DFdUsGfxtcSxRWT-Xn4ZXjt_PnxdPhV7wVNJic8Txy43srcJQ9MWwo3nVZJCer2O4hmc4l5ieMtozw8rj70OwtIynVsR_1_mPQbAwZflqeou0003__mC0)

### 10.CA SỬ DỤNG Maintain Employee Information
**EmployeeService**: Chịu trách nhiệm xử lý các yêu cầu liên quan đến việc thêm mới, cập nhật và xóa thông tin nhân viên, lưu trữ thông tin chi tiết của nhân viên trong hệ thống.

**PayrollSystem**: Hệ thống quản lý thông tin và trả lương nhân viên, đảm bảo việc thanh toán đúng hạn dựa trên thông tin thời gian làm việc, lương cơ bản và hoa hồng bán hàng (nếu có).

**Employee**: Lớp đại diện cho nhân viên trong hệ thống, bao gồm các thông tin cơ bản như tên, địa chỉ, loại nhân viên và phương thức thanh toán.

**ProjectManagementDatabase**: Chứa thông tin về mã số công việc và dự án, chỉ sử dụng để truy xuất thông tin phục vụ việc thanh toán và báo cáo nhưng không cập nhật dữ liệu.

**SystemClock**: Cung cấp thời gian hiện tại để ghi nhận các thời điểm thêm mới, cập nhật hoặc xóa nhân viên trong hệ thống.
### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP

**Employee**: Có các thuộc tính như idEmployee, name, employeeType (hourly, salaried, commissioned), address, socialSecurityNumber, paymentMethod, commissionRate, và hourlyRate.

**EmployeeService**: Quản lý danh sách nhân viên, bao gồm các thuộc tính như employeesList, defaultPaymentMethod.

**PayrollSystem**: Có các thuộc tính như paySchedule và paymentRecords, phục vụ việc tự động tạo và quản lý thanh toán.

**ProjectManagementDatabase**: Chứa các thuộc tính chargeNumbers và projectDetails, giúp hệ thống xác minh thông tin mã công việc mà nhân viên ghi nhận.

**SystemClock**: Có thuộc tính currentDateTime để ghi nhận thời điểm cho các hoạt động thêm, sửa, và xóa nhân viên.
### MỐI QUAN HỆ GIỮA CÁC LỚP
**EmployeeService - Employee(Association)**: EmployeeService quản lý các đối tượng Employee, thực hiện thêm, cập nhật, và xóa thông tin nhân viên trong hệ thống.

**EmployeeService - PayrollSystem(Dependency)**: EmployeeService phụ thuộc vào PayrollSystem để đảm bảo các thông tin thanh toán của nhân viên được cập nhật và kiểm soát theo đúng lịch trình.

**PayrollSystem - ProjectManagementDatabase(Dependency)**: PayrollSystem truy xuất dữ liệu từ ProjectManagementDatabase để xác nhận mã số công việc khi thanh toán, nhưng không thực hiện thay đổi trong cơ sở dữ liệu này.

**EmployeeService - SystemClock(Dependency)**: EmployeeService sử dụng SystemClock để ghi nhận thời gian hiện tại khi thực hiện các thao tác thêm mới, cập nhật hoặc xóa nhân viên, giúp hệ thống lưu lại lịch sử các thay đổi.
Biểu đồ lớp : ![Diagram](https://www.planttext.com/api/plantuml/png/Z5DBJiCm4Dtd55x2eXU8K5IWB90eGaqlCBM7nk1Fv0-IXJWP2ux45N2SEgshL69ZMJDlPjvx7lz-_ooj0-Ey51KLO2rvaBtG0P5yLeGi26SvK9FM6QxsAQn0bW4yeBQXBnF0c45hYvZLb8DeaNh3NNZsSeUc0FGG92gtHjTfLcIebf9RoxNQW8kJLjhl1APKfxqHeGX_LMUgMZGVd6PncRHzujRLP3XlCh9928Qlu8LxkS273F9onHLEJkNGTKtkj1O8Ae5zpoAx_-CP2fp1FquKJl2JrCZLQ27QO1tAWz3ePqixP5xWdCyRfDemUt1Wp3Sd7Or-G-hMe62F0tu53dPWiusq0xF7yHdFcwGfO_qA7N1nt8If_qZrNcZwdZjwOyOvkEN3fkNRK7J-bej5SzpQcjpQj5ukhiWijFGdjiOU5KD5GrMc4lYYzA9mRiwfgWAyZ9VXl_q1003__mC0)


### 11. CA SỬ DỤNG RUN PAYROLL
  **PayrollService**: Chịu trách nhiệm tính toán và xử lý việc trả lương cho nhân viên dựa trên dữ liệu thời gian làm việc, đơn hàng bán hàng và các thông tin liên quan.
  
  **Employee**: Đại diện cho nhân viên trong hệ thống, bao gồm thông tin về lương, giờ làm việc, phương thức thanh toán và các dữ liệu cá nhân khác. 
  
  **Timecard**: Ghi lại số giờ làm việc của nhân viên trong một kỳ lương. 
  
  **BankSystem**: xử lý thanh toán qua chuyển khoản ngân hàng.
  
  **PurchaseOrder**: Đại diện cho các đơn hàng bán hàng của nhân viên nhận lương hoa hồng. BankSystem: Hệ thống thanh toán được dùng để xử lý các giao dịch chuyển tiền trực tiếp vào tài khoản ngân hàng của nhân viên. 
  **SystemClock**: Cung cấp thời gian hiện tại để xác định các mốc thời gian khi chạy bảng lương.
### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP
 **Employee**: Có các thuộc tính như idEmployee, name, paymentMethod, salary, commissionRate,hoursWorked

 **PayrollService**: Có các thuộc tính như currentDate, payrollCycle.
 
 **Timecard**: Có các thuộc tính như employeeId, date, hoursWorked.
 
 **PurchaseOrder**: Có các thuộc tính như employeeId, saleDate, saleAmount.
 
 **BankSystem**: Có các thuộc tính như bankTransactionId, amount, status.
 
 **SystemClock**: Có thuộc tính như currentDateTime.
MỐI QUAN HỆ GIỮA CÁC LỚP
**PayrollService - Employee (Dependency)**: PayrollService phụ thuộc vào Employee để lấy thông tin về nhân viên (mã nhân viên, lương, hoa hồng, phương thức thanh toán, giờ làm việc).

**PayrollService - Timecard (Association)**: PayrollService truy xuất dữ liệu từ Timecard để tính toán số giờ làm việc cho nhân viên làm việc theo giờ.

**PayrollService - PurchaseOrder (Association)**: PayrollService lấy dữ liệu từ PurchaseOrder để tính hoa hồng cho nhân viên bán hàng.

**PayrollService - BankSystem (Dependency)**: PayrollService gửi thông tin thanh toán cho BankSystem nếu phương thức thanh toán của nhân viên là chuyển khoản ngân hàng.

**PayrollService - SystemClock (Dependency)**: PayrollService sử dụng SystemClock để lấy thời gian hiện tại và xác định mốc thời gian cho việc chạy bảng lương.

**Employee - Timecard (Association)**: Một nhân viên có thể có nhiều Timecard để ghi lại giờ làm việc cho mỗi kỳ lương.

**Employee - PurchaseOrder (Association)**: Một nhân viên có thể có nhiều PurchaseOrder để ghi nhận các đơn hàng bán hàng của mình.

**Employee - BankSystem (Dependency)**: Mỗi nhân viên có thể liên kết với hệ thống ngân hàng để xử lý việc chuyển khoản lương.
Biểu đồ lớp : ![Diagram](https://www.planttext.com/api/plantuml/png/X5DBJiCm5Dpt55x2eXV80lN7WWK2qKgiN-qd6jMVw3qRoKASZ0L7uWhORPB6RGaRongFvyrCuf-lxnbx81-CdaWDpEBUDDf5HF4n4M8gQjK1rTfJRTyEg0M3bHW03KI3rZ-YtpbLd31ee5Y9bGjRZGT8EcDgvjhP5_1O7ErS87vrj4VLuv-JrjepH79Qhv7UQzaPb84eJLuTbTBQ-SdKPPHwQ5I8Xfn4vbRg1hjmVUxRIYoSqmZsD7XJ6vH0gXtPNNeeawhImdYKG787Z4-aaCPbKu5ubYv3S-E2zPVA2x3xTMIFffNT9c13O1caJvMVgKCfSr3tu0Fth5xvgBhKJkulkyyL7HtcNRvqzhMcqxlJlvMOsA1LQ6MyHkmBhyISsSaQilLhpBB8V-c3TlxpC8nRSFiK8quBpfZ7WlYNkrdQv1Vw2m00__y30000)

### code Java mô phỏng ca sử dụng Maintain Timecard.
### lớp Employee.java
```java
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
### lớp TimeCard.java
```java
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

### Lớp TimeCardService
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
### Lớp SystemClock
```java
import java.time.LocalDate;

public class SystemClock {
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}

### lớp Main
```java
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







