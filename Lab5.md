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

