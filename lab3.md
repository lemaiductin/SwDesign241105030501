### Xác định các phần tử thiết kế cho hệ thống "Payroll System".
 ### BankSystem Subsystem Context Diagram
 ![Diagram](https://www.planttext.com/api/plantuml/png/d9DBJiCm48RtFiNiMYJQ0qHHLF6Iigie5t2TARNgs94zGKJ0oLXm9Aw0xQR1TNVDmahcyS_ydvpVxv-L8swfRnLZCtZ0dTG8j4UuDvgiKGej2CMTO_64DHz2DCcMfJX-L1LyC8YFxVLOEBzXNvbohGdjZWjaylG6zHtNXytW2Dj9fC7EE4bpxgN47iMXWDFRBVXM4teA26UjTyQsdAJHb_Cs_TOTbTVMl0z7Eo3RJc6BcgH-ZMNJCgFJPAEoT9D65pGIgrjVzcAvTbo4yNK31Mp8UjMnWBUcr-IZJyfm6eCUElKkBxtUSRBiOb5DNNaywsGfzl9pkKnCPn0VFIWQsM5o6U8O3mXZFdBn_Fy99jCkgcRmZ2gct5vsZbtUhR1pkcC1ZRGew4JAGPplu4toCpDd4F94Je6jK3VX3_W3003__mC0)
 
  PayrollController: xử lý việc thanh toán lương cho nhân viên bằng cách sử dụng hệ thống ngân hàng để gửi tiền.
  
  IBankSystem: dùng để xử lý các giao dịch chuyển tiền trực tiếp vào tài khoản ngân hàng.
  
  BankSystem: Đây là lớp triển khai của IBankSystem, được xem là lớp proxy tương tác với hệ thống cơ sở dữ liệu ngân hàng để gửi tiền trực tiếp vào tài khoản.
  
  Entities
   * Paycheck: Đối tượng phiếu lương để gửi vào ngân hàng.
   * BankInformation: Đối tượng chứa thông tin ngân hàng.
    

 ### PrintService Subsystem Context Diagram
![Diagram](https://www.planttext.com/api/plantuml/png/h5DBJiCm4Dtx5BEZID03H55KyLbq0K8D5p39jBNaJsHFWF8v6GkEn1MmuwGuYSIgMSIUZz-yDnx_V7sl775BhPACdS4DReL6e3t2jT5aZPHeePBSETRzuS4AJKaipwje50MyC-Y-9kHii36M5Zok6SJr8WRNUckoY1MsLd4IHf-ppmc9jIQqMruX4yCErjsn4kspyDRfQvRjapiuGkLppUiXgWUX6eaADGczwzAEXDB63ApoV89ogkwCnUSVo-Mey4JAhQTBlG8SRZ2MyXInYnR5GCnR4ZCeoGFkUb-uN9ztz7eAYTo4NOBtfvJli1HlSqnfx9sfv_v6eCj2PzDMeRtd2bC68urNfjKrjuVvbA8znWP63dNzQFheekR41zn-3ZOeEpbkBnh7fiD-ULbCnY-3DdHsv0jPKmAPLwTKgqN52Hsy2DhF3_Ktyozcsl8-aQsygl20Vm400F__0m00)

PrintController: Một lớp điều khiển chịu trách nhiệm khởi chạy quá trình in các báo cáo hoặc phiếu lương.

IPrintService: xác định phương thức in. 

PrintService: Một lớp xử lý in tương tác với máy in để in báo cáo hoặc phiếu lương. Lớp này sẽ triển khai giao diện IPrintService.

Entities
 * Report: Đối tượng báo cáo hoặc phiếu lương cần in.
 * PrintInformation: Đối tượng chứa thông tin in, chẳng hạn như số bản sao, định dạng giấy, cài đặt máy in.

 ### ProjectManagementDatabase Subsystem Context Diagram
 ![Diagram](https://www.planttext.com/api/plantuml/png/f5JDJi904BxlKynDFS31OzCG0ZMHWyJ84qpBK5Rt1_S7RDGdy-0Z-Ggs1Pfj2o7H7fhTpZVxVJFpRN--liVMeN5U2iQk8A4LLmHkJJ3LoXaj11d815hBwZSy6lrCcGkYSPpjDwCHl3Ee7qFESDhI0PsWmskShj7aDFSo9HD1kBjXdntscN9aLfWHuySLp8BJKhJqPxO80cIFUk5JMrX7iaAz5VlgWSkD84dASPNNi4PNkp4Fg32lWOtCEEwU-OzEzRJtkX9_38VdrNIAlIiBSeSQwJZZaB1KJpKcqBn5uIc2HQbSvPM6LWSgfbDPctrujcmoMz_dAAaJoSwsuG3OQVDImk-rDpQ2HFjKK6-U4-tL4atHid4okUtPwDMJAUe1rAkZc5DsUIA1ZcjbrtnZMVzE30QZlbqZy5MFpnkboWg5HP1fARtY6JgoiEDkVI6xDRceCTSbqd1oOHORarfMluPV0000__y30000)
 
ProjectController: Lớp điều khiển để quản lý và truy cập thông tin dự án liên quan đến chi phí, charge numbers, và thời gian làm việc.

IProjectDatabase: định nghĩa các phương thức truy vấn thông tin từ cơ sở dữ liệu.

ProjectManagementDatabase: Một lớp proxy để kết nối với cơ sở dữ liệu DB2 chứa thông tin dự án. Lớp này triển khai giao diện IProjectDatabase.

Entities
* ChargeNumber: Đối tượng mã chi phí liên kết với các dự án.
* ProjectData: Đối tượng chứa dữ liệu dự án được truy xuất từ cơ sở dữ liệu.

## 2. Analysis class to design element map

Ánh xạ các lớp phân tích đến các phần tử thiết kế BankSystem
| **Analysis** | **Design Element** |
|---------------------|--------------------|
|PayrollController            |PayrollController  |
|IBankSystem         |IBankSystem   |
|BankSystem          |BankSystem |
|Paycheck        |Paycheck	   |
|BankInformation     |BankInformation |

Ánh xạ các lớp phân tích đến các phần tử thiết kế PrintService
| **Analysis** | **Design Element** |
|---------------------|--------------------|
|PrintController            |PrintController |
|IPrintService         |IPrintService   |
|PrintService          |PrintService |
|Report        |Report	   |
|PrintInformation     |PrintInformation |

Ánh xạ các lớp phân tích đến các phần tử thiết kế ProjectManagementDatabase
| **Analysis** | **Design Element** |
|---------------------|--------------------|
|ProjectController            |ProjectController|
|IProjectDatabase         |IProjectDatabase |
|ProjectManagementDatabase	          |ProjectManagementDatabase	|
|ChargeNumber        |ChargeNumber	|
|ProjectData     |ProjectData|

## 3. Design element to owning package map
Ánh xạ các phần tử thiết kế vào các gói BankSystem
| **Design Element** | "Owning" Package |
|---------------------|--------------------|
|PayrollController            |Applications::Payroll  |
|IBankSystem         |Middleware::BankServices   |
|BankSystem          |Middleware::BankServices |
|Paycheck        |Business Services::Payroll Artifacts  |
|BankInformation     |Business Services::Bank Details |

Ánh xạ các phần tử thiết kế vào các gói PrintService
| **Design Element** | "Owning" Package |
|---------------------|--------------------|
|PrintController            |Applications::PrintManagement |
|IPrintService         |Middleware::Services::Interfaces |
|PrintService          |Middleware::Services|
|Report        |Business Services::DocumentArtifacts|
|PrintInformation     |Business Services::PrintSettings|

Ánh xạ các phần tử thiết kế vào các gói ProjectManagementDatabase
| **Design Element** | "Owning" Package |
|---------------------|--------------------|
|ProjectController        |Applications::ProjectManagement|
|IProjectDatabase         |Middleware::DataAccess::Interfaces |
|ProjectManagementDatabase	          |Middleware::DataAccess|
|ChargeNumber        |Business Services::ProjectArtifacts|
|ProjectData     |Business Services::ProjectInfo|

## 4. Design element to owning package map
### Biểu đồ mô tả các layer
![Diagram](https://www.planttext.com/api/plantuml/png/Z5H1RjKm4Dtd5AFkUu4kKFjR2LNYeufo0TSniVc9apfEgmgnG5smG4YmPW6XwewA8h5gXBfmzU-H4_GAZ9qFttPIgHj76i-RUVFUEFVTxNQjYT9DaIU9ObGJcUKCDdQgAXUKQ57AUWFU9007v4oLURvRIcs_JC4Mt7qIVVUkWGN7xxc4uyQqe9Nv8JbeJknPcbPQj19IFneh1aZv6Waz6dJSz3SN4dBp1zA--mMsyTjWgBb8qvoT4iM6aRoh6P6BGwPE16MhUG7sNV2irgp0ray5AI75jkybS3nnmBxxB3EGcVcE8VDDPWuMe9xrtPSA6Gvq5vm8oBn2NWl48jk0r8YGKt4LZIZXo1yeXvE-knpaMsc-pfwWCWB53FQ89ZiKAVWSd2tsveZKCGswRA7kkw-sz4_8RR1Psp6mSlWvaIHZ1PD-fPS-kSbIKoPRsg7HiwOM4ab3g22kCEMCBh3J0IxGpMq3-V9wsJhZh1FxybMf2hVrbWqtlz5VBMJayGjMbKfZnioq9L0y_ctuWmMSkhkSg8mzRueZjynpSm6K2wYukLhlkvK3B_UczCCfnyzmS_D9lAfzzr5OjaKIlpkN7A-Hdnw_kHLWvFaQa_ZDRRedys7VNLdwbwXRd3OMtCzEGfOMy5_seEeeRSA8k70uZGL5raGTnlcXMK7zRIPJ-plz2m00__y30000)
