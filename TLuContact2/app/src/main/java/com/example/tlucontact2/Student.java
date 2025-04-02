package com.example.tlucontact2;

public class Student {
    private String maSinhVien;
    private String hoTen;
    private String diaChiEmail;
    private String diaChi;
    private String lopHoc;

    public Student(String maSinhVien, String hoTen, String diaChiEmail, String diaChi, String lopHoc) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChiEmail = diaChiEmail;
        this.diaChi = diaChi;
        this.lopHoc = lopHoc;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }


    public String getDiaChiEmail() {
        return diaChiEmail;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getLopHoc() {
        return lopHoc;
    }
}
