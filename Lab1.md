### **1.PHÂN TÍCH KIẾN THÚC**
**Đề xuất kiến trúc** : Kiến trúc ba lớp  Presentation Layer (Giao diện người dùng), Business Logic Layer (Xử lý nghiệp vụ) và Data Access Layer (Truy cập dữ liệu)

**Lý do em chọn kiến trúc này** : phân tách rõ ràng, phân tách các hệ thống theo chức năng cụ thể, tái sử dụng mã nguồn và dễ dàng kiểm thử 
##### ý nghĩa : 
- Tầng Presentation: hiển thị các thành phần giao diện để tương tác với người dùng như tiếp nhận thông tin, thông báo lỗi, …
- Tầng Business Logic: thực hiện các hành động nghiệp vụ của phần mềm như tính toán, đánh giá tính hợp lệ của thông tin, … Tầng này còn di chuyển, xử lí thông tin giữa 2 tầng trên dưới.
- Tầng Data: nơi lưu trữ và trích xuất dữ liệu từ các hệ quản trị CSDL hay các file trong hệ thống. Cho phép tầng Business logic thực hiện các truy vấn dữ liệu.
- Biểu đồ package:
![Diagram](https://www.planttext.com/api/plantuml/png/Z5JBJiCm4BpdArQzSEeFS405bGDIaIeA9yHXSRR1uDZ1wo15g5_6WK_Y5t2S9it3hUhhxCxixepyz_ExO8VMbRbA2XGVc17CrbXPenHiAdQKp-0x0VyEi2KcxT19es655Tcsf7xFJqmMxhGZkqL1BmVWKUOaqAQm8Vib1r2dE44Ug33MIPqDiLqodEccPAc96LOcao8oLISU2YBIQsk49_1AKVLUsrXxYGxXMeWWFn6-pGjbAYAeorwHenU9O7wUTn8Exb5xbTmVF5grdtu8xIUyW2Lj_Ld0aWfkyPiiE8cv1FFvLSGXk0HPrw1mf_h6zftPDlNMDrhwB8aTG-fNQlQ8p3KSjp77DwUaA4D73Ax5YixN91gruGQz57WwWKgKAl0LJK5o99JZXRg9CjB-3ZM33I2FLzfN3XVgxFGC69BLNobSvbXu6wPfwlfCrA9dC4qIvedO6NkuoLai9z8SJCUKQwj2KU3R9GlIQVql_GC00F__0m00)
### **2.CƠ CHẾ PHÂN TÍCH**
##### Cơ chế xác thực và phân quyền:
Giúp đảm bảo chỉ những người có quyền hạn như payroll administrator mới có thể truy cập và quản lý thông tin nhạy cảm như thông tin lương của nhân viên.
##### Cơ chế tính toán lương:
Hệ thống cần có khả năng tính toán lương dựa trên loại nhân viên (nhân viên theo giờ, nhân viên nhận lương cố định, nhân viên nhận lương hoa hồng). Cơ chế này bao gồm việc xác định mức lương dựa trên số giờ làm việc, mức lương cơ bản, hoặc hoa hồng bán hàng.
##### Cơ chế chấm công và quản lý thời gian:
Để tính toán lương chính xác, hệ thống cần ghi lại thông tin về số giờ làm việc của nhân viên (timecard). Điều này giúp đảm bảo thông tin thời gian làm việc được cập nhật và lưu trữ chính xác.
##### Cơ chế xử lý thanh toán:
Xác định phương thức thanh toán (chuyển khoản ngân hàng, nhận lương trực tiếp, gửi qua bưu điện) và thực hiện thanh toán tương ứng cho nhân viên vào thời điểm thích hợp.
##### Cơ chế lưu trữ và truy vấn dữ liệu:
Cần có khả năng lưu trữ thông tin liên quan đến nhân viên, bảng chấm công, và lương một cách nhất quán và an toàn, đồng thời cung cấp khả năng truy vấn nhanh chóng khi cần thiết.
##### Cơ chế thông báo và nhắc nhở:
Tạo thông báo về các sự kiện quan trọng như thời gian thanh toán lương hoặc nhắc nhở chấm công.
### **3.CA SỬ DỤNG PAYMENT**
**PaymentService**: Chịu trách nhiệm xử lý thanh toán lương cho nhân viên.

**Employee**:Lớp đại diện cho nhân viên trong hệ thống, chứa các thông tin cần thiết cho thanh toán như tên, mã nhân viên, và phương thức thanh toán.

**Paycheck**:Đối tượng đại diện cho bảng lương, ghi nhận số tiền đã thanh toán, ngày thanh toán, và các chi tiết liên quan.

**BankSystem**: Tương tác với ngân hàng để thực hiện thanh toán qua chuyển khoản.

#### *BIỂU ĐỒ TUẦN TỰ CỦA PAYMENT*
 ![Diagram](https://www.planttext.com/api/plantuml/png/X91D2i8m48NtdYBB5lG2NRYGkd1NA1uWZ4yDRNwSf4BEvi8ZUGNJqA98mUsR-TwRDw_7y-Z1OhCLZOmQ9hJWkoA8IZ1k0toOz0BQzJO2XrEv-jbDz7wQ9kw2cQaHfEhz7pGfT0Lr2IM639Y5GcexcB0MJiO6hEmYlfEcQwCFqCd0iILuNoi6fNXdlVfSdesoSxdwefQwapLdnNhklfIR_rQDbdamq1YSDjy0003__mC0 )

#### NHIỆM VỤ 
**PaymentService**: Thực hiện toàn bộ quá trình xử lý thanh toán, từ xác định thông tin lương của nhân viên đến giao dịch với ngân hàng.

**Employee**: Cung cấp thông tin về phương thức thanh toán và các chi tiết cá nhân cần thiết cho việc thanh toán.

**Paycheck**: Lưu trữ thông tin về bảng lương sau khi thanh toán thành công.

**BankSystem**: Xử lý các giao dịch trực tiếp với ngân hàng để chuyển tiền vào tài khoản của nhân viên.

#### THUỘC TÍNH 
**Employee**: Có các thuộc tính như employeeId, name, paymentMethod.

**Paycheck**: Có các thuộc tính như amount, payPeriod, dateIssued.

**PaymentService**: Gọi đến các lớp khác để thực hiện thanh toán.

**BankSystem**: Liên kết với PaymentService để xử lý thanh toán qua ngân hàng.

##### MỐI QUAN HỆ GIỮA CÁC LỚP
**PaymentService - Employee(Dependency)**: PaymentService phụ thuộc vào Employee để lấy thông tin về nhân viên cần xử lý thanh toán.

**PaymentService - Paycheck(Association)**: Mỗi lần xử lý thanh toán, PaymentService sẽ tạo ra một đối tượng Paycheck cho nhân viên.

**PaymentService - BankSystem(Dependency)**: PaymentService phụ thuộc vào BankSystem để thực hiện các giao dịch chuyển khoản.

**Employee - Paycheck(Association)**: Một Employee có thể liên kết với nhiều Paycheck, mỗi Paycheck tương ứng với một lần thanh toán.


### **4.CA SỬ DỤNG MAITAIN TIMECARD**
**TimecardService**: Quản lý việc ghi lại thời gian làm việc của nhân viên.

**Employee**: Lớp đại diện cho nhân viên trong hệ thống.

**Timecard**: Ghi lại số giờ làm việc của nhân viên trong mỗi kỳ lương.

**SystemClock**: Hỗ trợ xác định thời gian ghi nhận chấm công.

#### *BIỂU ĐỒ TUẦN TỰ CỦA MAITAIN TIMECARD*
![Diagram](https://www.planttext.com/api/plantuml/png/R90x3i8m44HxJh5baC85Kj042kg0g8CzW9KOe_Kwaiz6mP6u0bQ4nI_jxCpRqJnkzvq7qs99MsEXMjODU30AL94F1siawmNijNSHsEYIpYwmtplkeEUptsI2hL_UH1d0vXYpy46P33RH2spTEzMbx0bI1sPSPDKAYib4bfATeHphly9VTKjIR-8aS1oa8icNSGM1Jk-V0000__y30000)

#### NHIỆM VỤ
**TimecardService**: Xử lý việc ghi nhận và lưu trữ thông tin chấm công của nhân viên.

**Employee**: Xác thực nhân viên và cung cấp thông tin liên quan để ghi chép chấm công.

**Timecard**: Lưu giữ thông tin về số giờ làm việc của nhân viên trong một ngày hoặc kỳ lương cụ thể.

**SystemClock**: Cung cấp thời gian hiện tại để ghi nhận chấm công.

##### THUỘC TÍNH VÀ QUAN HỆ GIỮA CÁC LỚP
**Employee**: Có các thuộc tính như employeeId, name.

**Timecard**: Có các thuộc tính như employeeId, date, hoursWorked.

**TimecardService**: Kết nối với Employee và Timecard để xử lý chấm công.

**SystemClock**: Được sử dụng bởi TimecardService để lấy thời gian hiện tại.

##### MỐI QUAN HỆ GIỮA CÁC LỚP
**TimecardService - Employee(Dependency)**: TimecardService phụ thuộc vào Employee để xác thực nhân viên và lấy thông tin cần thiết cho việc ghi chép chấm công.

**TimecardService - Timecard(Association)**: TimecardService có thể tạo hoặc cập nhật nhiều Timecard cho các nhân viên. Mỗi Timecard đại diện cho một bản ghi về 
giờ làm việc của nhân viên.
**TimecardService - SystemClock(Dependency)**: TimecardService phụ thuộc vào SystemClock để lấy thời gian hiện tại khi ghi nhận thông tin chấm công.

**Employee - Timecard(Association)**: Một Employee có thể có nhiều Timecard, mỗi Timecard ghi lại thời gian làm việc của nhân viên trong một ngày hoặc kỳ lương cụ thể.

### **5.HỢP NHẤT KẾT QUẢ PHÂN TÍCH**
`Các ca sử dụng Payment và Maintain Timecard đều liên quan đến việc quản lý thông tin nhân viên, cho phép sử dụng chung các lớp như Employee.
Cần thiết lập các lớp dịch vụ như PaymentService và TimecardService để đảm bảo việc xử lý thanh toán và chấm công diễn ra trơn tru.
Dữ liệu của các lớp như Paycheck và Timecard có thể liên kết với nhau thông qua thông tin nhân viên, giúp hệ thống có cái nhìn toàn diện về thời gian làm việc và thanh toán.`

