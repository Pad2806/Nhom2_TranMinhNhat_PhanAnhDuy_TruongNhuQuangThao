package com.ktck124.lop124LTDD04.nhom2;

public class TacGia {
    private String TenTacGia,SoLuongTP,HinhAnh;

    public TacGia(String tenTacGia, String soLuongTP, String hinhAnh) {
        TenTacGia = tenTacGia;
        SoLuongTP = soLuongTP;
        HinhAnh = hinhAnh;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }

    public String getSoLuongTP() {
        return SoLuongTP;
    }

    public void setSoLuongTP(String soLuongTP) {
        SoLuongTP = soLuongTP;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
