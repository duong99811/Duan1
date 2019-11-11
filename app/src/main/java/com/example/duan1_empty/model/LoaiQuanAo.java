package com.example.duan1_empty.model;

public class LoaiQuanAo {
    private String maloaiquanao;
    private String tenloaiquanao;
    private String hangquanao;
    private String mota;

    public LoaiQuanAo(String maloaiquanao, String tenloaiquanao, String hangquanao, String mota) {
        this.maloaiquanao = maloaiquanao;
        this.tenloaiquanao = tenloaiquanao;
        this.hangquanao = hangquanao;
        this.mota = mota;
    }

    public LoaiQuanAo() {

    }

    public String getMaloaiquanao() {
        return maloaiquanao;
    }

    public void setMaloaiquanao(String maloaiquanao) {
        this.maloaiquanao = maloaiquanao;
    }

    public String getTenloaiquanao() {
        return tenloaiquanao;
    }

    public void setTenloaiquanao(String tenloaiquanao) {
        this.tenloaiquanao = tenloaiquanao;
    }

    public String getHangquanao() {
        return hangquanao;
    }

    public void setHangquanao(String hangquanao) {
        this.hangquanao = hangquanao;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
