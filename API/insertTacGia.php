<?php
include("connect.php");
header('Content-Type: application/json; charset=UTF-8');
// Tạo mã giỏ hàng mới
$sqlMaTacGia = "SELECT GenerateNewOrderCode() AS ma_tac_gia";
$resultTacGia = $conn->query($sqlMaTacGia);
if ($resultTacGia && $resultTacGia->num_rows > 0) {
    $rowTacGia = $resultTacGia->fetch_assoc();
    $MaTacGia = $rowTacGia['ma_tac_gia'];
} else {
    echo json_encode(array("message" => "Không thể tạo mã tác giả.", JSON_UNESCAPED_UNICODE));
    exit;
}
$tenTG=$_GET['TenTacGia'];
$slTP=$_GET['SoLuongTP'];
$hinhanh="https://drive.google.com/file/d/1F1HUdbMmJBzmuPWZ3MPvu0VFSok9iDUL/view?usp=drive_link";
// Thêm giỏ hàng vào bảng GioHang
$sqlInsert = "INSERT INTO TacGia (MaTacGia,TenTacGia,SoLuongTP,HinhAnhHinhAnh) 
              VALUES (?,?,?,?)";
$stmt = $conn->prepare($sqlInsert);
if ($stmt) {
    $stmt->bind_param("ssss", $MaTacGia, $tenTG, $slTP, $hinhanh);
    if ($stmt->execute()) {
        echo json_encode(array("message" => "Thêm tác giả thành công.", JSON_UNESCAPED_UNICODE));
    } else {
        echo json_encode(array("message" => "Không thể thêm tác giả.", JSON_UNESCAPED_UNICODE));
    }
    $stmt->close();
} else {
    echo json_encode(array("message" => "Lỗi khi chuẩn bị truy vấn.", JSON_UNESCAPED_UNICODE));
}
$stmt->close();
$conn->close();  // Đóng kết nối sau khi xong
?>