### Biểu đồ ngữ cảnh
 ### BankSystem Subsystem Context Diagram
 ![Diagram](https://www.planttext.com/api/plantuml/png/d9DBJiCm48RtFiNiMYJQ0qHHLF6Iigie5t2TARNgs94zGKJ0oLXm9Aw0xQR1TNVDmahcyS_ydvpVxv-L8swfRnLZCtZ0dTG8j4UuDvgiKGej2CMTO_64DHz2DCcMfJX-L1LyC8YFxVLOEBzXNvbohGdjZWjaylG6zHtNXytW2Dj9fC7EE4bpxgN47iMXWDFRBVXM4teA26UjTyQsdAJHb_Cs_TOTbTVMl0z7Eo3RJc6BcgH-ZMNJCgFJPAEoT9D65pGIgrjVzcAvTbo4yNK31Mp8UjMnWBUcr-IZJyfm6eCUElKkBxtUSRBiOb5DNNaywsGfzl9pkKnCPn0VFIWQsM5o6U8O3mXZFdBn_Fy99jCkgcRmZ2gct5vsZbtUhR1pkcC1ZRGew4JAGPplu4toCpDd4F94Je6jK3VX3_W3003__mC0)
 
  PayrollController: xử lý việc thanh toán lương cho nhân viên bằng cách sử dụng hệ thống ngân hàng để gửi tiền.
  
  IBankSystem: dùng để xử lý các giao dịch chuyển tiền trực tiếp vào tài khoản ngân hàng.
  
  BankSystem: Đây là lớp triển khai của IBankSystem, được xem là lớp proxy tương tác với hệ thống cơ sở dữ liệu ngân hàng để gửi tiền trực tiếp vào tài khoản.
  
  Entities
   * Paycheck: Đối tượng phiếu lương để gửi vào ngân hàng.
   * BankInformation: Đối tượng chứa thông tin ngân hàng.
    

 ### PrintService Subsystem Context Diagram
![Diagram](https://www.planttext.com/api/plantuml/png/h5FBJeGm5DttAxfpJ9pvWCQOYOy52uqP_84A5sZI1salAZw-p8MVv2zOe621P5R3WfRxEkVSU_dz_jaxv1OR9GavexTG20qKAw0tHgCrKeAbcUJEaVvD7wtG6Fa-2EsVkhCVe3OMDtmu6HtEYy6PwCAm8R-xMiLH67rElXR0YKQm1S-0YF56apuj1ViY_DVfCTFcsRKEGVbOyzOEYgbGjGG56eKk-x29KDoCaxAQ2xtytErc80lQTvuQ1hOmJcY0ckZu20cCfkZBbC6M-VbvMPFL0qU28ax_edW9gNXV5vB6tfjyRQy5EDOrBEuAs0Uk88QToRasZSwvRTSB1tRoZOmSwFp91EycvyZ7kc6y1v2z1bU9sf7btcwtLukjOhJfcZYpTL5B0iohKwhH8kC8ZhuAhDP9OGX7QyPz3e5axrLr_-8V0000__y30000)

PrintController: Một lớp điều khiển chịu trách nhiệm khởi chạy quá trình in các báo cáo hoặc phiếu lương.

IPrintService: xác định phương thức in. 

PrintService: Một lớp xử lý in tương tác với máy in để in báo cáo hoặc phiếu lương. Lớp này sẽ triển khai giao diện IPrintService.

Entities
 * Report: Đối tượng báo cáo hoặc phiếu lương cần in.
 * PrintInformation: Đối tượng chứa thông tin in, chẳng hạn như số bản sao, định dạng giấy, cài đặt máy in.

 ### ProjectManagementDatabase Subsystem Context Diagram
 ![Diagram](https://www.planttext.com/api/plantuml/png/h5DBJiCm4Dtx5BC35cN1CaAeQeD45rI8dc2IJXE3FyKUjqJ0oLXm9Av0axQHqr1LGcGHEVORlyzClZ-_XfxHST1AY3D8QI4D0PS4OslOMQN8GQxGUz6yuS7P9yevEdqJq3oEs4bQqGwH8kCvZajq1Ks3piWb47zTY8y3nebXSWlCISZz2YRHRHbw-ZDR0X6oHpqBcQyyawvHhzNMCKYzLAJ9i3H50sjrTSEuHuD50_n_cRq0hjylBuyJ7_YwtMZddHtQjp0cR8MkK0LAOBQHQugQkEEmlhw5BhTxataBx-nFKTF1INxKy0wmjkvv0x-pmVa4KXioHRqcZMmmStHLPnxJqLKlz9T0hcgYRbPxCR_Dm2CfP6cDB-NIY_vm3mOt_HbC8DHf7kz-NHKBIo2tMWSZSsJoi9PSdgZkz2Xfn-WKQTokk4eCoSphV_m7003__mC0)
 
ProjectController: Lớp điều khiển để quản lý và truy cập thông tin dự án liên quan đến chi phí, charge numbers, và thời gian làm việc.

IProjectDatabase: định nghĩa các phương thức truy vấn thông tin từ cơ sở dữ liệu.

ProjectManagementDatabase: Một lớp proxy để kết nối với cơ sở dữ liệu DB2 chứa thông tin dự án. Lớp này triển khai giao diện IProjectDatabase.

Entities
* ChargeNumber: Đối tượng mã chi phí liên kết với các dự án.
* ProjectData: Đối tượng chứa dữ liệu dự án được truy xuất từ cơ sở dữ liệu.

## 2. Analysis class to design element map

Ánh xạ các lớp phân tích đến các phần tử thiết kế
| **Các lớp phân tích** | **Phần tử thiết kế** |
|---------------------|--------------------|
|Employee            |EmployeeManagementService  |
|Timecard         |TimecardProcessingModule   |
|Paycheck          |PayrollProcessingService |
|PurchaseOrder        |CommissionProcessingModule	   |
|BankSystem     |BankTransactionService |
|ProjectManagement      |ProjectManagementService |
|Document    |PrintService |
