PHÂN TÍCH KIẾN THÚC
Đề xuất kiến trúc : Kiến trúc ba lớp  Presentation Layer (Giao diện người dùng), Business Logic Layer (Xử lý nghiệp vụ) và Data Access Layer (Truy cập dữ liệu)
Lý do em chọn kiến trúc này : phân tách rõ ràng, phân tách các hệ thống theo chức năng cụ thể, tái sử dụng mã nguồn và dễ dàng kiểm thử 
ý nghĩa : 
Tầng Presentation: hiển thị các thành phần giao diện để tương tác với người dùng như tiếp nhận thông tin, thông báo lỗi, …
Tầng Business Logic: thực hiện các hành động nghiệp vụ của phần mềm như tính toán, đánh giá tính hợp lệ của thông tin, … Tầng này còn di chuyển, xử lí thông tin giữa 2 tầng trên dưới.
Tầng Data: nơi lưu trữ và trích xuất dữ liệu từ các hệ quản trị CSDL hay các file trong hệ thống. Cho phép tầng Business logic thực hiện các truy vấn dữ liệu .
biểu đồ package : https://www.planttext.com/api/plantuml/png/R9A_JiCm4CRtUufJ5wOC_1rGLLKg0Y4aX6WbvYEnKYkE7Mm7AKBCp3m2GmU6Ye6j6JhqIVm4VGNiX1OYnOlFztq_d-_aRRqU6qlQbha0at69MXa6bbl1y8xYZ59cCF9XfPKGEAsCPJb0qKeuk5K96-1m6FRH25y0_Oe56OCFIcTC7yBhF_izYot9L3HCEFGoHntcKec4wG2qKIzot4KqvKs99kW5JZh0jRHCIsO3Cn6gJ7gPqmvpGPOUoJHrTd4lTXQm0vpDkLkjBGgtMXRuL9B4kQlVCEMk_YACDnynffjl3c6M64KZt4yBpt7gwYKchbx85FxomTLEnLic_hfFWjzp8uNslNB5IQ4DvGjeSq7TDUqDDytBfAlVEUpJmRDhp7jckgpmsQqM4c3CP1A-p0y0003__mC0
CƠ CHẾ PHÂN TÍCH
Cơ chế xác thực và phân quyền:
Giúp đảm bảo chỉ những người có quyền hạn (như Payroll Administrator) mới có thể truy cập và quản lý thông tin nhạy cảm như thông tin lương của nhân viên.
Cơ chế tính toán lương:
Hệ thống cần có khả năng tính toán lương dựa trên loại nhân viên (nhân viên theo giờ, nhân viên nhận lương cố định, nhân viên nhận lương hoa hồng). Cơ chế này bao gồm việc xác định mức lương dựa trên số giờ làm việc, mức lương cơ bản, hoặc hoa hồng bán hàng.
Cơ chế chấm công và quản lý thời gian:
Để tính toán lương chính xác, hệ thống cần ghi lại thông tin về số giờ làm việc của nhân viên (timecard). Điều này giúp đảm bảo thông tin thời gian làm việc được cập nhật và lưu trữ chính xác.
Cơ chế xử lý thanh toán:
Xác định phương thức thanh toán (chuyển khoản ngân hàng, nhận lương trực tiếp, gửi qua bưu điện) và thực hiện thanh toán tương ứng cho nhân viên vào thời điểm thích hợp.
Cơ chế lưu trữ và truy vấn dữ liệu:
Cần có khả năng lưu trữ thông tin liên quan đến nhân viên, bảng chấm công, và lương một cách nhất quán và an toàn, đồng thời cung cấp khả năng truy vấn nhanh chóng khi cần thiết.
Cơ chế thông báo và nhắc nhở:
Tạo thông báo về các sự kiện quan trọng như thời gian thanh toán lương hoặc nhắc nhở chấm công.
PHÂN TÍCH CA SỬ DỤNG PAYMENT
