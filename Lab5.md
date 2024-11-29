# Thiết kế hệ thống con Login
### 1.Distribute Subsystem Behavior to Subsystem Element
Phân rã hành vi hệ thống con:
User Interface Subsystem:
- Nhận thông tin đăng nhập từ người dùng (username, password).
- Hiển thị thông báo lỗi hoặc chuyển hướng sau khi xác thực.
  
Authentication Subsystem:
- Kiểm tra thông tin đăng nhập từ cơ sở dữ liệu.
- Mã hóa và giải mã mật khẩu.

Database Subsystem:
- Truy xuất thông tin người dùng từ cơ sở dữ liệu (username, password hash).
- Lưu trữ hoặc cập nhật dữ liệu phiên đăng nhập (session data).

Authorization Subsystem:
- Gán vai trò (role) và quyền hạn (permissions) cho người dùng sau khi đăng nhập.
### 2. Document Subsystem Elements
#### Subsystem 1: User Interface
Chức năng:
- Giao diện nhập tên đăng nhập và mật khẩu.
- Hiển thị thông báo lỗi hoặc chuyển hướng sau khi đăng nhập thành công.
Thành phần:
- LoginForm: Biểu mẫu đăng nhập.
- ErrorMessage: Hiển thị thông báo lỗi khi đăng nhập thất bại.
#### Subsystem 2: Authentication
Chức năng:
- Xác thực thông tin người dùng.
- Mã hóa và kiểm tra mật khẩu.
Thành phần:
- Authenticator: Kiểm tra thông tin người dùng với cơ sở dữ liệu.
- PasswordHasher: Xử lý mã hóa mật khẩu.
#### Subsystem 3: Database
Chức năng:
- Lưu trữ thông tin người dùng và phiên đăng nhập.
- Truy xuất thông tin dựa trên tên đăng nhập.
Thành phần:
- UserTable: Bảng dữ liệu chứa thông tin người dùng.
- SessionTable: Bảng dữ liệu chứa thông tin phiên.
#### Subsystem 4: Authorization
Chức năng:
- Xác định vai trò và quyền hạn của người dùng sau khi đăng nhập.
Thành phần:
- RoleManager: Quản lý vai trò của người dùng.
- PermissionChecker: Xác định quyền truy cập dựa trên vai trò.
### 3. Describe Subsystem Dependencies
Các mối phụ thuộc giữa các hệ thống con:
User Interface → Authentication

Hệ thống giao diện gọi Authenticator để xác thực thông tin người dùng.
Authentication → Database

Authenticator yêu cầu dữ liệu từ UserTable trong hệ thống cơ sở dữ liệu.
Authentication → Authorization

Sau khi xác thực, Authenticator yêu cầu RoleManager trong Authorization để gán vai trò.
Authorization → Database

RoleManager có thể truy cập UserTable để lấy thông tin vai trò người dùng.
User Interface → Authorization

Sau khi gán vai trò, thông tin vai trò được gửi lại User Interface để hiển thị quyền hạn.
### 4. Checkpoints
Các bước kiểm tra hoàn thiện:
Input Validation:
Đảm bảo hệ thống con User Interface xác thực đầu vào (username, password không rỗng, định dạng hợp lệ).

Authentication:
Authenticator kiểm tra mã hóa mật khẩu và xác thực thông tin từ UserTable.

Session Handling:
Đảm bảo SessionTable trong Database lưu trữ dữ liệu phiên đăng nhập đúng.

Role Assignment:
RoleManager xác định chính xác vai trò dựa trên thông tin trong UserTable.

Error Handling:
Hệ thống hiển thị thông báo lỗi khi người dùng nhập sai thông tin.
### Sơ đồ phụ thuộc giữa các hệ thống con Login
![Dependency - Login](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3XTNGM9oTc9wgeAIJtvwPfv2S6bISMLnIMgkaa8rbu92T6XnQf62Prv9Qb5QOd8gGZfMGLVNJY7QiRGa8pMl93CviIGp7qbtB4WlJac8NfV4aiIanE9KqdG5fnONWyHz4_E0piu5gaJJZrS1n0omfmAAyjCoSr1ihqKA3apNGKC4YxEHJ8N9eXg6pqrGOubmDam9YXqEgNafe8W40000__y30000)


