/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI MODERN
 */

public class Warga extends User {
    private String alamat;
    private String nomorRumah;

    public Warga(String idUser, String nama, String alamat, String nomorRumah) {
        super(idUser, nama);
        this.alamat = alamat;
        this.nomorRumah = nomorRumah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorRumah() {
        return nomorRumah;
    }

    public void setNomorRumah(String nomorRumah) {
        this.nomorRumah = nomorRumah;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Warga     : " + getIdUser());
        System.out.println("Nama         : " + getNama());
        System.out.println("Alamat       : " + alamat);
        System.out.println("Nomor Rumah  : " + nomorRumah);
    }
}