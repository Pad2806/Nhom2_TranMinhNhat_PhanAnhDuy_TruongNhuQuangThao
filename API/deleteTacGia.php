<?php
include("connect.php");
header('Content-Type: application/json; charset=UTF-8');
if (!isset($_GET['MaTacGia']) || empty($_GET['MaTacGia'])) {
    echo json_encode(array("message" => "Tham số MaTacGia không hợp lệ.", JSON_UNESCAPED_UNICODE));
    exit;
}
$maTG=$_GET['MaTacGia'];
$sql = "DELETE
        FROM TacGia
        WHERE MaTacGia = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s",  $maTG);

if ($stmt->execute()) {
    echo json_encode(array("message" => "Xóa tác giả thành công.", JSON_UNESCAPED_UNICODE));
} else {
    echo json_encode(array("message" => "Không thể xóa tác giả.", JSON_UNESCAPED_UNICODE));
}
$stmt->close();
$conn->close();  // Đóng kết nối sau khi xong
?>