# Thiết kế hệ thống con Run Payroll
### 1.Distribute subsystem behavior to subsystem elements:
#### User Interface Subsystem: 
Nhận yêu cầu từ người dùng để chạy bảng lương.

#### Payroll Calculation Subsystem:
Tính toán bảng lương cho từng nhân viên dựa trên dữ liệu công việc, giờ làm việc, thuế, phụ cấp, v.v.

#### Employee Database Subsystem: 
Cung cấp thông tin về nhân viên như giờ làm, mức lương cơ bản, các khoản phụ cấp, v.v.

#### Payment Processing Subsystem: 
Tiến hành xử lý thanh toán và chuyển tiền cho nhân viên.

#### Report Generation Subsystem: 
Tạo báo cáo về bảng lương để gửi cho quản lý và nhân viên.

#### Notification Subsystem: 
Gửi thông báo cho nhân viên về kết quả bảng lương (ví dụ: qua email hoặc ứng dụng).

### 2.Document subsystem elements:

#### User Interface Subsystem:
Tương tác với người dùng, nhận yêu cầu và hiển thị kết quả.

#### Payroll Calculation Subsystem:
Tính toán bảng lương và các khoản khấu trừ, thuế.

#### Employee Database Subsystem:
Chứa thông tin của nhân viên, bao gồm mức lương, ngày công, ngày nghỉ

#### Payment Processing Subsystem:
Thực hiện thanh toán và chuyển tiền cho nhân viên.

### Report Generation Subsystem:
Tạo báo cáo cho bảng lương.

#### Notification Subsystem:
Gửi thông báo cho nhân viên về bảng lương đã được thực hiện.

### 3.Describe Subsystem Dependencies:
User Interface Subsystem phụ thuộc vào Payroll Calculation Subsystem để tính toán bảng lương và nhận thông tin nhân viên từ Employee Database Subsystem.

Payroll Calculation Subsystem sẽ yêu cầu thông tin từ Employee Database Subsystem để thực hiện tính toán.

Payroll Calculation Subsystem gửi kết quả thanh toán cho Payment Processing Subsystem để thực hiện thanh toán.

Report Generation Subsystem nhận dữ liệu từ Payroll Calculation Subsystem để tạo báo cáo.

Notification Subsystem phụ thuộc vào Payroll Calculation Subsystem để gửi thông báo về bảng lương.

### 4.Checkpoints
#### Thông tin người dùng được nhập vào từ giao diện người dùng.
Kiểm tra việc nhập liệu hợp lệ và gửi yêu cầu.

#### Bảng lương được tính toán chính xác.
Kiểm tra tính toán lương, thuế, phụ cấp dựa trên dữ liệu nhân viên.

#### Dữ liệu nhân viên được truy xuất đúng từ cơ sở dữ liệu.
Xác minh thông tin nhân viên như mức lương cơ bản, số giờ làm việc.

#### Thanh toán được xử lý thành công.
Kiểm tra việc chuyển tiền cho nhân viên qua hệ thống thanh toán.

#### Báo cáo lương được tạo và xuất đúng định dạng.
Kiểm tra báo cáo bảng lương cho người quản lý và nhân viên.

#### Thông báo được gửi cho nhân viên sau khi bảng lương hoàn tất.
Xác minh việc gửi email hoặc thông báo về kết quả bảng lương.

### Sơ đồ phụ thuộc giữa các hệ thống con Run Payroll
![Dependency - Run Payroll](https://www.planttext.com/api/plantuml/png/d8yz2i9044RxFSMGFbSGGKLi94IiWiLacOJ5_GapiqKGJsRXaRo2YeY2O97wU-_1TxjSvwB8ceCtPa1xn9wWg7E42aTEtiCkjpAAKYZWP02QlH339YfnXvO-ym7ASWRDMrkWjzcZkXI_c6VWF_6ghCBWqqW4IrHiKMX2uy44YWeL9qiYBlOJ8ZKDYHNM58cddjacTPspF_hPt0400F__0m00)
