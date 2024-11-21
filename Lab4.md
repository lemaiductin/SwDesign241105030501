# Thiết Kế Ca Sử Dụng cho Hệ Thống "Payroll System"
# Use Case: Login
## 1. Describe Interaction Among Design Objects
### Mô tả:
 Ca sử dụng này cho phép người dùng (nhân viên trả lương hoặc quản lý) đăng nhập vào hệ thống bằng cách nhập tên đăng nhập và mật khẩu để có quyền truy cập vào các chức năng của hệ thống.
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


# Use Case: Maintain Purchase Order
## 1. Describe Interaction Among Design Objects
### Mô tả:
Ca sử dụng này cho phép nhân viên mua hàng thêm, sửa, hoặc xóa đơn hàng trong hệ thống. Nhân viên tương tác với hệ thống để cập nhật thông tin, và hệ thống lưu trữ các thay đổi vào cơ sở dữ liệu.
![Biểu đồ squence](https://www.planttext.com/api/plantuml/png/N90n3i8m34NtdC9YHzqxeD96hA1MFO19N8WKaifnnE4OE19Ne20GjAFr__l_ou_RlKg2BFdY5Hg938VCvep9XLCdE0ngd5Hdt8X1OFKHQS-Mk8b1E7fFl09Cy3ldZ4R1uyIyJRfMQj40wyqVMyBMsg8VBGeLcZm9VISHl6lLp_n2TLt2WNY8V86cxJN4aHZ5nP2Khc6zI6z9CWVeiZ6KKh53vpFJB7CY5XDBwCxnEh4fUr4L1VlwrnC00F__0m00)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
Sơ đồ tuần tự được chia thành hai hệ thống con:
Purchase Order Subsystem: Quản lý logic xử lý đơn hàng.
Database Subsystem: Lưu trữ thông tin đơn hàng.
![Biểu đồ](https://www.planttext.com/api/plantuml/png/P92nQiD044Jx-uh5lL2l8jYnI6iXuTgixbRnWNGdTlSm_hOK-IJ_WYK8HkUqE_DcXdty_Ev5aJLDeq6haQ59RAyeFdntYiDWvaNrriyO57P_8i697J5qgPUxA4qxG87cT7aTSgn6nNx5Sg3-t03chHYAZoonWeDpvNbsg5JMD98Iv7FCrhxYs_mA6k8XyWJ7zbn3d8bHVGnYjYue_hMsf8d3ijnQ4Yc_q8-9wQrhfVBv5NJNU5jeIQEQFGMtllW9003__mC0)

## 3. Describe Persistence-Related Behavior
### Mô tả:
Lớp PurchaseOrder lưu trữ các thuộc tính của đơn hàng, bao gồm:
OrderID
OrderDate
Supplier
TotalAmount
### Các thao tác lưu trữ liên quan:
Create: Tạo mới đơn hàng.
Update: Cập nhật đơn hàng.
Delete: Xóa đơn hàng.
![Biểu đồ lớp](https://www.planttext.com/api/plantuml/png/L90z3i8m38Ntdi9Z6Ng13AX8NPZuAHT84miYfMbnd0g4E1a3H-8Af2NyUR3aJthsUtxSxgLdIHnQcoahlOTr87MG7bUaaU2IGQm2fcbP2J2EVr4b6GMCFT4wzBqrI09g9kFs2UywbdRHTi6n0Ds5nhu405uEcCy439tH2Mcqo5zuJSxY5Tb4PyaK09vG1SPDG3hdnx6_hqRf5dsmN2D7_N-cefX_Tas1aAHYdvNezFY79m000F__0m00)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
Nhân viên truy cập giao diện Purchase Order.
Nhập thông tin đơn hàng cần thêm/sửa/xóa.
Hệ thống xác thực dữ liệu đầu vào.
Thực hiện thao tác thêm/sửa/xóa trên cơ sở dữ liệu.
Hệ thống hiển thị thông báo kết quả.

### 4.2 Alternative Flow:
4.2.1: Nếu thông tin đầu vào không hợp lệ, hệ thống yêu cầu người dùng sửa lỗi.
4.2.2: Nếu lỗi kết nối cơ sở dữ liệu, hệ thống thông báo lỗi và cho phép thử lại sau.
### Lý Do:
Bố cục rõ ràng giúp xử lý các tình huống bất thường và cải thiện trải nghiệm người dùng.


## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
Tích hợp lớp PurchaseOrder vào Purchase Order Subsystem để đơn giản hóa cấu trúc.
Database Subsystem có thể quản lý nhiều bảng khác nhau, bao gồm bảng đơn hàng.
