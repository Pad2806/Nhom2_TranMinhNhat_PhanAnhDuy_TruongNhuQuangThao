<?php
include("connect.php");
header('Content-Type: application/json; charset=UTF-8');
if (!isset($_GET['MaTacGia']) || empty($_GET['MaTacGia']) ||!isset($_GET['TenTacGia']) || empty($_GET['TenTacGia'])||!isset($_GET['SoLuongTP']) || empty($_GET['SoLuongTP'])) {
    echo json_encode(array("message" => "Tham số không hợp lệ.", JSON_UNESCAPED_UNICODE));
    exit;
}
$maTG=$_GET['MaTacGia'];
$tenTG=$_GET['TenTacGia'];
$slTP=$_GET['SoLuongTP'];
$sql = "UPDATE TacGia
        SET TenTacGia=?,SoLuongTP=?
        WHERE MaTacGia = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("sssss",  $maTG,$tenTG,$slTP);

if ($stmt->execute()) {
    echo json_encode(array("message" => "Sửa tác giả thành công.", JSON_UNESCAPED_UNICODE));
} else {
    echo json_encode(array("message" => "Không thể sửa tác giả.", JSON_UNESCAPED_UNICODE));
}
$stmt->close();
$conn->close();  // Đóng kết nối sau khi xong
?>