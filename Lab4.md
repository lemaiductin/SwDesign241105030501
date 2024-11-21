# Thiết Kế Ca Sử Dụng cho Hệ Thống "Payroll System"
# Use Case: Login
## 1. Describe Interaction Among Design Objects
### Mô tả:
- Ca sử dụng Login sẽ giúp người dùng đăng nhập vào hệ thống, xác thực thông tin đăng nhập (tên người dùng và mật khẩu) thông qua AuthenticationService. Nếu thông tin đúng, hệ thống cho phép người dùng truy cập các tính năng của hệ thống. Nếu sai, hệ thống thông báo lỗi và yêu cầu người dùng nhập lại.
   
![Diagram](https://www.planttext.com/api/plantuml/png/N951RW8n34NtEON5VYumYmg6wQuRGB1t9rQ959oHuu0uMnSzKgz0Ce2OiFps-_QFy__xjuoAekda3GuQ1FQHn8ovv0Ot8YiiliAFutLWbU0zoG8mmalMx2hfaJXhL1TuHt9s0qsEqddesjAZuZV6EzLtnfG4q7pCThJmoPgBANSOJmJ85aQCyHB4cXTNNBCzBHpGEujAC0ZPaWjzD3EY6FgkXKqYkKxZ8UDe-WwQzrbRqYGyWwevRtaVC5Rd0A6Ol5Q1iw-yjuNTCLp0brC_iIMnBVzo0m00__y30000)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
- Authentication Subsystem: Đảm nhận việc xác thực thông tin người dùng, trả kết quả hợp lệ hay không.
- User Management Subsystem: Quản lý các thông tin liên quan đến người dùng (lưu trữ và truy vấn thông tin người dùng).
![Diagram](https://www.planttext.com/api/plantuml/png/R50x3i8m3Drp2ekz5-Y0O61a0S6AJ6FHIAbJnOugpiR0aRW22KA854Q_hvuVj_jA5AEcmHliD4Gu24KpPiXrRaHMMAoJziJvHdM1OP_ESXMbOG4eKCZJ1wgD9Ggso7YX8GVCd8NzSfgNkbdE4blOi6OYPPPn842sCAB85A8rjRQuwzGMZkYTHINe8jco0hsOMWJDdzOTQOeCM6-F9CdhJ-sxjuLz7oRmuU8-qXMnBSzz0W00__y30000)

## 3. Describe Persistence-Related Behavior
### Mô tả:
# User chứa các thông tin quan trọng:
- Username
- Password
- Role
# Các thao tác liên quan đến việc truy vấn và xác thực thông tin người dùng từ cơ sở dữ liệu:
- Validate: Kiểm tra tính hợp lệ của tài khoản người dùng.
- Authenticate: Xác thực người dùng vào hệ thống.

![Diagram](https://www.planttext.com/api/plantuml/png/N4yx3i8m3Drx2ezbo0Koe0uS05fn03Ur85AQYDZX8yJ963WILo2j0XBrOCb-xzdllP-lXWMZfD5LnY4px9aYt2l8fUR1uqWQEedM7yfwcucN48V5kWtkdmbmHcS75AfN6lgGSVG5mIH7ycBD0dqK7niKx96fU06WAvaaj4iKR_LfwjzVMTqI9oSTITRF2PHQ_qvei5ueeX6k6lB35FO3003__mC0)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Người dùng nhập tên đăng nhập và mật khẩu vào hệ thống.
- Hệ thống kiểm tra tính hợp lệ của tài khoản người dùng.
- Nếu thông tin đúng, người dùng sẽ được phép truy cập hệ thống.
- Nếu thông tin sai, người dùng sẽ được yêu cầu nhập lại hoặc nhận thông báo lỗi.
### 4.2 Alternative Flow:
- Nếu người dùng quên mật khẩu, hệ thống cung cấp một chức năng để đặt lại mật khẩu qua email hoặc số điện thoại.
- Nếu có lỗi kết nối cơ sở dữ liệu, hệ thống hiển thị thông báo lỗi hệ thống.
### Lý Do:
- Login là chức năng cơ bản nhất trong việc bảo mật và quản lý quyền truy cập hệ thống. Việc kiểm tra thông tin đăng nhập và thông báo cho người dùng khi có lỗi đảm bảo tính bảo mật và bảo  vệ hệ thống.

## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- User được tích hợp vào Authentication Subsystem để quản lý các thông tin đăng nhập và quyền truy cập của người dùng.
- AuthenticationService sẽ thực hiện xác thực và tương tác với Database để lấy thông tin người dùng, kiểm tra tính hợp lệ và trả kết quả về cho người dùng.


# Use Case: Maintain Purchase Order
## 1. Describe Interaction Among Design Objects
### Mô tả:
- Ca sử dụng này cho phép nhân viên mua hàng thêm, sửa, hoặc xóa đơn hàng trong hệ thống. Nhân viên tương tác với hệ thống để cập nhật thông tin, và hệ thống lưu trữ các thay đổi vào cơ sở dữ liệu.
  
![Diagram](https://www.planttext.com/api/plantuml/png/N90n3i8m34NtdC9YHzqxeD96hA1MFO19N8WKaifnnE4OE19Ne20GjAFr__l_ou_RlKg2BFdY5Hg938VCvep9XLCdE0ngd5Hdt8X1OFKHQS-Mk8b1E7fFl09Cy3ldZ4R1uyIyJRfMQj40wyqVMyBMsg8VBGeLcZm9VISHl6lLp_n2TLt2WNY8V86cxJN4aHZ5nP2Khc6zI6z9CWVeiZ6KKh53vpFJB7CY5XDBwCxnEh4fUr4L1VlwrnC00F__0m00)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
Sơ đồ tuần tự được chia thành hai hệ thống con:
- Purchase Order Subsystem: Quản lý logic xử lý đơn hàng.
  
- Database Subsystem: Lưu trữ thông tin đơn hàng.
![Diagram](https://www.planttext.com/api/plantuml/png/P92nQiD044Jx-uh5lL2l8jYnI6iXuTgixbRnWNGdTlSm_hOK-IJ_WYK8HkUqE_DcXdty_Ev5aJLDeq6haQ59RAyeFdntYiDWvaNrriyO57P_8i697J5qgPUxA4qxG87cT7aTSgn6nNx5Sg3-t03chHYAZoonWeDpvNbsg5JMD98Iv7FCrhxYs_mA6k8XyWJ7zbn3d8bHVGnYjYue_hMsf8d3ijnQ4Yc_q8-9wQrhfVBv5NJNU5jeIQEQFGMtllW9003__mC0)

## 3. Describe Persistence-Related Behavior
### Mô tả:
Lớp PurchaseOrder lưu trữ các thuộc tính của đơn hàng, bao gồm:
- OrderID
- OrderDate
- Supplier
- TotalAmount
### Các thao tác lưu trữ liên quan:
- Create: Tạo mới đơn hàng.
- Update: Cập nhật đơn hàng.
- Delete: Xóa đơn hàng.
![Diagram](https://www.planttext.com/api/plantuml/png/L90z3i8m38Ntdi9Z6Ng13AX8NPZuAHT84miYfMbnd0g4E1a3H-8Af2NyUR3aJthsUtxSxgLdIHnQcoahlOTr87MG7bUaaU2IGQm2fcbP2J2EVr4b6GMCFT4wzBqrI09g9kFs2UywbdRHTi6n0Ds5nhu405uEcCy439tH2Mcqo5zuJSxY5Tb4PyaK09vG1SPDG3hdnx6_hqRf5dsmN2D7_N-cefX_Tas1aAHYdvNezFY79m000F__0m00)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Nhân viên truy cập giao diện Purchase Order.
- Nhập thông tin đơn hàng cần thêm/sửa/xóa.
- Hệ thống xác thực dữ liệu đầu vào.
- Thực hiện thao tác thêm/sửa/xóa trên cơ sở dữ liệu.
- Hệ thống hiển thị thông báo kết quả.

### 4.2 Alternative Flow:
- Nếu thông tin đầu vào không hợp lệ, hệ thống yêu cầu người dùng sửa lỗi.
- Nếu lỗi kết nối cơ sở dữ liệu, hệ thống thông báo lỗi và cho phép thử lại sau.
### Lý Do:
- Bố cục rõ ràng giúp xử lý các tình huống bất thường và cải thiện trải nghiệm người dùng.


## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- Tích hợp lớp PurchaseOrder vào Purchase Order Subsystem để đơn giản hóa cấu trúc.
- Database Subsystem có thể quản lý nhiều bảng khác nhau, bao gồm bảng đơn hàng.
