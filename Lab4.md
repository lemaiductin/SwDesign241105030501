# Thiết Kế Ca Sử Dụng cho Hệ Thống "Payroll System"
# Ca sử dụng Login
## 1. Describe Interaction Among Design Objects

### Mô tả:
- Ca sử dụng này mô tả quá trình người dùng đăng nhập vào hệ thống để truy cập vào các chức năng của hệ thống lương.
- 
### Các bước hành động:
Bước 1: Người dùng nhập tên đăng nhập và mật khẩu vào màn hình đăng nhập.
Bước 2: LoginController nhận thông tin đăng nhập từ người dùng.
Bước 3: LoginController gọi UserService để kiểm tra tính hợp lệ của tên đăng nhập và mật khẩu.
Bước 4: UserService kiểm tra thông tin đăng nhập với cơ sở dữ liệu. Nếu thông tin đúng, trả về thông tin người dùng và quyền truy cập.
Bước 5: LoginController nhận thông tin từ UserService và xác thực.
Nếu thông tin hợp lệ, chuyển hướng người dùng đến trang chính của hệ thống.
Nếu thông tin sai, hiển thị thông báo lỗi và yêu cầu người dùng thử lại.
Bước 6: Sau khi đăng nhập thành công, hệ thống lưu trữ thông tin người dùng vào phiên làm việc (session).

### Tại sao thiết kế như vậy:
Đảm bảo tính bảo mật và xác thực người dùng thông qua việc kiểm tra tên đăng nhập và mật khẩu.
Quy trình đăng nhập được phân chia rõ ràng thành các bước từ thu thập thông tin đến xác thực và xử lý lỗi.
Sử dụng session để lưu trữ thông tin người dùng, giúp duy trì phiên làm việc trong suốt quá trình sử dụng hệ thống.
