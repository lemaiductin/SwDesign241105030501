# Thiết Kế Ca Sử Dụng cho Hệ Thống "Payroll System"
# Ca sử dụng Login
## 1. Describe Interaction Among Design Objects
### Mô tả:
- Người dùng tương tác với hệ thống bằng cách nhập username và password.
- LoginController nhận yêu cầu từ người dùng.
- AuthenticationService kiểm tra tính hợp lệ của thông tin đăng nhập.
- DatabaseSubsystem lưu trữ và trả về dữ liệu cần thiết (thông tin người dùng) để phục vụ việc xác thực.
![Biểu đồ squence](https://www.planttext.com/api/plantuml/png/T54xJWCn4ErzYgde8lejK2AIZWOYfPzu7s39Qwzcng0zMmgEn1MmKL8ak-d6C--dvz_JprgDnSeG7NlBGhjXZ7a2t5ZNmOUHaz5B_WZfEIUJ72FawhOfzebKdsmXfptaAtYudesFhA3jUTYNeqvg69oxMD3gwLQverqo21M591v03pIowdUMtjr06tlHkwC3nr03WBoWRtUEwXQnJMIMiAFN0fd-Gr0Fur3fCnIjxWTuWnL9Pu5Al6U-LC0rbBHu3zN7zvgY2EOjL8rBeHrjWuwH9ueDHG8jqTmQgMyV_0S00F__0m00)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
LoginController: Hệ thống con chịu trách nhiệm giao tiếp với người dùng.
AuthenticationService: Hệ thống con xử lý logic xác thực.
DatabaseSubsystem: Hệ thống con lưu trữ và truy xuất dữ liệu người dùng.
![Biểu đồ]

## 3. Describe Persistence-Related Behavior
### Mô tả:
DatabaseSubsystem lưu trữ thông tin người dùng.
Dữ liệu được truy xuất bằng cách thực hiện truy vấn dựa trên username.
Nếu tìm thấy thông tin khớp, dữ liệu sẽ được trả về để xác thực.

![Biểu đồ lớp]

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:

### 4.2 Alternative Flow:

### Lý Do:


## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:


![Biểu đồ]

## Lý Do:

