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
### User chứa các thông tin quan trọng:
- Username
- Password
- Role
### Các thao tác liên quan đến việc truy vấn và xác thực thông tin người dùng từ cơ sở dữ liệu:
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

![Diagram](https://www.planttext.com/api/plantuml/png/V55BZi8m3Dtt51OhM7015gW8Re3c02PzAX5foiHE4KASZ0L7cYjCMZwJZaRZvNlFpy_sr-rUYdBGsBZYoER0DMYoYhg7LsjORUjf6tTo5aKpeKj1gOnZ4HghjWYTDNWg7jMninKhrW5LhsGdqrd6yuy3FWJXILwp8JsSUSuf9i1pWmmw9k6f3LK6XTOX6rH3UwCDbEqxGpvcmyexbd7ypuXm7leIEmektE4NyN3x-oRpvR37WgnN13OgTBAw_x_Z5ManvB2GONLAz-JYMfJmLV-pRm000F__0m00)


# Use Case: Maintain Purchase Order
## 1. Describe Interaction Among Design Objects
### Mô tả:
- Ca sử dụng này cho phép nhân viên mua hàng thêm, sửa, hoặc xóa đơn hàng trong hệ thống.
- Nhân viên tương tác với hệ thống để cập nhật thông tin, và hệ thống lưu trữ các thay đổi vào cơ sở dữ liệu.
  
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
![Diagram](https://www.planttext.com/api/plantuml/png/T94z3i8m38Ntd2Bg10CNO415wi844YTm4wkjI7yKEo24UZ86ZiGLQ8X0QGiUlsVhFTlF-oCb1ikkDg83TO82PN9mLfL0AFTMevL7bzEL6Ej4teGSIXaWaf-kq1IKKAqdksnACc2C6BckCnNQ277BOBPrwngEgB8uJBvj5ik8kqx_v1eDZdaVnHvIGEwNYnCJdCE0L_-PpBJ8QAOLo5CXf1YVRRNv1bhBgc6qe9ZafU9Iz2B5HllFl0000F__0m00)

# Use Case: Create Employee Report
## 1. Describe Interaction Among Design Objects
### Mô tả:
 - Ca sử dụng này cho phép người dùng tạo báo cáo nhân viên, bao gồm các thông tin liên quan đến danh sách nhân viên, lương, và các thông tin tổng hợp khác.
   
![Diagram](https://www.planttext.com/api/plantuml/png/R951JiCm44NtFiKe-ruW2rJI55XKeaq4-y4PYKYk7SPZHCx6WYDn1UmuQIFKrTZwxy_yiN-_VxPUa2MSZK8jZk6f0VJmuedL48LUzmDQWM9_7emRYHeQ7ClEMM5d376HyElrjgab_kmrJUnylWtMzyyJ5AlgKF0DFK5nn35rhwkiLKgbVB2vMmqkeQ6FG5vWnuH2a8EgAv7uUNW9hsZwBcEJIyrAWkBm4Xv8z3iikQ2EOLGK9hqgOVz5EaHxUph0AH2FggvWivWRai0s5X-C-EnRJv_r8pjDtbENsryY_5ki9TlDwsHmlLDaqsDSUZwI9OwBBGwrZUxqlNy0003__mC0)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
- Report Generation xử lý logic tạo báo cáo.
- Data Access giao tiếp với cơ sở dữ liệu.
  
![Diagram](https://www.planttext.com/api/plantuml/png/N90xZi8m48PxdsAKdWkaG125Hq41MUq11cSa8XaxUCOIETiMUoIkW6qW0Qfv_9_-UTp-_XSiw2MSZK8jpiEs0MJuPVAgZqAdknwjGD5Gxxnio997wPmj4ZOsFzaQ1PTQ4tEcfbArCJqY4nHx7BmpfguUIALKcWcp-MHQnlGIYENPKgEIiCcrX3M9Fi7gt1it46L9JNgcgn9MLz9127uEEpW4yeEgAvXzMJKamTiOE1ZX3vVltJAOPxqj5g5qoAW_FqRjwuW5sJQz-mu00F__0m00)

## 3. Describe Persistence-Related Behavior
### Mô tả:
- Truy vấn danh sách nhân viên từ cơ sở dữ liệu.
- Lọc dữ liệu theo yêu cầu.
- Tạo bảng dữ liệu để xuất báo cáo.
  
![Diagram](https://www.planttext.com/api/plantuml/png/P51B2i903Dtd5BFKHIyWKghKdM2n9mWrre6PJib4eOWdS-6Hl88CRMMOPXLUyZx9z_qfl23BtHfe37gl3hOtRY0gToVr11NgIjBS_ZWAhjORTTHUjZEOmmiIVatyq0tD6Yrrn2Xqfjwn186nMn97VE9bDA71Rc4wfdDiKUPOjR3ksg0Q7v9bkQfmO6TCkOSqOfX6sv0aYSSJ1GhgBk5dFm000F__0m00)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Người dùng yêu cầu tạo báo cáo thông qua giao diện.
- Hệ thống xác thực yêu cầu và gửi đến EmployeeReportController.
- EmployeeService truy vấn danh sách nhân viên thông qua EmployeeDAO.
- EmployeeDAO thực hiện các truy vấn SQL để lấy dữ liệu từ PayrollDB.
- Dữ liệu được định dạng và trả về dưới dạng báo cáo.
- Báo cáo được hiển thị cho người dùng.

### 4.2 Alternative Flow:
- Nếu không có dữ liệu trong cơ sở dữ liệu: Hệ thống thông báo "Không có dữ liệu".
- Nếu xảy ra lỗi kết nối cơ sở dữ liệu: Hệ thống trả về thông báo lỗi.
### Lý Do:
- Luồng này đảm bảo tất cả các bước từ yêu cầu đến hiển thị kết quả được xử lý rõ ràng, cho phép người dùng tạo báo cáo chính xác và hiệu quả.


## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- EmployeeDAO sẽ được tích hợp vào DataAccess subsystem.
- EmployeeReport sẽ trở thành một phần của ReportGeneration subsystem.
- Các subsystem liên kết với nhau thông qua các phương thức dịch vụ.

![Diagram](https://www.planttext.com/api/plantuml/png/T90z3i8m38NtdCBg10CNO4150h732Kmm9I9_Ibn1XNeo1ex45MZ9agZWoNhlsP_iz_DLHyR0hT72exnYGr3joRl0i2DB0Lav2uVs6Bl8P2fu21XAQemHKZ3B9JDLasHAeTayiyvACuMjyTfrH1jaB6qN378nrsVKCR-MaeQsvF7_ZL_WHARxYFW1cXosM6NO9IWxh4F94MwABw8NDTdJ-CCF0000__y30000)


# Use Case: Maintain Employee Information
## 1. Describe Interaction Among Design Objects
### Mô tả:
 - Ca sử dụng này cho phép người dùng (như quản lý nhân sự) thêm, sửa, hoặc xóa thông tin nhân viên trong hệ thống. Thông tin này được lưu trữ trong cơ sở dữ liệu thông qua các lớp liên quan.
   
![Diagram](https://www.planttext.com/api/plantuml/png/T94z3i8m38NtdC8Nu08P4AXbO42WLXp0j0OYfKw9NIJEni2Hk0AbKb7u6-p1UU_fqylzUfk9OjIkyGOh3H7cTUFO31icKrWqhGyNeYomnk0zHGi5dJeIXHKwrdvU8bZoFfXlInfKKZoxYYniOgX8P4mp7uBKay_N5hPjZKgGe-8EXKpo-DIETmibdWco8_A1n8ndc7pczNXx5vj1_XxsYxOWxI93gQYTVBF-RMfm5IHju8GvhQQt3crRo9sq7YyZ6QeBR6R4zVDt7W000F__0m00)
## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
- Hệ thống được chia thành các hệ thống con như Employee Subsystem để quản lý các tác vụ liên quan đến nhân viên và Database Subsystem để thực hiện lưu trữ dữ liệu. Việc phân chia này giúp đơn giản hóa biểu đồ tuần tự và tăng tính rõ ràng trong thiết kế.
![Diagram](https://www.planttext.com/api/plantuml/png/P90x3eD034JxFOL5pmKe8gAG8aMQe1p0i4PQQN_29X9dIv4ZvGfXAVYbi6JPRsOiVz-VaWLx6PnLs4heuQoTyO0Cc1eLfwLfJKGla5rTj64aWdfeU6GXboMIN5m6Uq65WWtoKQ2RbLTp3kIddKq1TpHUfe8bzEQxeBPG4csi2dX6ZKAh8iMh3G7vNymb-Cxq3cfyqS5yOkVR2gWCHuiZF8W7AweahzF3VW000F__0m00)

## 3. Describe Persistence-Related Behavior
### Mô tả: 
- Dữ liệu nhân viên được lưu trữ và truy xuất từ cơ sở dữ liệu.
  
![Diagram](https://www.planttext.com/api/plantuml/png/J8vB2i8m48RtESKiTT4BP24jrBMe9vWcWmJoA9a9D8WdS-6Hl886MdJv_Volz_FLis2M4hmo7fdX66QVAX7S5G0ukx465wL94SCNhf9Tl3MU4pjnAVvhZ1vprM1JcJofXrhBHnISaDToMiWKeNEXN7Tx3HVYugMvjz5nE47N7Nuv3OCnnAnwYhQT_W000F__0m00)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Quản trị viên chọn chức năng duy trì thông tin nhân viên.
- Hệ thống cho phép thêm mới, chỉnh sửa hoặc xóa nhân viên.
- Dữ liệu được cập nhật vào cơ sở dữ liệu.
- Hệ thống trả về kết quả cập nhật.

### 4.2 Alternative Flow:
- Hiển thị thông báo lỗi nếu dữ liệu không hợp lệ (ví dụ: thông tin bị thiếu hoặc định dạng sai).
- Hiển thị thông báo lỗi hệ thống nếu không thể lưu dữ liệu.
### Lý Do:
- Đảm bảo hệ thống hoạt động chính xác, xử lý đầy đủ các tình huống nhập liệu và lỗi.


## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- Gộp các lớp EmployeeController, EmployeeService, và EmployeeDAO vào Employee Subsystem.
- Database giữ vai trò riêng biệt để xử lý truy cập dữ liệu.


# Use Case: Run Payroll
## 1. Describe Interaction Among Design Objects
### Mô tả:
 - Ca sử dụng này cho phép quản trị viên thực hiện tính toán bảng lương dựa trên dữ liệu thời gian làm việc và thông tin nhân viên.
   
![Diagram](https://www.planttext.com/api/plantuml/png/T97D3S8m38NldS8Bi40F2DHo1b4Mi58ZHKeQS9nAdOq38x42JKNw8zfJ53z_pthsv_K-U46MO4s6IXp31JjsnXnhgvji_e7TFec5QoI-n3bSwHd8IvAWGAE2GT5knAVscKT5t6f5ELpOAV8-6MLBFH8tRKaXr-Nn7ES9Qsffh4A9WYlKoJwCwuYMLAfkKR_A05NO0odNlBzNORSIfGzwrsm7yCzxQtqIk85AK89VMzY43LV8eTJ-OR3hIH-CP0TgwdYzBm000F__0m00)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
- Hệ thống được phân chia thành các hệ thống con như Payroll Subsystem để xử lý bảng lương và Database Subsystem để lưu trữ thông tin. Sự tách biệt này giúp giảm độ phức tạp của quy trình tính lương và làm rõ vai trò của từng thành phần trong hệ thống.
![Diagram](https://www.planttext.com/api/plantuml/png/Z9512i8m44NtESNGVI_GXLIiUr4lC6r622HfI2P2p-R28ta5crPhhOBkml3U_C_aThcMWT5pD5fWmws77NQ-rNejZRA00J0zXEiPrIY7bY5x8728TUW2ayaIwCRfD7ntAcIiCT12alMB5qCKvAkFLGLiK3TH8zEpdrWooPjjAs1Fx1MT2RR6wROZ0hGIZifGWrv2AYHc0kHVW_ijqTkH_XbvmFDKyD-0JMjFofl1_PBGEyDP2gXKS1gxlb68caL9LgPVkmC00F__0m00)

## 3. Describe Persistence-Related Behavior
### Mô tả: 
- Dữ liệu nhân viên được lưu trữ và truy xuất từ cơ sở dữ liệu.
  
![Diagram](https://www.planttext.com/api/plantuml/png/J8uz2iCm58Dtd-ADxP0BU2W9PEdKlnEys1eABqwmdw6cz6GTUgHUeJK9j8lW4nBI-_bgatBKF8fnmYdHaKkSHEXkY6XUOEyjNODM1-CiKm7-h02zi70ibloK1y7Q716qPuMbgkPXreKlyS09omHkS5bnoeXbixLqHigYDRq-wRi3DStkLxFKEOUKJ8lWw_4F0000__y30000)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Quản trị viên chọn chức năng tính bảng lương.
- Hệ thống lấy dữ liệu chấm công và thông tin nhân viên từ cơ sở dữ liệu.
- Hệ thống thực hiện tính toán bảng lương.
- Kết quả được lưu vào cơ sở dữ liệu.
- Hệ thống trả về trạng thái hoàn tất.

### 4.2 Alternative Flow:
- Hiển thị thông báo lỗi nếu thiếu dữ liệu chấm công hoặc thông tin nhân viên.
- Hiển thị thông báo lỗi hệ thống nếu không thể lưu kết quả.
### Lý Do:
- Chắc chắn Hệ thống hoạt động chính xác, xử lý lỗi và hoàn thành quy trình tính bảng lương.


## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- Gộp các lớp PayrollController, PayrollService, và PayrollDAO vào Payroll Subsystem.
- Database giữ vai trò riêng biệt để xử lý truy cập dữ liệu.
![Diagram](https://www.planttext.com/api/plantuml/png/T5512i8m4Bpt5S6J7lo01n5HmPjGFx0csrBS9YMR24LycGUVv1VKDYq9nRrbPtPdTl9-lZRim3fVKzQ0l4A9OdQ2rXeYSR968dEbIv7x2xVii9w9UoQ-9GcOHM06eh41xAlfmUCkxlNCC3TVH904afx0OGu4jWtO8rBRrmsP5Z5HmT1CP3JK63svsnWr52elNMKqJqIseA_ZjOcIiw2vG7lmMd5Y_GPKgQ_pyuy1tUB4_YIcvNeyPZLaWZma9WfZ_yub_bQZAHwEV6GRrEhtdny0003__mC0)

# Use Case: Create Administrative Report
## 1. Describe Interaction Among Design Objects
### Mô tả:
 - Ca sử dụng này cho phép người dùng (quản lý) tạo các báo cáo hành chính trong hệ thống, bao gồm báo cáo về nhân viên, bảng lương và các báo cáo khác. Quản lý đăng nhập vào hệ thống, yêu cầu tạo báo cáo, và hệ thống 
 sẽ lấy dữ liệu từ cơ sở dữ liệu và xuất báo cáo dưới dạng file.
   
![Diagram](https://www.planttext.com/api/plantuml/png/J8x13OCm54FlVmelq0KuL5JYs5CxmOTyeKWaGJyVfCpMGqVg2Wq5f1vjFrl-lDvjDbPRmaGyM5BSNF2H-hH4nrhmBDaaa4JpLj2nSSzPY7uOBjS3G8Dx6b6RXwx92TVi8QPULe6htX-ohpJeV9udBb2Pangr4jtsw0i00F__0m00)
## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
- Trong quy trình tạo báo cáo hành chính, các subsystem bao gồm Report Generation Subsystem (tạo báo cáo) và Database Subsystem (lấy dữ liệu từ cơ sở dữ liệu) giúp tách biệt trách nhiệm giữa việc tính toán và lưu trữ dữ liệu.
![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9ZIcvc7bTIVcbUIc9HfK9GQa5-KObxQbvgKM99PdvUS6bISMLnIMekGebBOabYKc9nAaAA2so8WguTRkqALa2vmjBKuXAe6YxSIe7cODW1rE-MMfAS0PRXmfGcQ7T9QL4UH3DUYo4-iL88ACeloqn9XJdM8JKl1HHc00000F__0m00)

## 3. Describe Persistence-Related Behavior
### Mô tả: 
- Dữ liệu về nhân viên, bảng lương và các báo cáo sẽ được lưu trữ trong cơ sở dữ liệu. Mỗi khi người dùng yêu cầu báo cáo, hệ thống sẽ truy xuất dữ liệu từ các bảng lưu trữ này và xuất dưới dạng báo cáo cho người dùng.
  
![Diagram](https://www.planttext.com/api/plantuml/png/RCzB2i8m403GVKunvt1LeIww4T4J37GiWKbIfjD544_cmYDv1IV4sWgkvlz2NezdCocApe4THVMQuH16JfceHKMuEG3eMjY1Zrho8mQoQbBnSIYD2p9AjjQL4wgxBym9ioJcLLdShVPPseSqH_qQDh2pyanlOINFD2RHgjLyQ_tpwzOlrb3iotVV0000__y30000)

## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Người dùng đăng nhập vào hệ thống.
- Quản lý yêu cầu hệ thống tạo báo cáo hành chính.
- Hệ thống lấy dữ liệu từ cơ sở dữ liệu.
- Dữ liệu được sử dụng để tạo báo cáo.
- Báo cáo được xuất và gửi lại cho người dùng.

### 4.2 Alternative Flow:
- Nếu dữ liệu không được tìm thấy hoặc không đầy đủ, hệ thống sẽ thông báo lỗi và yêu cầu người dùng nhập lại thông tin.
### Lý Do:
- Lý do này để đảm bảo tính linh hoạt khi dữ liệu thay đổi hoặc có lỗi trong quá trình truy xuất.

## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- Hợp nhất các lớp và hệ thống con:
- Hệ thống tạo báo cáo có thể bao gồm các lớp như ReportManager để xử lý logic tạo báo cáo, EmployeeData và PayrollData để lưu trữ thông tin người lao động và bảng lương. Các lớp này cùng làm việc trong ReportGenerationSubsystem để đáp ứng yêu cầu của quản lý.

![Diagram](https://www.planttext.com/api/plantuml/png/T951Zi8m34NtFKN42XPp0HOZ941ejiDSmBIVWaZIo7ON5U9aB3ZIN64A2IYb6Y-_dV_ydT_hRI5AhAspHQ3oH3NCv1kXOJLB1kcnyMRRxgGJXPkOSs7wAYs9c3YsWGUJDfnwiVZH-rgDf9yk81Fh-1hHQphBMlkZLV2Ab99yoTXh5spJ0GCeaZZ0Ud8vi4BeupfupKGXIzoD87VsZWIl_0FQ7beUddjaQoRB_YB3LD7v_MWVdwyiSrEJ7i1Ygjxjl-dHKlF8adJWub8iuAlxX_u1003__mC0)


# Use Case: Maintain Timecard
## 1. Describe Interaction Among Design Objects
### Mô tả:
- Ca sử dụng này cho phép người dùng (nhân viên hoặc quản lý) theo dõi và chỉnh sửa thời gian làm việc của nhân viên. Nhân viên nhập dữ liệu thời gian làm việc và hệ thống lưu trữ thông tin vào cơ sở dữ liệu.
   
![Diagram](https://www.planttext.com/api/plantuml/png/R8-n3G8n34LxJ-45M802NG4T5Pd0kLWGSOcHuu0osnMCn0e4wQxYog_tzAJ_cTz3CLAhQG8QJHHFwJ59OmOlDGVIXguLumISBLh38nbvAWomchWxB0xkyInNZ1cMtSdgTtPXqyXFHek9HzA0eSFjZgi-HSENw1rlKhLi9ntzvGREuNVd2m00__y30000)

## 2. Simplify Sequence Diagrams Using Subsystems
### Mô tả: 
- Ca sử dụng này có thể được chia thành các subsystem như Timecard Subsystem (quản lý dữ liệu thời gian làm việc) và Database Subsystem (lưu trữ dữ liệu).
![Diagram](https://www.planttext.com/api/plantuml/png/T9112W8n34NtFKKku0Lc8GCgk5TmdKuZ5AUDfAdGiyt28ta5fmCwY-ekyFxB3tbDppufYkOm6XoK1GxXFd8XCfPpT2W5pZxGWE9EsQQIbCAAzgXeCT6ApCU7pROreODv3bxXmdA38sT9fatDQhEvglYW1PYM_cchmSLplsk-rtQmutZr4b0zHzDJTFKdRm000F__0m00)

## 3. Describe Persistence-Related Behavior
### Mô tả:
- Thông tin về thời gian làm việc của nhân viên được lưu trữ trong cơ sở dữ liệu. Mỗi khi nhân viên nhập hoặc chỉnh sửa giờ làm, thông tin đó sẽ được lưu và cập nhật vào cơ sở dữ liệu.

![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTgNabcIQL2I6PkQd9YKOfBOacYGZMNWeA2Qsv1JdvbQggdYuALGcPU2KZC8x-qg3WyloWxDGKec9QJdmWM1cfA1V9JW1HNBPT3QbuAo6G00000__y30000)
## 4. Refine the Flow of Events Description
### 4.1 Basic Flow:
- Nhân viên đăng nhập vào hệ thống.
- Nhân viên nhập dữ liệu thời gian làm việc.
- Hệ thống kiểm tra tính hợp lệ của dữ liệu.
- Dữ liệu được lưu trữ trong cơ sở dữ liệu.
### 4.2 Alternative Flow:
- Nếu dữ liệu không hợp lệ (như giờ làm không hợp lệ), hệ thống sẽ thông báo lỗi và yêu cầu nhân viên nhập lại.
### Lý Do:
- Điều này giúp đảm bảo rằng dữ liệu chính xác và hợp lệ trước khi được lưu trữ trong cơ sở dữ liệu.

## 5. Unify Classes and Subsystems
### Hợp nhất các lớp và hệ thống con:
- Hệ thống có thể bao gồm lớp TimecardManager để xử lý dữ liệu thời gian làm việc, lớp TimecardData để lưu trữ các ghi chép thời gian làm việc của nhân viên. Các lớp này làm việc trong TimecardSubsystem để quản lý dữ liệu.

![Diagram](https://www.planttext.com/api/plantuml/png/R94z3i8m38NtdYBg10CNO40TMWa65gZ4719JeZP9vQH25Uh963WILo3zLLhm-DdnUy_vlDwHiHHj9OkWf2od6P0m5H8OHKwEL3aWGLbohgwcDXPaI9u1SSKAQWoPHdlObntW8VRWNLTeBXfpu1vzE11J2nwgIkx0k7YrxbgDfvd8ij0rm4mJ1ZZJL5JwcqjjX1LQBLmLzMbqq2oYfUXk8bGsfP_dRBlxDjVWSXaWKHRhMOBfNflTb6DB49X6Rhh3aPl6dz6_NhQ3KlykQ88856y_yWi00F__0m00)


